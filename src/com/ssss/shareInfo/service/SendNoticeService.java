package com.ssss.shareInfo.service;

import com.ssss.shareInfo.model.Notice;
import com.ssss.shareInfo.model.Sendnotice;

public interface SendNoticeService {
	public int findAllCount();
	public void save(Sendnotice sendnotice);
}
