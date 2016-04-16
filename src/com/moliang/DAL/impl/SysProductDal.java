package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.moliang.DAL.ISysProductDal;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysProduct;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

public class SysProductDal implements ISysProductDal {
	
	ISysJDBC jdbc = null;
	public SysProductDal(){
		jdbc = new SysJDBC();
	}

	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		String sSql = "select * from sysproduct_info order by buy_time desc";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		sSql += " LIMIT ?,?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,(pageBean.getPage()-1)*pageBean.getRows(),pageBean.getRows());
		return rs;		
	}

	@Override
	public int productAdd(SysProduct product) {
		String sSql = "insert into sysproduct_info value(?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,product.getProduct_id(),product.getProduct_NO(),
				product.getProduct_name(),product.getProduct_price(),
				product.getBuy_num(),product.getProduct_total(),
				product.getBuy_time(),product.getBuy_way(),
				product.getBuy_person(),product.getPerson_phone(),
				product.getComment());
		jdbc.close();
		return count;
	}

	@Override
	public int productUpdate(SysProduct product) {
		String sSql = "update sysproduct_info set product_NO=?,product_name=?,product_price=?,"
				+ "buy_num=?,product_total=?,buy_time=?,buy_way=?,buy_person=?,person_phone=?,"
				+ "comment=? where product_id=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,product.getProduct_NO(),
				product.getProduct_name(),product.getProduct_price(),
				product.getBuy_num(),product.getProduct_total(),
				product.getBuy_time(),product.getBuy_way(),
				product.getBuy_person(),product.getPerson_phone(),
				product.getComment(),product.getProduct_id());
		jdbc.close();
		return count;
	}

	@Override
	public int productDelte(String delIds) {
		String sSql = "delete from sysproduct_info where product_id in ('"+delIds+"')";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql);
		jdbc.close();
		return count;
	}

	@Override
	public int getCount(String str) {
		String sSql = "select count(*) from sysproduct_info";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql);
		try {
			if(rs.next()){
				return rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean exist(String product_id) {
		String sSql = "select * from sysproduct_info where product_id = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql, product_id);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet productTotal(String str) {
		String sSql = "select sum(product_total) as product_total from sysproduct_info";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		jdbc.getConnection();
		return jdbc.executeQuery(sSql);
	}

	@Override
	public ResultSet productExport(String ids) {
		String sSql = "select * from sysproduct_info where product_id in ('"+ids+"')";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql);
		return rs;
	}

}
