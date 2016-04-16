package com.moliang.Model;

import java.util.Date;

public class SysAccount {
	
	private Date account_date;
	private String account_id;
	private String account_abstract;
	private String account_unit;
	private String account_side_unit;
	private double account_income;
	private double account_expenditure;
	private double account_balance;
	private String comment;
	
	public SysAccount() {
		super();
	}
	public SysAccount(Date account_date, String account_id,
			String account_abstract, String account_unit,
			String account_side_unit, double account_income,
			double account_expenditure, String comment) {
		super();
		this.account_date = account_date;
		this.account_id = account_id;
		this.account_abstract = account_abstract;
		this.account_unit = account_unit;
		this.account_side_unit = account_side_unit;
		this.account_income = account_income;
		this.account_expenditure = account_expenditure;
		this.comment = comment;
	}
	public Date getAccount_date() {
		return account_date;
	}
	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccount_abstract() {
		return account_abstract;
	}
	public void setAccount_abstract(String account_abstract) {
		this.account_abstract = account_abstract;
	}
	public String getAccount_unit() {
		return account_unit;
	}
	public void setAccount_unit(String account_unit) {
		this.account_unit = account_unit;
	}
	public String getAccount_side_unit() {
		return account_side_unit;
	}
	public void setAccount_side_unit(String account_side_unit) {
		this.account_side_unit = account_side_unit;
	}
	public double getAccount_income() {
		return account_income;
	}
	public void setAccount_income(double account_income) {
		this.account_income = account_income;
	}
	public double getAccount_expenditure() {
		return account_expenditure;
	}
	public void setAccount_expenditure(double account_expenditure) {
		this.account_expenditure = account_expenditure;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
