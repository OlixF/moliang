package com.moliang.Model;

public class SysPageBean {
	private int page; // �ڼ�ҳ
	private int rows; // ÿҳ��¼��
	
	public SysPageBean(int rows,int page) {
		super();
		this.page = page;
		this.rows = rows;
	}
	
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
	
}
