/**
 * 
 */
package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.DAL.ISysUserDal;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysUser;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

/**
 * @author Hards
 *
 */
public class SysUserDal implements ISysUserDal {

	/* (non-Javadoc)
	 * @see com.etc.DAO.ISysUserDao#Login(java.lang.String, java.lang.String)
	 */
	ISysJDBC jdbc = null;
	ResultSet rs = null;
	
	public SysUserDal(){
		jdbc = new SysJDBC();
	}
	
	@Override
	public SysUser Login(String suserName, String spassWord) {
		SysUser user = null;
		String sSql = "select * from sysuser where user_name = ? and user_pwd = ?";
		try {
			jdbc.getConnection();
			rs = jdbc.executeQuery(sSql,suserName,spassWord);
			while(rs.next()){
				user = new SysUser();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setReal_name(rs.getString("real_name"));
				user.setUser_role(rs.getInt("user_role"));
				return user;
			}
		} catch (SQLException e) {
			System.out.println("²Ù×÷Ê§°Ü¡£¡£¡£");
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return user;
	}

	@Override
	public int updatePwdById(int userId, String newPwd) {
		int count = 0;
		String sSql = "update sysuser set user_pwd =? where user_id = ? ";
		jdbc.getConnection();
		count = jdbc.executeUpdate(sSql,newPwd,userId);
		jdbc.close();
		return count;
	}

	@Override
	public int getCount(String str) {
		String sSql = "select count(*) from sysuser";
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
	public ResultSet getList(String str, SysPageBean pageBean) {
		String sSql = "select * from sysuser";
		if(!"".equals(str)&&str!=null){
			sSql +=" where "+str; 
		}
		sSql += " LIMIT ?,?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,(pageBean.getPage()-1)*pageBean.getRows(),pageBean.getRows());
		return rs;
	}

	@Override
	public SysUser findUserByName(String suserName) {
		// TODO Auto-generated method stub
		return null;
	}

}
