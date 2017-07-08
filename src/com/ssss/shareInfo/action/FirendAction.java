package com.ssss.shareInfo.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssss.shareInfo.model.Chatmessage;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.model.Friend;
import com.ssss.shareInfo.model.Receivenotice;
import com.ssss.shareInfo.service.ChatMessageService;
import com.ssss.shareInfo.service.FriendService;
import com.ssss.shareInfo.service.StudentService;

import flexjson.JSONSerializer;

public class FirendAction extends ActionSupport {
	
	private FriendService	friendService;

	private ChatMessageService chatMessageService;

	private List<Chatmessage> chatmessages;
	private List<Friend> friends;

	private Chatmessage chatmessage=new Chatmessage();
	
	private int friendId;
	private String content;

	/*
	 * 好友列表
	 * */
	public String FriendList(){
		DetachedCriteria criteria=DetachedCriteria.forClass(Friend.class,"a");
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		//criteria.createAlias("id", "p").add( Restrictions.eq("p.myId", 123)) ;
		criteria.add( Restrictions.eq("id.myId", id)) ;
		friends=friendService.findByCriteria(criteria);
		/*for(Friend friend : friends){
			System.out.println(friend.getFriendName());
		}*/
		return SUCCESS;
	}
	
	/*
	 * 发送聊天
	 * */
	public String Chat_content() {
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		String username= (String) ServletActionContext.getRequest().getSession().getAttribute("username");
		
		
		System.out.println(friendId+" ----------  "+content);
		chatmessage.setContent(content);
		chatmessage.setReadedSign(false);
		chatmessage.setReceiveId(friendId);
		chatmessage.setSendId(id);
		chatmessage.setSendName(username);
		
		
		chatMessageService.save(chatmessage);
		
		return NONE;
	}
	
	/*
	 * 我是会话
	 * */
	public String Huihua() throws IOException {
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		DetachedCriteria criteria=DetachedCriteria.forClass(Chatmessage.class);
		criteria.add(Restrictions.eq("receiveId", id));
		criteria.add(Restrictions.eq("readedSign", false));
		chatmessages=chatMessageService.findByCriteria(criteria);
		
		if(chatmessages==null)	chatmessages=new ArrayList<Chatmessage>();

		HashMap<String, Integer> mp=new HashMap<String, Integer>();
		
		System.out.println(chatmessages.size()+" ppppppppppppppppppppppppppp");
		//计算数量
		List<Chatmessage> mes=new ArrayList<Chatmessage>();
		for(Chatmessage chatmessage:chatmessages){
			if( mp.get(chatmessage.getSendId().toString())==null){
				mes.add(chatmessage);
				mp.put(chatmessage.getSendId().toString(), 1);
			}
			else
				mp.put(chatmessage.getSendId().toString(), mp.get(chatmessage.getSendId())+1);
		}
		System.out.println("ooooooooooooooooooooooooooooooooooa");
		//设置数量
		for(Chatmessage chatmessage:mes){
			chatmessage.setContent(mp.get(chatmessage.getSendId().toString()).toString());
			System.out.println("---------------------------"+chatmessage.getContent());
		}
	//	System.out.println( mp.get(chatmessages.get(0).getSendId().toString()));
		
		if(mes.size()==0) {
			chatmessage.setId(0);
			mes.add(chatmessage);
		}
		System.out.println(mes.size()+"------------------------------------------------------");
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(mes);
	
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);
		ServletActionContext.getResponse().getWriter().close();
		System.out.println(resultJson);
		
		
		return NONE;
	}
	
	
	/*
	 * 聊天
	 * */
	public String Chat() throws IOException {
		//System.out.println(friendId+"-------------");
		int id= (Integer) ServletActionContext.getRequest().getSession().getAttribute("id");
		DetachedCriteria criteria=DetachedCriteria.forClass(Chatmessage.class);
		criteria.add(Restrictions.eq("receiveId", id));
		criteria.add(Restrictions.eq("sendId", friendId));
		criteria.add(Restrictions.eq("readedSign", false));
		chatmessages=chatMessageService.findByCriteria(criteria);
		
		for(Chatmessage chatmessage:chatmessages){
			chatmessage.setReadedSign(true);
			chatMessageService.update(chatmessage);
		}
		
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		String resultJson=jsonSerializer.deepSerialize(chatmessages);
	
		//发回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(resultJson);
		ServletActionContext.getResponse().getWriter().close();
		System.out.println(resultJson);
		
		return NONE;
	}
	
	public List<Chatmessage> getChatmessages() {
		return chatmessages;
	}
	public void setChatmessages(List<Chatmessage> chatmessages) {
		this.chatmessages = chatmessages;
	}
	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}


	public FriendService getFriendService() {
		return friendService;
	}

	@Resource(name="friendService")
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	

	
	public ChatMessageService getChatMessageService() {
		return chatMessageService;
	}

	@Resource(name="chatMessageService")
	public void setChatMessageService(ChatMessageService chatMessageService) {
		this.chatMessageService = chatMessageService;
	}
	
}
