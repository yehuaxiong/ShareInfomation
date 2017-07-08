package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Office;

public interface OfficeService {
	public Office findOffice(DetachedCriteria criteria);
	public List<Office> findAll();
	public int findByCriteriaCount(DetachedCriteria criteria);
}
