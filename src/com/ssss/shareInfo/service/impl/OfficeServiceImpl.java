package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.service.OfficeService;

@Component("officeService")
public class OfficeServiceImpl implements OfficeService {
	
	GenericDAO<Office> genericDAO;
	public GenericDAO<Office> getGenericDAO() {
		return genericDAO;
	}
	@Resource(name="genericDAO")
	public void setGenericDAO(GenericDAO<Office> genericDAO) {
		this.genericDAO = genericDAO;
	}
	@Override
	public Office findOffice(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		List<Office> list=genericDAO.findByCriteria(criteria);
		if(list.size()>0) return list.get(0);
		return null;
	}
	@Override
	public List<Office> findAll() {
		// TODO Auto-generated method stub
		Office o=new Office();
		return genericDAO.findAll(o);
	}
	@Override
	public int findByCriteriaCount(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		List<Office> list=genericDAO.findByCriteria(criteria);
		return list.size();
	}

}
