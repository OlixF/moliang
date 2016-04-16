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
			System.out.println("�������سɹ�������");
			try {
				conn = (com.mysql.jdbc.Connection)DriverManager.getConnection(Url, user, pwd);
				if(conn!=null){
					System.out.println("���ݿ����ӳɹ�������");
				}else{
					System.out.println("���ݿ�����ʧ�ܡ�����");
				}
			} catch (SQLException e) {
				System.out.println("���ݿ�����ʧ�ܡ�����");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ�ܡ�����");
			e.printStackTrace();
		}
		return conn;
	}
	@Override
	public void close() {
		try {
			if(conn != null){
				conn.close();
				System.out.println("�������ӹرճɹ�������");
			}
		} catch (SQLException e) {
			System.out.println("�ر�ʧ�ܡ�����");
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
			System.out.println("sql���:"+sql + "�����ɹ�������");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql���:"+sql + "����ʧ�ܡ�����");
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
			System.out.println("sql:"+sql+"ִ�гɹ�������");
		} catch (SQLException e) {
			System.out.println("sql:"+sql+"ִ��ʧ�ܡ�����");
			e.printStackTrace();
		} finally {
			this.close();
		}
		return count;
	}

}
