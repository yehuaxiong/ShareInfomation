package com.ssss.shareInfo.model;

import java.util.List;

/**
 * ��ҳ��ѯ�Ľ������
 * @author LEO
 *
 */

public class PageResponseStudent {
	private int total;//���ݿ��м�¼������
	private List<StudentShow> rows;//���м�¼�ļ���
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
