package com.moliang.Model;

import java.sql.Timestamp;
import java.util.Date;

public class Goods {
	/*goods_id	Varchar(50)	商品ID
	class_id	Varchar(50)  	商品类别
	goods_name	Varchar(50)	商品名称
	goods_icon	Varchar(100)	商品图标路径
	goods_img	Varchar(100)	商品图片路径
	goods_price	double	商品价格
	goods_unit	VarChar(20)	价格单位
	goods_market_price	Varchar(50)  	商品市场价格
	expiration_date	VarChar(20)	保质期
	goods_taste	VarChar(20)	商品口味
	goods_introduce	Varchar(255)	商品介绍
	register_date	date	上架时间
	sold_out_date	date	下架时间
	sales_volume	int	销量
	goods_integral	int	商品可送积分
	goods_evaluate	int	评价数量
	goods_packing	VarChar(50)	包装方式*/
	
	/*
	`id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '物品名称',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '物品价格',
  `category_id` int(11) DEFAULT NULL COMMENT '物品分类id,category表id',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '商品介绍图片地址',
  `info` text COLLATE utf8_unicode_ci COMMENT '物品介绍信息',
  `like_count` int(11) DEFAULT '0' COMMENT '被收藏次数',
  `sale_count` int(11) DEFAULT '0' COMMENT '总出售量',
  `storage_count` int(11) DEFAULT '0' COMMENT '剩余数量',
  `on_sale` tinyint(1) DEFAULT '1' COMMENT '是否可售，1代表可售，0不可售',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  
 */
	
	
	
	private int id;
	private String name;
	private double price;
	private int category_id;
	private String url;
	private String info;
	private int like_count;
	private int sale_count;
	private int storage_count;
	private int on_sale;
	private Timestamp created_at;
	
	public Goods() {
		super();
	}
	public Goods(int id, String name, double price, int category_id, String url, String info, int like_count,
			int sale_count, int storage_count, int on_sale, Timestamp created_at) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category_id = category_id;
		this.url = url;
		this.info = info;
		this.like_count = like_count;
		this.sale_count = sale_count;
		this.storage_count = storage_count;
		this.on_sale = on_sale;
		this.created_at = created_at;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getSale_count() {
		return sale_count;
	}
	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}
	public int getStorage_count() {
		return storage_count;
	}
	public void setStorage_count(int storage_count) {
		this.storage_count = storage_count;
	}
	public int getOn_sale() {
		return on_sale;
	}
	public void setOn_sale(int on_sale) {
		this.on_sale = on_sale;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	/*private String goods_id;
	private String class_id;
	private String goods_name;
	private String goods_icon;
	private String goods_img;
	private double goods_market_price;
	private double goods_price;
	private String goods_unit;
	private String expiration_date;
	private String goods_taste;
	private String goods_introduce;
	private String goods_packing;
	private Date register_date ;
	private Date sold_out_date;
	private int sales_volume;
	private int goods_integral;
	private int goods_evaluate;
	
	
	public Goods() {
		
	}
	
	public Goods(String goods_id, String class_id, String goods_name, String goods_icon, String goods_img,
			double goods_market_price, double goods_price, String goods_unit, String expiration_date,
			String goods_taste, String goods_introduce, String goods_packing, Date register_date, Date sold_out_date,
			int sales_volume, int goods_integral, int goods_evaluate) {
		super();
		this.goods_id = goods_id;
		this.class_id = class_id;
		this.goods_name = goods_name;
		this.goods_icon = goods_icon;
		this.goods_img = goods_img;
		this.goods_market_price = goods_market_price;
		this.goods_price = goods_price;
		this.goods_unit = goods_unit;
		this.expiration_date = expiration_date;
		this.goods_taste = goods_taste;
		this.goods_introduce = goods_introduce;
		this.goods_packing = goods_packing;
		this.register_date = register_date;
		this.sold_out_date = sold_out_date;
		this.sales_volume = sales_volume;
		this.goods_integral = goods_integral;
		this.goods_evaluate = goods_evaluate;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_icon() {
		return goods_icon;
	}
	public void setGoods_icon(String goods_icon) {
		this.goods_icon = goods_icon;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public double getGoods_market_price() {
		return goods_market_price;
	}
	public void setGoods_market_price(double goods_market_price) {
		this.goods_market_price = goods_market_price;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_unit() {
		return goods_unit;
	}
	public void setGoods_unit(String goods_unit) {
		this.goods_unit = goods_unit;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getGoods_taste() {
		return goods_taste;
	}
	public void setGoods_taste(String goods_taste) {
		this.goods_taste = goods_taste;
	}
	public String getGoods_introduce() {
		return goods_introduce;
	}
	public void setGoods_introduce(String goods_introduce) {
		this.goods_introduce = goods_introduce;
	}
	public String getGoods_packing() {
		return goods_packing;
	}
	public void setGoods_packing(String goods_packing) {
		this.goods_packing = goods_packing;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public Date getSold_out_date() {
		return sold_out_date;
	}
	public void setSold_out_date(Date sold_out_date) {
		this.sold_out_date = sold_out_date;
	}
	public int getSales_volume() {
		return sales_volume;
	}
	public void setSales_volume(int sales_volume) {
		this.sales_volume = sales_volume;
	}
	public int getGoods_integral() {
		return goods_integral;
	}
	public void setGoods_integral(int goods_integral) {
		this.goods_integral = goods_integral;
	}
	public int getGoods_evaluate() {
		return goods_evaluate;
	}
	public void setGoods_evaluate(int goods_evaluate) {
		this.goods_evaluate = goods_evaluate;
	}*/
}
