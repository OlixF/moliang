package com.moliang.Model;

import java.sql.Timestamp;

public class Liked {
	/*
	 `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '所属用户id',
  `goods_id` int(11) DEFAULT NULL COMMENT '货物id',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	 */
	private int id;
	private int user_id;
	private int goods_id;
	private Timestamp creaated_at;
	
	public Liked() {
		super();
	}
	public Liked(int id, int user_id, int goods_id, Timestamp creaated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.creaated_at = creaated_at;
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
	public Timestamp getCreaated_at() {
		return creaated_at;
	}
	public void setCreaated_at(Timestamp creaated_at) {
		this.creaated_at = creaated_at;
	}
	
}
