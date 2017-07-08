package com.ssss.shareInfo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssss.shareInfo.model.Friend;

public interface FriendService {

	public int findAllCount();
	public void save(Friend friend);
	public List<Friend> findByCriteria(DetachedCriteria criteria);
	public int findCountByCriteria(DetachedCriteria criteria);
	public void update(Friend friend);
	public List<Friend> findByCriteria(DetachedCriteria criteria, int firstResult,int maxResults);

}
