package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.moliang.DAL.ISysOfficeDal;
import com.moliang.Model.SysOffice;
import com.moliang.Model.SysPageBean;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

public class SysOfficeDal implements ISysOfficeDal {

	ISysJDBC jdbc = null;
	public SysOfficeDal(){
		jdbc = new SysJDBC();
	}
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		String sSql = "select * from system_info order by info_time desc ";
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
		String sSql = "select count(*) from system_info";
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
	public int officeAdd(SysOffice office) {
		String sSql = "insert into system_info value(null,?,?,?,?,?)";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,office.getInfo_title(),
				office.getInfo_content(), office.getInfo_time(),
				office.getInfo_role(),office.getComment());
		jdbc.close();
		return count;
	}

	@Override
	public int officeUpdate(SysOffice office) {
		String sSql = "update system_info set info_time=?,info_role=?,"
				+ "info_title=?,info_content=?,comment=? where info_id=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql, office.getInfo_time(),
				office.getInfo_role(),office.getInfo_title(),
				office.getInfo_content(),office.getComment(),office.getInfo_id());
		jdbc.close();
		return count;
	}

	@Override
	public int officeDelete(String delIds) {
		String sSql = "delete from system_info where info_id in ('"+delIds+"')";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql);
		jdbc.close();
		return count;
	}
	@Override
	public ResultSet getListByUserRole(String str, SysPageBean pageBean,
			int user_role) {
		String sql = "select role_name from sysrole where role_id = ?";
		jdbc.getConnection();
		ResultSet rs1 = jdbc.executeQuery(sql, user_role);
		try {
			if(rs1.next()){
				String info_role = rs1.getString("role_name");
				String sSql = "select * from system_info where info_role = ?  or info_role = '全体成员' order by info_time desc ";
				if(!"".equals(str)&&str!=null){
					sSql +=" where "+str; 
				}
				sSql += " LIMIT ?,?";
				ResultSet rs = jdbc.executeQuery(sSql,info_role,(pageBean.getPage()-1)*pageBean.getRows(),pageBean.getRows());
				return rs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int getCountByUserRole(String str, int user_role) {
		String sql = "select role_name from sysrole where role_id = ?";
		jdbc.getConnection();
		ResultSet rs1 = jdbc.executeQuery(sql, user_role);
		try {
			if(rs1.next()){
				String info_role = rs1.getString("role_name");
				String sSql = "select count(*) from system_info where info_role = ? or info_role = '全体成员'";
				if(!"".equals(str)&&str!=null){
					sSql +=" where "+str; 
				}
				ResultSet rs = jdbc.executeQuery(sSql,info_role);
				if(rs.next()){
					return rs.getInt("count(*)");
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

}
