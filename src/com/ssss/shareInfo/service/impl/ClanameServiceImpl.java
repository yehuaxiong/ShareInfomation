package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Claname;
import com.ssss.shareInfo.service.ClanameService;

@Component("clanameService")
public class ClanameServiceImpl implements ClanameService {
	public GenericDAO<Claname>  clanameDao;		
	public GenericDAO<Claname> getClanameDao() {
		return clanameDao;
	}
	@Resource
	public void setClanameDao(GenericDAO<Claname> clanameDao) {
		this.clanameDao = clanameDao;
	}
	
	@Override
	public List<Claname> findAll() {
		Claname claname=new Claname();
		return clanameDao.findAll(claname);
	}
	
	@Override
	public Claname findCla(DetachedCriteria criteria) {
		List<Claname> clas=clanameDao.findByCriteria(criteria);
		if(clas.size()>0){
			return clas.get(0);
		}
		return null;
	}
	@Override
	public List<Claname> findClas(DetachedCriteria criteria) {
		List<Claname> clas=clanameDao.findByCriteria(criteria);
		if(clas.size()>0){
			return clas;
		}
		return null;
	}


}
