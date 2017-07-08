package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Claname;

public interface ClanameService {
	public List<Claname> findAll();
	public Claname findCla(DetachedCriteria criteria);
	public List<Claname> findClas(DetachedCriteria criteria);
}
