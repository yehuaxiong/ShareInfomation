package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Addfriendnotice;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.service.AddFriendNoticeService;

@Component("addFriendNoticeService")
public class AddfriendnoticeImpl implements AddFriendNoticeService {

	GenericDAO<Addfriendnotice> genericDAO;
	public GenericDAO<Addfriendnotice> getGenericDAO() {
		return genericDAO;
	}
	@Resource(name="genericDAO")
	public void setGenericDAO(GenericDAO<Addfriendnotice> genericDAO) {
		this.genericDAO = genericDAO;
	}
	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		return genericDAO.findByTotalCount(new Addfriendnotice());
	}

	@Override
	public void save(Addfriendnotice addfriendnotice) {
		// TODO Auto-generated method stub
		genericDAO.save(addfriendnotice);
	}

	@Override
	public List<Addfriendnotice> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria);
	}

	@Override
	public int findCountByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria).size();
	}

	@Override
	public void update(Addfriendnotice addfriendnotice) {
		// TODO Auto-generated method stub
		genericDAO.update(addfriendnotice);
	}

	@Override
	public List<Addfriendnotice> findByCriteria(DetachedCriteria criteria,
			int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria, firstResult, maxResults);
	}
	@Override
	public Addfriendnotice findById(int id) {
		return genericDAO.findById(Addfriendnotice.class, id);
	}

}
