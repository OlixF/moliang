package com.moliang.Model;

public class Order_attachment {
	/*
	  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '货物所属订单号',
  `acount` int(11) DEFAULT NULL COMMENT '购买的数量',
  */
	private int id;
	private int goods_id;
	private int order_id;
	private int acount;
	
	public Order_attachment() {
		super();
	}
	public Order_attachment(int id, int goods_id, int order_id, int acount) {
		super();
		this.id = id;
		this.goods_id = goods_id;
		this.order_id = order_id;
		this.acount = acount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
	}
	
}
