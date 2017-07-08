package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Chatmessage;


public interface ChatMessageService {

	public int findAllCount();
	public void save(Chatmessage chatmessage);
	public List<Chatmessage> findByCriteria(DetachedCriteria criteria);
	public int findCountByCriteria(DetachedCriteria criteria);
	public void update(Chatmessage chatmessage);
	public List<Chatmessage> findByCriteria(DetachedCriteria criteria, int firstResult,int maxResults);

}
