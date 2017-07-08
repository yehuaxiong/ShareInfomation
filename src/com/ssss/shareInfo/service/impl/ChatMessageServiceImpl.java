package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Chatmessage;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.service.ChatMessageService;

@Component("chatMessageService")
public class ChatMessageServiceImpl implements ChatMessageService {

	GenericDAO<Chatmessage> genericDAO;
	public GenericDAO<Chatmessage> getGenericDAO() {
		return genericDAO;
	}
	@Resource(name="genericDAO")
	public void setGenericDAO(GenericDAO<Chatmessage> genericDAO) {
		this.genericDAO = genericDAO;
	}
	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		return genericDAO.findByTotalCount(new Chatmessage());
	}

	@Override
	public void save(Chatmessage chatmessage) {
		// TODO Auto-generated method stub
		genericDAO.save(chatmessage);
	}

	@Override
	public List<Chatmessage> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria);
	}

	@Override
	public int findCountByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria).size();
	}

	@Override
	public void update(Chatmessage chatmessage) {
		// TODO Auto-generated method stub
		genericDAO.save(chatmessage);
	}

	@Override
	public List<Chatmessage> findByCriteria(DetachedCriteria criteria,
			int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria, firstResult, maxResults);
	}

}
