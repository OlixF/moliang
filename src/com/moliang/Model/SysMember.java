package com.moliang.Model;

import java.util.Date;

public class SysMember {
	private String member_number;//Ա�����
	private String member_name;//����
	private String member_sex;//�Ա�
	private Date member_birth;//��������
	private String member_card;//���֤��
	private String member_photo;//��Ƭ
	private String member_minz;//����
	private String member_hyzk;//����״��
	private String member_zzmm;//������ò
	private String member_phone;//��ϵ�绰
	private String member_email;//����
	private String member_qq;//qq����
	private String member_address;//��ϵ��ַ
	private String member_department;//��������
	private String member_job;//���ڸ�λ
	private String comment;//
	
	public SysMember(){
		
	}
	//�������ݹ��캯��
	public SysMember(String member_number, String member_sex,
			Date member_birth, String member_photo, String member_minz,
			String member_hyzk, String member_zzmm, String member_phone,
			String member_email, String member_qq, String member_address,
			String member_department, String member_job, String comment) {
		super();
		this.member_number = member_number;
		this.member_sex = member_sex;
		this.member_birth = member_birth;
		this.member_photo = member_photo;
		this.member_minz = member_minz;
		this.member_hyzk = member_hyzk;
		this.member_zzmm = member_zzmm;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_qq = member_qq;
		this.member_address = member_address;
		this.member_department = member_department;
		this.member_job = member_job;
		this.comment = comment;
	}
	//������ݹ��캯��
	public SysMember(String member_number, String member_name, String member_sex,
			Date member_birth, String member_card, String member_photo,
			String member_minz, String member_hyzk, String member_zzmm,
			String member_phone, String member_email, String member_qq,
			String member_address, String member_department, String member_job,
			String comment) {
		super();
		this.member_number = member_number;
		this.member_name = member_name;
		this.member_sex = member_sex;
		this.member_birth = member_birth;
		this.member_card = member_card;
		this.member_photo = member_photo;
		this.member_minz = member_minz;
		this.member_hyzk = member_hyzk;
		this.member_zzmm = member_zzmm;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_qq = member_qq;
		this.member_address = member_address;
		this.member_department = member_department;
		this.member_job = member_job;
		this.comment = comment;
	}
	public String getMember_number() {
		return member_number;
	}
	public void setMember_number(String member_number) {
		this.member_number = member_number;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_sex() {
		return member_sex;
	}
	public void setMember_sex(String member_sex) {
		this.member_sex = member_sex;
	}
	public Date getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(Date member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_card() {
		return member_card;
	}
	public void setMember_card(String member_card) {
		this.member_card = member_card;
	}
	public String getMember_photo() {
		return member_photo;
	}
	public void setMember_photo(String member_photo) {
		this.member_photo = member_photo;
	}
	public String getMember_minz() {
		return member_minz;
	}
	public void setMember_minz(String member_minz) {
		this.member_minz = member_minz;
	}
	public String getMember_hyzk() {
		return member_hyzk;
	}
	public void setMember_hyzk(String member_hyzk) {
		this.member_hyzk = member_hyzk;
	}
	public String getMember_zzmm() {
		return member_zzmm;
	}
	public void setMember_zzmm(String member_zzmm) {
		this.member_zzmm = member_zzmm;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_qq() {
		return member_qq;
	}
	public void setMember_qq(String member_qq) {
		this.member_qq = member_qq;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_department() {
		return member_department;
	}
	public void setMember_department(String member_department) {
		this.member_department = member_department;
	}
	public String getMember_job() {
		return member_job;
	}
	public void setMember_job(String member_job) {
		this.member_job = member_job;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
