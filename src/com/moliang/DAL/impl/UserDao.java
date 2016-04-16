package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.moliang.DAL.IUserDao;
import com.moliang.Model.User;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

public class UserDao implements IUserDao {

	ISysJDBC jdbc = null;
	ResultSet rs = null;
	
	public UserDao(){
		jdbc = new SysJDBC();
	}
	
	@Override
	public User findByNameAndPwd(String nickName, String passWord) {
		String sSql = "select * from mo_user where nickname = ? and password = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,nickName,passWord);
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setUser_Id(rs.getString("user_id"));
				user.setEmail(rs.getString("email"));
				user.setNickName(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUser_integral(rs.getInt("user_integral"));
				user.setEmail_Verify(rs.getString("email_verify"));
				user.setEmail_Verify_Code(rs.getString("email_verify_code"));
				user.setCreate_Time(rs.getDate("create_time"));
				user.setLast_Login_Time(rs.getDate("last_login_time"));
				user.setLast_Login_Ip(rs.getString("last_login_ip"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return user;
	}

	@Override
	public User findByEmailAndPwd(String email, String passWord) {
		String sSql = "select * from mo_user where email = ? and password = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,email,passWord);
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setUser_Id(rs.getString("user_id"));
				user.setEmail(rs.getString("email"));
				user.setNickName(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUser_integral(rs.getInt("user_integral"));
				user.setEmail_Verify(rs.getString("email_verify"));
				user.setEmail_Verify_Code(rs.getString("email_verify_code"));
				user.setCreate_Time(rs.getDate("create_time"));
				user.setLast_Login_Time(rs.getDate("last_login_time"));
				user.setLast_Login_Ip(rs.getString("last_login_ip"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return user;
	}

	@Override
	public int AddUser(User user) {
		// TODO Auto-generated method stub
		String sSql = "insert into mo_user value(?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,user.getUser_Id(),user.getEmail(),user.getNickName(),
				user.getPassword(),user.getUser_integral(),user.getEmail_Verify(),user.getEmail_Verify_Code(),
				user.getCreate_Time(),user.getLast_Login_Time(),user.getPhone(),user.getLast_Login_Ip(),
				user.getMessage());
		return count;
	}

	@Override
	public int UpdateUser(User user) {
		String sSql = "update mo_user set email=?,nickname=?,password=?,"
				+ "user_integral=?,email_verify=?,email_verify_code=?,create_time=?,last_login_time=?,phone=?,"
				+ "last_login_ip=?,message=? where user_id=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,user.getEmail(),user.getNickName(),
				user.getPassword(),user.getUser_integral(),user.getEmail_Verify(),user.getEmail_Verify_Code(),
				user.getCreate_Time(),user.getLast_Login_Time(),user.getPhone(),user.getLast_Login_Ip(),
				user.getMessage(),user.getUser_Id());
		return count;
	}

	@Override
	public boolean findByName(String nickName) {
		String sSql = "select * from mo_user where nickname = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,nickName);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return false;
	}

	@Override
	public boolean findByEmail(String email) {
		String sSql = "select * from mo_user where email = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,email);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return false;
	}

}
