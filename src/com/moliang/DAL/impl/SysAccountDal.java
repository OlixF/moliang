package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.moliang.DAL.ISysAccountDal;
import com.moliang.Model.SysAccount;
import com.moliang.Model.SysPageBean;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

public class SysAccountDal implements ISysAccountDal {

	ISysJDBC jdbc = null;
	public SysAccountDal(){
		jdbc = new SysJDBC();
	}
	
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		String sSql = "select * from sysaccount_info order by account_date desc";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		sSql += " LIMIT ?,?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,(pageBean.getPage()-1)*pageBean.getRows(),pageBean.getRows());
		return rs;		
	}

	@Override
	public int getCount(String str) {
		String sSql = "select count(*) from sysaccount_info";
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
	public int accountAdd(SysAccount account) {
		String sSql = "insert into sysaccount_info value(?,?,?,?,?,?,?,?)";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,account.getAccount_id(),account.getAccount_date(),
				account.getAccount_abstract(),account.getAccount_unit(),
				account.getAccount_side_unit(),account.getAccount_income(),
				account.getAccount_expenditure(),account.getComment());
		jdbc.close();
		return count;
	}

	@Override
	public int accountUpdate(SysAccount account) {
		String sSql = "update sysaccount_info set account_date=?,account_abstract=?,"
				+ "account_unit=?,account_side_unit=?,account_income=?,account_expenditure=?,"
				+ "comment=? where account_id=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,account.getAccount_date(),
				account.getAccount_abstract(),account.getAccount_unit(),
				account.getAccount_side_unit(),account.getAccount_income(),
				account.getAccount_expenditure(),account.getComment(),
				account.getAccount_id());
		jdbc.close();
		return count;
	}

	@Override
	public int accountDelete(String delIds) {
		String sSql = "delete from sysaccount_info where account_id in ('"+delIds+"')";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql);
		jdbc.close();
		return count;
	}

	@Override
	public boolean exist(String account_id) {
		String sSql = "select * from sysaccount_info where account_id = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql, account_id);
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
	public ResultSet accountTotal(String str) {
		String sSql = "select sum(account_income) as account_income,"
				+ "sum(account_expenditure) as account_expenditure from sysaccount_info";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		jdbc.getConnection();
		return jdbc.executeQuery(sSql);
	}
	@Override
	public ResultSet accountExport(String Ids) {
		String sSql = "select * from sysaccount_info where account_id in ('"+Ids+"')";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql);
		return rs;
	}
}
