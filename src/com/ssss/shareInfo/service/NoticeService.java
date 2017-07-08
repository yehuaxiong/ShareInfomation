package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Notice;

public interface NoticeService {
	public int findAllCount();
	public void save(Notice notice);
	public List<Notice> findByCriteria(DetachedCriteria criteria);
	public int findCountByCriteria(DetachedCriteria criteria);
	public void update(Notice notice);
	public List<Notice> findByCriteria(DetachedCriteria criteria, int firstResult,int maxResults); 
}
