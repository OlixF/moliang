package com.moliang.Model;

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
	private String User_Id;
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
	}
	
	
}
