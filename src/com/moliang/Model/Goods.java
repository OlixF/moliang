package com.moliang.Model;

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
	private String goods_id;
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
	}
}
