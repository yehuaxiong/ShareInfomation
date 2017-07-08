package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Receivenotice;

public interface ReceiveNoticeService {
	public void save(Receivenotice receivenotice);
	public List<Receivenotice> findAll(Receivenotice receivenotice);
	public List<Receivenotice> findAllById(DetachedCriteria criteria);
	public void update(Receivenotice receivenotice);
	public Receivenotice findByCriteria(DetachedCriteria criteria);
}
