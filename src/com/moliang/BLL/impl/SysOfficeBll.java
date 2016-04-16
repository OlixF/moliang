package com.moliang.BLL.impl;

import java.sql.ResultSet;

import com.moliang.BLL.ISysOfficeBll;
import com.moliang.DAL.ISysOfficeDal;
import com.moliang.DAL.impl.SysOfficeDal;
import com.moliang.Model.SysOffice;
import com.moliang.Model.SysPageBean;

public class SysOfficeBll implements ISysOfficeBll {

	ISysOfficeDal officeDal = new SysOfficeDal();
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		return officeDal.getList(str,pageBean);
	}

	@Override
	public int getCount(String str) {
		return officeDal.getCount(str);
	}

	@Override
	public boolean officeAdd(SysOffice office) {
		if(officeDal.officeAdd(office) == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean officeUpdate(SysOffice office) {
		if(officeDal.officeUpdate(office) == 1){
			return true;
		}
		return false;
	}

	@Override
	public int officeDelete(String delIds) {
		return officeDal.officeDelete(delIds);
	}

	@Override
	public ResultSet getListByUserRole(String str, SysPageBean pageBean, int user_role) {
		return officeDal.getListByUserRole(str,pageBean,user_role);
	}

	@Override
	public int getCountByUserRole(String str, int user_role) {
		return officeDal.getCountByUserRole(str,user_role);
	}

}
