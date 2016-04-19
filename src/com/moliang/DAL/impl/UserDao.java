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
		String sSql = "select * from user where nickname = ? and passwd = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,nickName,passWord);
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setPasswd(rs.getString("passwd"));
				user.setNickname(rs.getString("nickname"));
				user.setAvatar(rs.getString("avatar"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setCreate_at(rs.getTimestamp("created_at"));
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
		String sSql = "select * from user where email = ? and passwd = ?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql,email,passWord);
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setPasswd(rs.getString("passwd"));
				user.setNickname(rs.getString("nickname"));
				user.setAvatar(rs.getString("avatar"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setCreate_at(rs.getTimestamp("created_at"));
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
		String sSql = "insert into user value(?,?,?,?,?,?,?)";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,user.getAccount(),user.getPasswd(),
				user.getNickname(),user.getAvatar(),user.getPhone(),user.getEmail(),
				user.getCreate_at());
		return count;
	}

	@Override
	public int UpdateUser(User user) {
		String sSql = "update user set account=?,passwd=?,nickname=?,"
				+ "avatar=?,phone=?,email=?,create_at=? where id=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql,user.getAccount(),user.getPasswd(),
				user.getNickname(),user.getAvatar(),user.getPhone(),user.getEmail(),
				user.getCreate_at(),user.getId());
		return count;
	}

	@Override
	public boolean findByName(String nickName) {
		String sSql = "select * from user where nickname = ?";
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
