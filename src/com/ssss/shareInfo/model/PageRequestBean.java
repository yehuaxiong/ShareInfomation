package com.ssss.shareInfo.model;

import org.hibernate.criterion.DetachedCriteria;

/**
 * ��ҳ��ѯ����������
 * @author LEO
 *
 */

public class PageRequestBean {
	private int page;//Ҫ��ת����ҳ��
	private int rows;//ÿҳ������
	
	private DetachedCriteria detachedCriteria;//����ʽ������ѯ����

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
}
