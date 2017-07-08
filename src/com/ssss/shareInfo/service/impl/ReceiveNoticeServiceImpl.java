package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Receivenotice;
import com.ssss.shareInfo.model.Sendnotice;
import com.ssss.shareInfo.service.ReceiveNoticeService;

@Component("receiveNoticeService")
public class ReceiveNoticeServiceImpl implements ReceiveNoticeService {

	GenericDAO<Receivenotice> genericDAO;
	@Resource(name="genericDAO")
	public void setGenericDAO(GenericDAO<Receivenotice> genericDAO) {
		this.genericDAO = genericDAO;
	}
	public GenericDAO<Receivenotice> getGenericDAO() {
		return genericDAO;
	}
	
	@Override
	public void save(Receivenotice receivenotice) {
		// TODO Auto-generated method stub
		genericDAO.save(receivenotice);
	}
	@Override
	public List<Receivenotice> findAll(Receivenotice receivenotice) {
		// TODO Auto-generated method stub
		return genericDAO.findAll(receivenotice);
	}
	@Override
	public List<Receivenotice> findAllById(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		
		return genericDAO.findByCriteria(criteria);
	}
	@Override
	public void update(Receivenotice receivenotice) {
		// TODO Auto-generated method stub
		genericDAO.update(receivenotice);
	}
	@Override
	public Receivenotice findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria).get(0);
	}

}
