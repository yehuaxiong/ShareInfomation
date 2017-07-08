package com.ssss.shareInfo.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Addfriendnotice;
import com.ssss.shareInfo.model.Friend;
import com.ssss.shareInfo.model.FriendId;
import com.ssss.shareInfo.model.FriendNoticeShow;
import com.ssss.shareInfo.model.PageResponse;
import com.ssss.shareInfo.model.Student;
import com.ssss.shareInfo.service.AddFriendNoticeService;
import com.ssss.shareInfo.service.FriendService;
import com.ssss.shareInfo.service.StudentService;

import flexjson.JSONSerializer;

public class Firend2Action extends ActionSupport implements ModelDriven<Addfriendnotice>{
	private Addfriendnotice addfriendnotice=new Addfriendnotice();
	@Override
	public Addfriendnotice getModel() {
		return addfriendnotice;
	}
	
	String nodes;	
	public String getNodes() {
		return nodes;
	}
	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	
	private AddFriendNoticeService addFriendNoticeService;
	@Resource(name="addFriendNoticeService")
	public void setAddFriendNoticeService(
			AddFriendNoticeService addFriendNoticeService) {
		this.addFriendNoticeService = addFriendNoticeService;
	}
	
	/*
	 * 添加好友 
	 * */
	public String AddFirend(){
		String contentString=addfriendnotice.getContent();
		
		Date date=new Date();
		Timestamp time=new Timestamp(date.getTime());
		
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		String username= (String) ServletActionContext.getRequest().getSession().getAttribute("username");
		//if(nodes==null) return NONE;
		String []s=nodes.split(",");
		
		for(String string:s){
			addfriendnotice=new Addfriendnotice();
			addfriendnotice.setTime(time);
			addfriendnotice.setSendId(id);
			addfriendnotice.setSendName(username);
			addfriendnotice.setContent(contentString);
			addfriendnotice.setDeletedSign(false);
			
			addfriendnotice.setReceiveId(Integer.parseInt(string));
				
			addFriendNoticeService.save(addfriendnotice);		
		}	
		
		return NONE;
	}

	//--------------------------------------------------------------------------
	
	private int page;//要跳转到的页码
	private int rows;//每页的行数	
	private DetachedCriteria detachedCriteria;//分离式条件查询的类
		
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
			
	/*
	 * 新朋友
	 * */
	public String AddFriendNotice(){
		int firstResult=(page-1)*rows;
		int maxResults=rows;	
		
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		
		detachedCriteria=DetachedCriteria.forClass(Addfriendnotice.class);
		detachedCriteria.add(Restrictions.eq("receiveId", id));
		detachedCriteria.add(Restrictions.eq("deletedSign", false));
		
		List<Addfriendnotice> addfriendnotices=addFriendNoticeService.findByCriteria(detachedCriteria, firstResult, maxResults);
		
		List<FriendNoticeShow> friendNoticeShows=new ArrayList<FriendNoticeShow>();
		FriendNoticeShow friendNoticeShow;
		
		for(Addfriendnotice afn:addfriendnotices){			
			friendNoticeShow=new FriendNoticeShow();
			friendNoticeShow.setId(afn.getId());
			friendNoticeShow.setSendId(afn.getSendId());
			friendNoticeShow.setSendName(afn.getSendName());
			friendNoticeShow.setContent(afn.getContent());
			friendNoticeShow.setTime(afn.getTime().toString());
			friendNoticeShows.add(friendNoticeShow);
		}
		
				
//		PageResponse<Addfriendnotice> pageResponse=new PageResponse<Addfriendnotice>();
//	
//		pageResponse.setRows(addfriendnotices);
//			
//		int total=addFriendNoticeService.findCountByCriteria(detachedCriteria);
//		pageResponse.setTotal(total);
		
		PageResponse<FriendNoticeShow> pageResponse=new PageResponse<FriendNoticeShow>();
		
		pageResponse.setRows(friendNoticeShows);
			
		int total=addFriendNoticeService.findCountByCriteria(detachedCriteria);
		pageResponse.setTotal(total);
		
		//将结果转换为json
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(pageResponse);
		
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");	
		try {
			ServletActionContext.getResponse().getWriter().print(resultJson);
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	
	//-----------------------------------------------------------------------------
	
	
	private int id_;
	private int noticeId;
	public int getId_() {
		return id_;
	}
	public void setId_(int id_) {
		this.id_ = id_;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	private FriendService friendService;
	@Resource(name="friendService")
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	
	private StudentService studentService;
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	/**
	 * 同意好友请求
	 */	
	public String AgreeFriend(){
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%同意请求！");
		int myId= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		
		Friend friend=new Friend();
		Friend friend2=new Friend();
		FriendId friendId=new FriendId();
		FriendId friendId2=new FriendId();
		
		friendId.setMyId(myId);
		friendId.setFriendId(id_);
		
		friendId2.setMyId(id_);
		friendId2.setFriendId(myId);

		
		friend.setId(friendId);
		friend2.setId(friendId2);
		
		Student stu=studentService.findStudent(id_);
		Student stu2=studentService.findStudent(myId);
		
		friend.setFriendName(stu.getName());
		friend.setFriendPname(stu.getClaname().getCname());
		
		friend2.setFriendName(stu2.getName());
		friend2.setFriendPname(stu2.getClaname().getCname());
		
		friendService.save(friend);
		friendService.save(friend2);
		
		Addfriendnotice afn=addFriendNoticeService.findById(noticeId);
		afn.setDeletedSign(true);
		addFriendNoticeService.update(afn);
		
		return NONE;
	}
	
	
	//----------------------------------------------------------------------------
	
	/**
	 * 忽略好友请求
	 */
	
	public String IgnoreFriend(){
		Addfriendnotice afn=addFriendNoticeService.findById(noticeId);
		afn.setDeletedSign(true);
		addFriendNoticeService.update(afn);
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%忽略好友请求"+noticeId);
		
		return NONE;
	}
	
}
