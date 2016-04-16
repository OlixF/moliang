package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.moliang.DAL.ISysMemberDal;
import com.moliang.Model.SysMember;
import com.moliang.Model.SysPageBean;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SysMemberDal implements ISysMemberDal {

	ISysJDBC jdbc = new SysJDBC();
	ResultSet rs = null;
	@Override
	public ResultSet getList(String str,SysPageBean pageBean) {
		String sSql ="select * from sysmember_info";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		sSql += " LIMIT ?,?";
		jdbc.getConnection();
		rs = jdbc.executeQuery(sSql,(pageBean.getPage()-1)*pageBean.getRows(),pageBean.getRows());
		return rs;
	}

	//获取满足条件（str）的记录数
	@Override
	public int getCount(String str) {
		String sSql = "select count(*) from sysmember_info";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		jdbc.getConnection();
		rs = jdbc.executeQuery(sSql);
		try {
			if(rs.next()){
				return rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public boolean exist(SysMember member){
		String sSql = "select * from sysmember_info where member_number = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql, member.getMember_number());
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
	public int memberAdd(SysMember member) {
		String sSql = "insert into sysmember_info value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sSql2 = "insert into sysuser value(null,?,'123456',?,?)";
		int user_role = 10;
		if("财务部".equals(member.getMember_department())){
			user_role = 2;
		}else if("人事部".equals(member.getMember_department())){
			user_role = 2;
		}else if("采购部".equals(member.getMember_department())){
			user_role = 2;
		}else if("办公室".equals(member.getMember_department())){
			user_role = 2;
		}
		int count = 0;
		jdbc.getConnection();
		jdbc.executeUpdate(sSql2, member.getMember_number(),
				member.getMember_name(),user_role);
		count = jdbc.executeUpdate(sSql, member.getMember_number(),
				member.getMember_name(),member.getMember_sex(),
				member.getMember_birth(),member.getMember_card(),
				member.getMember_photo(),member.getMember_minz(),
				member.getMember_hyzk(),member.getMember_zzmm(),
				member.getMember_phone(),member.getMember_email(),
				member.getMember_qq(),member.getMember_address(),
				member.getMember_department(),member.getMember_job(),
				member.getComment());
		jdbc.close();
		return count;
	}

	@Override
	public int memberUpdate(SysMember member) {
		String sSql = "update sysmember_info set member_sex=?,member_birth=?,"
				+ "member_photo=?,member_minz=?,member_hyzk=?,member_zzmm=?,"
				+ "member_phone=?,member_email=?,member_qq=?,member_address=?,"
				+ "member_department=?,member_job=?,comment=? where member_number=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql, member.getMember_sex(),member.getMember_birth(),
				member.getMember_photo(),member.getMember_minz(),
				member.getMember_hyzk(),member.getMember_zzmm(),
				member.getMember_phone(),member.getMember_email(),
				member.getMember_qq(),member.getMember_address(),
				member.getMember_department(),member.getMember_job(),
				member.getComment(),member.getMember_number());
		jdbc.close();
		return count;
	}

	@Override
	public int memberDelete(String delIds) {
		String sSql = "delete from sysmember_info where member_number in ('"+delIds+"')";
		String sSql2 = "delete from sysuser where user_name in ('"+delIds+"')";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql);
		jdbc.executeUpdate(sSql2);
		jdbc.close();
		return count;
	}

	@Override
	public boolean exist(String member_number) {
		String sSql = "select * from sysmember_info where member_number = ?";
		jdbc.getConnection();
		rs = jdbc.executeQuery(sSql, member_number);
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
	public ResultSet memberExport(String Ids) {
		String sSql = "select * from sysmember_info where member_number in ('"+Ids+"')";
		jdbc.getConnection();
		rs = jdbc.executeQuery(sSql);
		return rs;
	}

}