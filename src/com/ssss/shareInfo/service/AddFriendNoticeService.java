package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Addfriendnotice;

public interface AddFriendNoticeService {
	public int findAllCount();
	public void save(Addfriendnotice addfriendnotice);
	public List<Addfriendnotice> findByCriteria(DetachedCriteria criteria);
	public int findCountByCriteria(DetachedCriteria criteria);
	public void update(Addfriendnotice addfriendnotice);
	public List<Addfriendnotice> findByCriteria(DetachedCriteria criteria, int firstResult,int maxResults);
	public Addfriendnotice findById(int id);
}
