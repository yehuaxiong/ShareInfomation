package com.ssss.shareInfo.model;

import java.util.List;

/**
 * 分页查询的结果数据
 * @author LEO
 *
 */

public class PageResponseStudent {
	private int total;//数据库中记录的总数
	private List<StudentShow> rows;//所有记录的集合
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<StudentShow> getRows() {
		return rows;
	}
	public void setRows(List<StudentShow> rows) {
		this.rows = rows;
	}
	
}
