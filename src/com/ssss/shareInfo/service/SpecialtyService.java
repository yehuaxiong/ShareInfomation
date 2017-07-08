package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Specialty;

public interface SpecialtyService {
	public List<Specialty> findAll();
	
	public Specialty findSpec(DetachedCriteria criteria);
	
	public List<Specialty> findSpecs(DetachedCriteria criteria);
}
