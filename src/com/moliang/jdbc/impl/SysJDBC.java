package com.moliang.jdbc.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moliang.jdbc.ISysJDBC;
import com.mysql.jdbc.Connection;

public class SysJDBC implements ISysJDBC {

	private static final String Driver = "org.gjt.mm.mysql.Driver";
	private static final String Url = "jdbc:mysql://120.26.235.45:3306/moliang";
	private static final String user = "root";
	private static final String pwd = "H3ll0123";
	Statement stmt= null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	@Override
	public Connection getConnection() {
		try {
			Class.forName(Driver); 
			System.out.println("驱动加载成功。。。");
			try {
				conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(Url, user, pwd);
				if(conn!=null){
					System.out.println("数据库连接成功。。。");
				}else{
					System.out.println("数据库连接失败。。。");
				}
			} catch (SQLException e) {
				System.out.println("数据库连接失败。。。");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败。。。");
			e.printStackTrace();
		}
		return conn;
	}
	@Override
	public void close() {
		try {
			if(conn != null){
				conn.close();
				System.out.println("数据连接关闭成功。。。");
			}
		} catch (SQLException e) {
			System.out.println("关闭失败。。。");
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet executeQuery(String sql,Object...objects) {
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				pstmt.setObject(i+1, objects[i]);
			}
			rs = pstmt.executeQuery();
			System.out.println("sql语句:"+sql + "操作成功。。。");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql语句:"+sql + "操作失败。。。");
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public int executeUpdate(String sql, Object... objects) {
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				pstmt.setObject(i+1, objects[i]);
			}
			count = pstmt.executeUpdate();
			System.out.println("sql:"+sql+"执行成功。。。");
		} catch (SQLException e) {
			System.out.println("sql:"+sql+"执行失败。。。");
			e.printStackTrace();
		} finally {
			this.close();
		}
		return count;
	}

}
