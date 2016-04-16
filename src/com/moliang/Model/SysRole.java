package com.moliang.Model;

public class SysRole {

	private int role_id;//权限ID
	private String role_name;//权限名
	private String menu_role;//菜单权限
	private String role_comment;//权限备注
	
	public SysRole() {
		super();
	}
	
	public SysRole(int role_id, String role_name, String menu_role,
			String role_comment) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.menu_role = menu_role;
		this.role_comment = role_comment;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getMenu_role() {
		return menu_role;
	}
	public void setMenu_role(String menu_role) {
		this.menu_role = menu_role;
	}
	public String getRole_comment() {
		return role_comment;
	}
	public void setRole_comment(String role_comment) {
		this.role_comment = role_comment;
	}
	
	
}
