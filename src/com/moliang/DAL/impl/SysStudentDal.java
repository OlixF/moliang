package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.moliang.DAL.ISysStudentDal;
import com.moliang.Model.SysAccount;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysStudent;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

public class SysStudentDal implements ISysStudentDal {

	ISysJDBC jdbc = null;
	public SysStudentDal(){
		jdbc = new SysJDBC();
	}
	
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		String sSql = "select * from sysstudent_info";
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
		String sSql = "select count(*) from sysstudent_info";
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
	public int studentAdd(SysStudent student) {
		String sSql = "insert into sysstudent_info value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sSql2 = "insert into sysuser value(null,?,'123456',?,'11')";
		jdbc.getConnection();
		jdbc.executeUpdate(sSql2, student.getStudent_NO(),
				student.getStudent_name());
		int count = 0;
		count = jdbc.executeUpdate(sSql,student.getStudent_NO(),student.getStudent_name(),
				student.getStudent_sex(),student.getStudent_birth(),
				student.getStudent_card(),student.getStudent_minz(),
				student.getStudent_zzmm(),student.getStudent_phone(),
				student.getStudent_email(),student.getStudent_qq(),
				student.getStudent_address(),student.getStudent_school(),
				student.getStudent_major(),student.getStudent_job(),
				student.getComment());
		jdbc.close();
		return count;
	}

	@Override
	public int studentUpdate(SysStudent student) {
		String sSql = "update sysstudent_info set student_name=?,student_sex=?,"
				+ "student_birth=?,student_card=?,student_minz=?,student_zzmm=?,"
				+ "student_phone=?,student_email=?,student_qq=?,student_address=?,"
				+ "student_school=?,student_major=?,student_job=?,comment=?"
				+ " where student_NO = ?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,student.getStudent_name(),
				student.getStudent_sex(),student.getStudent_birth(),
				student.getStudent_card(),student.getStudent_minz(),
				student.getStudent_zzmm(),student.getStudent_phone(),
				student.getStudent_email(),student.getStudent_qq(),
				student.getStudent_address(),student.getStudent_school(),
				student.getStudent_major(),student.getStudent_job(),
				student.getComment(),student.getStudent_NO());
		jdbc.close();
		return count;
	}

	@Override
	public int studentDelete(String delIds) {
		String sSql = "delete from sysstudent_info where student_NO in ('"+delIds+"')";
		String sSql2 = "delete from sysuser where user_name in ('"+delIds+"')";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql);
		jdbc.executeUpdate(sSql2);
		jdbc.close();
		return count;
	}

	@Override
	public boolean exist(String student_NO) {
		String sSql = "select * from sysstudent_info where student_NO = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql, student_NO);
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
	public ResultSet studentExport(String ids) {
		String sSql = "select * from sysstudent_info "
				+ "where student_NO in ('"+ids+"')";
		jdbc.getConnection();
		return jdbc.executeQuery(sSql);
	}

}
