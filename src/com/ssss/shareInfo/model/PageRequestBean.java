package com.ssss.shareInfo.model;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 分页查询的请求数据
 * @author LEO
 *
 */

public class PageRequestBean {
	private int page;//要跳转到的页码
	private int rows;//每页的行数
	
	private DetachedCriteria detachedCriteria;//分离式条件查询的类

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
