package com.moliang.BLL.impl;

import java.sql.ResultSet;

import com.moliang.BLL.ISysProductBll;
import com.moliang.DAL.ISysProductDal;
import com.moliang.DAL.impl.SysProductDal;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysProduct;

public class SysProductBll implements ISysProductBll {

	ISysProductDal productDal = new SysProductDal();
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		return productDal.getList(str,pageBean);
	}
	
	@Override
	public boolean productAdd(SysProduct product) {
		if(productDal.productAdd(product)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean productUpdate(SysProduct product) {
		if(productDal.productUpdate(product)==1){
			return true;
		}
		return false;
	}
	
	@Override
	public int productDelete(String delIds) {
		return productDal.productDelte(delIds);
	}
	
	@Override
	public int getCount(String str) {
		return productDal.getCount(str);
	}

	@Override
	public boolean productImport(SysProduct product) {
		if(productDal.exist(product.getProduct_id())){
			return productUpdate(product);
		}else{
			return productAdd(product);
		}
	}

	@Override
	public ResultSet productExport(String ids) {
		return productDal.productExport(ids);
	}

	@Override
	public ResultSet productTotal(String str) {
		return productDal.productTotal(str);
	}
}
