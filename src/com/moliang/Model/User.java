package com.moliang.Model;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	/*	1 Id Int(12) 编号 
	  2 Email Varchar(50) 登录名 
	  3 Password Varchar(50) 用户密码 
	  4 NickName Varchar(50) 用户名 
	  5 User_integral Int(12) 用户等级 
	  6 Email_Verify Char(3) 邮箱是否激活 
	  7 Email_Verify_Code Varchar(50) 邮箱激活验证码 
	  8 Last_Login_Time Bigint(20) 最后登录的时间 
	  9 Last_Login_IP Varchar(15) 最后登录的IP*/
/*`id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '登录账户',
  `passwd` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '登录密码',
  `nickname` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户昵称',
  `avatar` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像',
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',*/
	
	private int id;
	private String account;
	private String passwd;
	private String nickname;
	private String avatar;
	private String phone;
	private String email;
	private Timestamp create_at;
	
	public User() {
		super();
	}
	public User(int id, String account, String passwd, String nickname, String avatar, String phone, String email,
			Timestamp create_at) {
		super();
		this.id = id;
		this.account = account;
		this.passwd = passwd;
		this.nickname = nickname;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
		this.create_at = create_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}
	
	
	
	/*private String User_Id;
	private String Email;
	private String Password;
	private String NickName;
	private String Phone;
	private int User_integral;
	private String Email_Verify;
	private String Email_Verify_Code;
	private Date Create_Time;
	private Date Last_Login_Time;
	private String Last_Login_Ip;
	private String Message;
	
	
	public User() {

	}

	public User(String user_Id, String email, String password, String nickName, String phone, int user_integral,
			String email_Verify, String email_Verify_Code, Date create_Time, Date last_Login_Time, String last_Login_Ip,
			String message) {
		super();
		User_Id = user_Id;
		Email = email;
		Password = password;
		NickName = nickName;
		Phone = phone;
		User_integral = user_integral;
		Email_Verify = email_Verify;
		Email_Verify_Code = email_Verify_Code;
		Create_Time = create_Time;
		Last_Login_Time = last_Login_Time;
		Last_Login_Ip = last_Login_Ip;
		Message = message;
	}


	public String getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(String id) {
		User_Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public int getUser_integral() {
		return User_integral;
	}
	public void setUser_integral(int user_integral) {
		User_integral = user_integral;
	}
	public String getEmail_Verify() {
		return Email_Verify;
	}
	public void setEmail_Verify(String email_Verify) {
		Email_Verify = email_Verify;
	}
	public String getEmail_Verify_Code() {
		return Email_Verify_Code;
	}
	public void setEmail_Verify_Code(String email_Verify_Code) {
		Email_Verify_Code = email_Verify_Code;
	}
	
	public Date getCreate_Time() {
		return Create_Time;
	}

	public void setCreate_Time(Date create_Time) {
		Create_Time = create_Time;
	}

	public Date getLast_Login_Time() {
		return Last_Login_Time;
	}
	public void setLast_Login_Time(Date last_Login_Time) {
		Last_Login_Time = last_Login_Time;
	}
	public String getLast_Login_Ip() {
		return Last_Login_Ip;
	}
	public void setLast_Login_Ip(String last_Login_Ip) {
		Last_Login_Ip = last_Login_Ip;
	}
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}*/
	
	
}
