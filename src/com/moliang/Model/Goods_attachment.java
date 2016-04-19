package com.moliang.Model;

public class Goods_attachment {
	/*
	  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL COMMENT '货物id，goods表id',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更多商品图片介绍图片地址',
  `info` text COLLATE utf8_unicode_ci COMMENT '图片物品介绍信息',
  */
	private int id;
	private int goods_id;
	private String url;
	private String info;
	
	public Goods_attachment() {
		super();
	}
	public Goods_attachment(int id, int goods_id, String url, String info) {
		super();
		this.id = id;
		this.goods_id = goods_id;
		this.url = url;
		this.info = info;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
