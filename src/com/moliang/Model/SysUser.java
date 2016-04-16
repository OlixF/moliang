package com.moliang.Model;

public class SysUser {
	private int user_id;//用户ID
	private String user_name;//用户名
	private String user_pwd;//用户密码
	private String real_name;//真实的名字
	private int user_role;//用户权限
	
	public SysUser() {
	}
	
	public SysUser(int user_id, String user_name, String user_pwd,
			String real_name, int user_role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.real_name = real_name;
		this.user_role = user_role;
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	
	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	

}
