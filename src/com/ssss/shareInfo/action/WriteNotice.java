package com.ssss.shareInfo.action;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.omg.IOP.ServiceContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssss.shareInfo.model.Admin;
import com.ssss.shareInfo.model.Notice;
import com.ssss.shareInfo.model.Receivenotice;
import com.ssss.shareInfo.model.Sendnotice;
import com.ssss.shareInfo.model.Tree;
import com.ssss.shareInfo.service.NoticeService;
import com.ssss.shareInfo.service.ReceiveNoticeService;
import com.ssss.shareInfo.service.SendNoticeService;

import flexjson.JSONSerializer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WriteNotice extends ActionSupport implements ModelDriven<Notice>{
	String nodes;
	Notice notice=new Notice();
	
	private int total;
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private int pageNumber=1;
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	private NoticeService noticeService;

	public NoticeService getNoticeService() {
		return noticeService;
	}

	@Resource(name="noticeService")
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	private SendNoticeService sendNoticeService;
	public SendNoticeService getSendNoticeService() {
		return sendNoticeService;
	}

	@Resource(name="sendNoticeService")
	public void setSendNoticeService(SendNoticeService sendNoticeService) {
		this.sendNoticeService = sendNoticeService;
	}

	private ReceiveNoticeService receiveNoticeService;
	
	
	public ReceiveNoticeService getReceiveNoticeService() {
		return receiveNoticeService;
	}
	@Resource(name="receiveNoticeService")
	public void setReceiveNoticeService(ReceiveNoticeService receiveNoticeService) {
		this.receiveNoticeService = receiveNoticeService;
	}

	/*
	 * 写公告
	 * */
	public String execute() {
		Date date=new Date();
		Timestamp time=new Timestamp(date.getTime());
		notice.setTime(time);
		//String json= ServletActionContext.getRequest().getParameter("nodes");
		//	JSONArray  jsonArray = JSONArray.fromObject(nodes);
		//  List<Tree> trees = (List<Tree>)JSONArray.toCollection(jsonArray, Tree.class);
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		String username= (String) ServletActionContext.getRequest().getSession().getAttribute("username");
		notice.setSid(id);
		notice.setSname(username);
		notice.setDeleteSign(false);
		noticeService.save(notice);
		
		/*DetachedCriteria criteria=DetachedCriteria.forClass(Notice.class);
		criteria.add(Restrictions.eq("content", notice.getContent()));
		List<Notice> k=noticeService.findByCriteria(criteria);
		notice.setId(k.get(k.size()-1).getId());*/
		Sendnotice sn=new Sendnotice();
		sn.setNotice(notice);
		sn.setSender(id);//
		sn.setDeleteSign(false);
		sn.setReadedNumber(0);
		sendNoticeService.save(sn);
		
		
		String []s=nodes.split(",");
		for(String string:s){
			if(string!=null && (string.length()==7 || string.length()==10)){
				Receivenotice receivenotice=new Receivenotice();
				receivenotice.setNotice(notice);
				receivenotice.setReadSign(false);
				receivenotice.setDeleteSign(false);
				receivenotice.setReceiver(Integer.parseInt(string));
				receiveNoticeService.save(receivenotice);
				System.out.println(string);
			}
		}
		return SUCCESS;
	}

	List<Receivenotice> receivenotices=new ArrayList<Receivenotice>();
	int k=0;
	//显示公告
	public String showNotice() {
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		DetachedCriteria criteria=DetachedCriteria.forClass(Receivenotice.class,"n");
		criteria.add(Restrictions.eq("receiver", id));
		criteria.add(Restrictions.eq("deleteSign", false));
		criteria.createAlias("notice", "da").add( Restrictions.eq("da.deleteSign", false)) ;//"notice.deleteSign", false));
		receivenotices=receiveNoticeService.findAllById(criteria);
		/*for (Receivenotice receivenotice:receivenotices) {
			System.out.println(receivenotice.getNotice().getTitle()+"dsadasdas"+receivenotices.size());
		}*/
		k=receivenotices.size();
		Collections.reverse(receivenotices);
		ServletActionContext.getRequest().setAttribute("receivenotices",receivenotices);
		return SUCCESS;
	}
	
	private int rid;
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	/*
	 * 标记删除公告
	 * */
	public String deleteNotice() {
		System.out.println(rid);
		DetachedCriteria criteria=DetachedCriteria.forClass(Receivenotice.class);
		criteria.add(Restrictions.eq("id", rid));
		Receivenotice receivenotice=receiveNoticeService.findByCriteria(criteria);
		receivenotice.setDeleteSign(true);
		
		System.out.println(receivenotice);
		receiveNoticeService.update(receivenotice);
		return NONE;
	}
	
	/*
	 * 管理员标记删除公告
	 * */
	public String adminDeleteNotice() {
		System.out.println(rid);
		DetachedCriteria criteria=DetachedCriteria.forClass(Notice.class);
		criteria.add(Restrictions.eq("id", rid));
		Notice notice=noticeService.findByCriteria(criteria).get(0);
		notice.setDeleteSign(true);
		
		//System.out.println(receivenotice);
		noticeService.update(notice);
		return NONE;
	}
	
	public List<Receivenotice> getReceivenotices() {
		return receivenotices;
	}

	
	List<Notice> notices=new ArrayList<Notice>();
	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	/*
	 *管理员显示公告 
	 * */
	public String adminShowNotice() throws IOException {
		DetachedCriteria criteria=DetachedCriteria.forClass(Notice.class);
		criteria.add(Restrictions.eq("deleteSign", false));
		total=noticeService.findCountByCriteria(criteria);   //计算 数量
		criteria=DetachedCriteria.forClass(Notice.class);
		criteria.add(Restrictions.eq("deleteSign", false));
		int first=total-20*pageNumber;
		int end=20;
		if(first<0){
			end=20+first;
			first=0;
		}
		notices=noticeService.findByCriteria(criteria,first,end);  //分页查询
		Collections.reverse(notices);       //反转排序
		for(Notice notice:notices){
			System.out.println(notice.getContent());
		}
		if(pageNumber!=1){
			JSONSerializer jsonSerializer=new JSONSerializer();
			jsonSerializer.exclude("*.class");
			String resultJson=jsonSerializer.deepSerialize(notices);
		
			//发回客户端
			ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().print(resultJson);
			ServletActionContext.getResponse().getWriter().close();
			System.out.println(resultJson);
		}
		
	//	ServletActionContext.getResponse().getWriter().close();
		//System.out.println(first+"  "+end+"  "+pageNumber);
		return SUCCESS;
	}
	public void setReceivenotices(List<Receivenotice> receivenotices) {
		this.receivenotices = receivenotices;
	}
	
	
	@Override
	public Notice getModel() {
		// TODO Auto-generated method stub
		return notice;
	}
}
