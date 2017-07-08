package com.ssss.shareInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Notice;
import com.ssss.shareInfo.model.Office;
import com.ssss.shareInfo.service.NoticeService;
@Component("noticeService")
public class NoticeServiceImpl implements NoticeService {

	GenericDAO<Notice> genericDAO;
	@Resource(name="genericDAO")
	public void setGenericDAO(GenericDAO<Notice> genericDAO) {
		this.genericDAO = genericDAO;
	}
	public GenericDAO<Notice> getGenericDAO() {
		return genericDAO;
	}
	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		return genericDAO.findByTotalCount(new Notice());
	}
	
	@Override
	public void save(Notice notice) {
		// TODO Auto-generated method stub
		genericDAO.save(notice);
	}
	@Override
	public List<Notice> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria);
	}
	@Override
	public void update(Notice notice) {
		// TODO Auto-generated method stub
		genericDAO.update(notice);
	}
	
	@Override
	public List<Notice> findByCriteria(DetachedCriteria criteria,
			int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return genericDAO.findByCriteria(criteria, firstResult, maxResults);
	}
	@Override
	public int findCountByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return (genericDAO.findByCriteria(criteria)).size();
	}

}
