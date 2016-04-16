package com.moliang.BLL.impl;

import java.sql.ResultSet;

import net.sf.json.JSONArray;

import com.moliang.BLL.ISysUserBll;
import com.moliang.DAL.ISysUserDal;
import com.moliang.DAL.impl.SysUserDal;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysUser;

public class SysUserBll implements ISysUserBll {

	SysUser user = null;
	ISysUserDal userDal = new SysUserDal();
	@Override
	public SysUser Login(String suserName, String spassWord) {
		user = userDal.Login(suserName, spassWord);
		return user;
	}
	@Override
	public SysUser findUserByName(String suserName) {
		user = userDal.findUserByName(suserName);
		if(user!=null){
			if(user.getUser_name().equals(suserName)){
				return user;
			}
		}
		return user;
	}
	@Override
	public SysUser findUserById(int uid) {
		return null;
	}

	@Override
	public boolean updatePwdById(int user_id, String newPwd) {
		int count = userDal.updatePwdById(user_id,newPwd);
		if(count == 1)
		{
			return true;
		} else {
			return false;
		}
	}
	@Override
	public int getCount(String str) {
		return userDal.getCount(str);
	}
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		return userDal.getList(str,pageBean);
	}

}
