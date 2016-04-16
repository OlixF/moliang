package com.moliang.Model;

import java.util.Date;

public class SysOffice {
	private int info_id;
	private Date info_time;
	private String info_role;
	private String info_title;
	private String info_content;
	private String comment;
	
	
	public SysOffice() {
		super();
	}
	public SysOffice(Date info_time,String info_role, String info_title, String info_content,
			String comment) {
		super();
		this.info_time = info_time;
		this.info_role = info_role;
		this.info_title = info_title;
		this.info_content = info_content;
		this.comment = comment;
	}
	
	public SysOffice(int info_id, Date info_time, String info_role,
			String info_title, String info_content, String comment) {
		super();
		this.info_id = info_id;
		this.info_time = info_time;
		this.info_role = info_role;
		this.info_title = info_title;
		this.info_content = info_content;
		this.comment = comment;
	}
	public String getInfo_role() {
		return info_role;
	}
	public void setInfo_role(String info_role) {
		this.info_role = info_role;
	}
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public Date getInfo_time() {
		return info_time;
	}
	public void setInfo_time(Date info_time) {
		this.info_time = info_time;
	}
	public String getInfo_title() {
		return info_title;
	}
	public void setInfo_title(String info_title) {
		this.info_title = info_title;
	}
	public String getInfo_content() {
		return info_content;
	}
	public void setInfo_content(String info_content) {
		this.info_content = info_content;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
