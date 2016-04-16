package com.moliang.Model;

public class SysMenu {
	private int menu_id;//����ID
	private String menu_name;//������
	private String menu_link;//���ӵ�ַ
	private String menu_state;//�˵�״̬
	private int parent_id;//����˵�ID
	private String menu_icon;//�˵�ͼ��
	private String comment;//��ע

	public SysMenu() {
		super();

	}
	
	public SysMenu(String menu_name, String menu_link,
			String menu_icon, int parent_id, String comment) {
		super();
		this.menu_name = menu_name;
		this.menu_link = menu_link;
		this.menu_icon = menu_icon;
		this.parent_id = parent_id;
		this.comment = comment;
	}
	public SysMenu(String menu_name, String menu_link,
			String menu_icon,String comment,int menu_id) {
		super();
		this.menu_name = menu_name;
		this.menu_link = menu_link;
		this.menu_icon = menu_icon;
		this.comment = comment;
		this.menu_id = menu_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_link() {
		return menu_link;
	}
	public void setMenu_link(String menu_link) {
		this.menu_link = menu_link;
	}
	public String getMenu_state() {
		return menu_state;
	}
	public void setMenu_state(String menu_state) {
		this.menu_state = menu_state;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}
	
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
