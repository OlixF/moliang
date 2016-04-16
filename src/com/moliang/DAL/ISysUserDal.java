package com.moliang.DAL;

import java.sql.ResultSet;

import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysUser;

import net.sf.json.JSONArray;

public interface ISysUserDal {
	
	public SysUser Login(String suserName,String spassWord);

	public int updatePwdById(int userId, String newPwd);

	public int getCount(String str);

	public ResultSet getList(String str, SysPageBean pageBean);

	public SysUser findUserByName(String suserName);

}
