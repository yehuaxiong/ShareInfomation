package com.ssss.shareInfo.model;

import java.util.List;

/**
 * ��ҳ��ѯ�Ľ������
 * @author LEO
 *
 */

public class PageResponse<T>{
	private int total;//���ݿ��м�¼������
	private List<T> rows;//���м�¼�ļ���
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
