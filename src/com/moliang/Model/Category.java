package com.moliang.Model;

import java.sql.Timestamp;

public class Category {
	/*`id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '分类类别名字',
  `acount` int(11) DEFAULT '0' COMMENT '该分类下物品数量',
  `parent_id` int(11) DEFAULT '-1' COMMENT '所属父分类id，目前默认为-1没有父类，需要时可扩充',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  */
	private int id;
	private String name;
	private int acount;
	private int parent_id;
	private Timestamp created_id;
	
	public Category() {
		super();
	}
	public Category(int id, String name, int acount, int parent_id, Timestamp created_id) {
		super();
		this.id = id;
		this.name = name;
		this.acount = acount;
		this.parent_id = parent_id;
		this.created_id = created_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public Timestamp getCreated_id() {
		return created_id;
	}
	public void setCreated_id(Timestamp created_id) {
		this.created_id = created_id;
	}
	
}
