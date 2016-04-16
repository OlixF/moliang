package com.moliang.DAL;

import java.sql.ResultSet;

import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysProduct;

public interface ISysProductDal {

	ResultSet getList(String str, SysPageBean pageBean);

	int productAdd(SysProduct product);

	int productUpdate(SysProduct product);

	int productDelte(String delIds);

	int getCount(String str);

	boolean exist(String product_id);

	ResultSet productTotal(String str);

	ResultSet productExport(String ids);

}
