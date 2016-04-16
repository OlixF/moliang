package com.moliang.Model;

public class SysPageBean {
	private int page; // 第几页
	private int rows; // 每页记录数
	
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
