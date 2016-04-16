package com.moliang.Model;

import java.util.Date;

public class SysStudent {
	
	private String student_NO;//学员编号
	private String student_name;//姓名
	private String student_sex;//性别
	private Date student_birth;//出生日期
	private String student_card;//身份证
	private String student_minz;//民族
	private String student_zzmm;//政治面貌
	private String student_phone;//手机号码
	private String student_email;//邮箱
	private String student_qq;//qq号码
	private String student_address;//家庭地址
	private String student_school;//学校名称
	private String student_major;//专业
	private String student_job;//就业意向
	private String comment;//备注
	
	public SysStudent() {
		super();
	}
	public SysStudent(String student_NO, String student_name,
			String student_sex, Date student_birth, String student_card,
			String student_minz, String student_zzmm, String student_phone,
			String student_email, String student_qq, String student_address,
			String student_school, String student_major, String student_job,
			String comment) {
		super();
		this.student_NO = student_NO;
		this.student_name = student_name;
		this.student_sex = student_sex;
		this.student_birth = student_birth;
		this.student_card = student_card;
		this.student_minz = student_minz;
		this.student_zzmm = student_zzmm;
		this.student_phone = student_phone;
		this.student_email = student_email;
		this.student_qq = student_qq;
		this.student_address = student_address;
		this.student_school = student_school;
		this.student_major = student_major;
		this.student_job = student_job;
		this.comment = comment;
	}
	public String getStudent_NO() {
		return student_NO;
	}
	public void setStudent_NO(String student_NO) {
		this.student_NO = student_NO;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	public Date getStudent_birth() {
		return student_birth;
	}
	public void setStudent_birth(Date student_birth) {
		this.student_birth = student_birth;
	}
	public String getStudent_card() {
		return student_card;
	}
	public void setStudent_card(String student_card) {
		this.student_card = student_card;
	}
	public String getStudent_minz() {
		return student_minz;
	}
	public void setStudent_minz(String student_minz) {
		this.student_minz = student_minz;
	}
	public String getStudent_zzmm() {
		return student_zzmm;
	}
	public void setStudent_zzmm(String student_zzmm) {
		this.student_zzmm = student_zzmm;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_qq() {
		return student_qq;
	}
	public void setStudent_qq(String student_qq) {
		this.student_qq = student_qq;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	public String getStudent_school() {
		return student_school;
	}
	public void setStudent_school(String student_school) {
		this.student_school = student_school;
	}
	public String getStudent_major() {
		return student_major;
	}
	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}
	public String getStudent_job() {
		return student_job;
	}
	public void setStudent_job(String student_job) {
		this.student_job = student_job;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
