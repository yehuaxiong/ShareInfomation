package com.ssss.shareInfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ssss.shareInfo.dao.GenericDAO;
import com.ssss.shareInfo.model.Notice;
import com.ssss.shareInfo.model.Sendnotice;
import com.ssss.shareInfo.service.SendNoticeService;

@Component("sendNoticeService")
public class SendNoticeImpl implements SendNoticeService {

	GenericDAO<Sendnotice> genericDAO;
	@Resource(name="genericDAO")
	public void setGenericDAO(GenericDAO<Sendnotice> genericDAO) {
		this.genericDAO = genericDAO;
	}
	public GenericDAO<Sendnotice> getGenericDAO() {
		return genericDAO;
	}
	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		return genericDAO.findByTotalCount(new Sendnotice());
	}

	@Override
	public void save(Sendnotice sendnotice) {
		// TODO Auto-generated method stub
		genericDAO.save(sendnotice);
	}

}
