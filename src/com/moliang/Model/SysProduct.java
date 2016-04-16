package com.moliang.Model;

import java.util.Date;

public class SysProduct {
	private String product_id;//流水线ID
	private String product_NO;//产品型号
	private String product_name;//产品名称
	private double product_price;//产品价格
	private int buy_num;//采购数量
	private double product_total;//产品总额
	private Date buy_time;//采购时间
	private String buy_way;//采购方式
	private String buy_person;//采购人
	private String person_phone;//联系方式
	private String comment;//备注
	
	
	public SysProduct() {
		super();
	}
	
	public SysProduct(String product_id, String product_NO, String product_name,
			double product_price, int buy_num, double product_total, Date buy_time,
			String buy_way, String buy_person, String person_phone,
			String comment) {
		super();
		this.product_id = product_id;
		this.product_NO = product_NO;
		this.product_name = product_name;
		this.product_price = product_price;
		this.buy_num = buy_num;
		this.product_total = product_total;
		this.buy_time = buy_time;
		this.buy_way = buy_way;
		this.buy_person = buy_person;
		this.person_phone = person_phone;
		this.comment = comment;
	}

	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_NO() {
		return product_NO;
	}
	public void setProduct_NO(String product_NO) {
		this.product_NO = product_NO;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	public double getProduct_total() {
		return product_total;
	}
	public void setProduct_total(double product_total) {
		this.product_total = product_total;
	}
	public Date getBuy_time() {
		return buy_time;
	}
	public void setBuy_time(Date buy_time) {
		this.buy_time = buy_time;
	}
	public String getBuy_way() {
		return buy_way;
	}
	public void setBuy_way(String buy_way) {
		this.buy_way = buy_way;
	}
	public String getBuy_person() {
		return buy_person;
	}
	public void setBuy_person(String buy_person) {
		this.buy_person = buy_person;
	}
	public String getPerson_phone() {
		return person_phone;
	}
	public void setPerson_phone(String person_phone) {
		this.person_phone = person_phone;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
