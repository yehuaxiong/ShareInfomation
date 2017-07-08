package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Department;
import com.ssss.shareInfo.model.Specialty;
import com.ssss.shareInfo.service.SpecialtyService;

@Component("specialtyService")
public class SpecialtyServiceImpl implements SpecialtyService {
	public GenericDAO<Specialty>  specialtyDao;		
	public GenericDAO<Specialty> getSpecialtyDao() {
		return specialtyDao;
	}
	@Resource
	public void setSpecialtyDao(GenericDAO<Specialty> specialtyDao) {
		this.specialtyDao = specialtyDao;
	}
		
	@Override
	public List<Specialty> findAll() {
		Specialty specialty=new Specialty();
		return specialtyDao.findAll(specialty);
	}
	
	@Override
	public Specialty findSpec(DetachedCriteria criteria) {
		List<Specialty> specialties=specialtyDao.findByCriteria(criteria);
		if(specialties.size()>0){
			return specialties.get(0);
		}
		return null;
	}
	@Override
	public List<Specialty> findSpecs(DetachedCriteria criteria) {
		List<Specialty> specialties=specialtyDao.findByCriteria(criteria);
		if(specialties.size()>0){
			return specialties;
		}
		return null;
	}

}
