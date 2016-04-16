package com.moliang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ISysJDBC {
	
	public Connection getConnection();
	
	public void close();
	
	public ResultSet executeQuery(String sql,Object...objects);

	public int executeUpdate(String sSql,Object...objects);

}
