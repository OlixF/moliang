package com.moliang.Model;

import java.sql.Timestamp;

public class Order {
	/*
	 `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) NOT NULL,
  `transport_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '快递单号',
  `transport_price` decimal(5,2) DEFAULT '0.00' COMMENT '运费',
  `addr` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收件地址',
  `price_count` decimal(10,2) NOT NULL COMMENT '订单总价',
  `goods_count` decimal(10,2) NOT NULL COMMENT '订单货物总量',
  `on_signoff` tinyint(1) DEFAULT '0' COMMENT '是否签收（完成交易)1代表完成,0代表未完成',
  `sign_time` datetime DEFAULT NULL COMMENT '订单完成时间',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单创建时间',
  */
	private int id;
	private String no;
	private int user_id;
	private String transport_no;
	private double transport_price;
	private String addr;
	private double price_count;
	private double goods_count;
	private int on_signoff;
	private Timestamp sign_time;
	private Timestamp created_at;
	
	public Order() {
		super();
	}
	public Order(int id, String no, int user_id, String transport_no, double transport_price, String addr,
			double price_count, double goods_count, int on_signoff, Timestamp sign_time, Timestamp created_at) {
		super();
		this.id = id;
		this.no = no;
		this.user_id = user_id;
		this.transport_no = transport_no;
		this.transport_price = transport_price;
		this.addr = addr;
		this.price_count = price_count;
		this.goods_count = goods_count;
		this.on_signoff = on_signoff;
		this.sign_time = sign_time;
		this.created_at = created_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTransport_no() {
		return transport_no;
	}
	public void setTransport_no(String transport_no) {
		this.transport_no = transport_no;
	}
	public double getTransport_price() {
		return transport_price;
	}
	public void setTransport_price(double transport_price) {
		this.transport_price = transport_price;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public double getPrice_count() {
		return price_count;
	}
	public void setPrice_count(double price_count) {
		this.price_count = price_count;
	}
	public double getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(double goods_count) {
		this.goods_count = goods_count;
	}
	public int getOn_signoff() {
		return on_signoff;
	}
	public void setOn_signoff(int on_signoff) {
		this.on_signoff = on_signoff;
	}
	public Timestamp getSign_time() {
		return sign_time;
	}
	public void setSign_time(Timestamp sign_time) {
		this.sign_time = sign_time;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
}
