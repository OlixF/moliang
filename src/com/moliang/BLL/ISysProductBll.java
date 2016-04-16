package com.moliang.BLL;

import java.sql.ResultSet;

import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysProduct;

public interface ISysProductBll {

	ResultSet productExport(String ids);

	int productDelete(String delIds);

	boolean productAdd(SysProduct product);

	ResultSet getList(String str, SysPageBean pageBean);

	int getCount(String str);

	boolean productUpdate(SysProduct product);

	boolean productImport(SysProduct product);

	ResultSet productTotal(String str);

}
