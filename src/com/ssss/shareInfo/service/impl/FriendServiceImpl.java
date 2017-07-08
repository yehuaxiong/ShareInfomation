package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Friend;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.service.FriendService;

@Component("friendService")
public class FriendServiceImpl implements FriendService {

	GenericDAO<Friend> genericDAO;
	public GenericDAO<Friend> getGenericDAO() {
		return genericDAO;
	}
	@Resource(name="genericDAO")
	public void setGenericDAO(GenericDAO<Friend> genericDAO) {
		this.genericDAO = genericDAO;
	}
	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		return genericDAO.findByTotalCount(new Friend());
	}

	@Override
	public void save(Friend friend) {
		// TODO Auto-generated method stub
		genericDAO.save(friend);
	}

	@Override
	public List<Friend> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria);
	}

	@Override
	public int findCountByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria).size();
	}

	@Override
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		genericDAO.save(friend);
	}

	@Override
	public List<Friend> findByCriteria(DetachedCriteria criteria,
			int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria, firstResult, maxResults);
	}

}
