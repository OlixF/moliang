package com.moliang.BLL;

import java.sql.ResultSet;

import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysUser;

import net.sf.json.JSONArray;

public interface ISysUserBll {

	public SysUser Login(String suserName, String spassWord);

	public SysUser findUserByName(String suserName);

	public SysUser findUserById(int uid);

	public boolean updatePwdById(int user_id, String oldPwd);

	public int getCount(String str);

	public ResultSet getList(String str, SysPageBean pageBean);
}
