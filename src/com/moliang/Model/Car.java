package com.moliang.Model;

import java.sql.Timestamp;

public class Car {
	/*
	 `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL COMMENT '货物id',
  `goods_count` int(11) DEFAULT NULL COMMENT '加入的该物品数量',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '购物创建时间',
  */
	private int id;
	private int user_id;
	private int goods_id;
	private int goods_count;
	private Timestamp created_at;
	
	public Car() {
		super();
	}
	public Car(int id, int user_id, int goods_id, int goods_count, Timestamp created_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.goods_count = goods_count;
		this.created_at = created_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
}
