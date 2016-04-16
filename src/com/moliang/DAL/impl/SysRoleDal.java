package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.DAL.ISysRoleDal;
import com.moliang.Model.SysRole;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

public class SysRoleDal implements ISysRoleDal {
	
	ISysJDBC jdbc = null;
	
	
	public SysRoleDal(){
		jdbc = new SysJDBC();
	}

	//获取相应权限的所有菜单ID
	@Override
	public String getMenuIdsByRoleId(int roleId) {
		SysRole role = null;
		String sSql = "select menu_role from sysrole where role_id = ? ";
		try {
			jdbc.getConnection();
			ResultSet rs= jdbc.executeQuery(sSql, roleId);
			while(rs.next()){
				role = new SysRole();
				role.setMenu_role(rs.getString("menu_role"));
				return role.getMenu_role();
			}
		} catch (SQLException e) {
			System.out.println("操作失败。。。");
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return null;
	}
}
