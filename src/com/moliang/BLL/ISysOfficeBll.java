package com.moliang.BLL;

import java.sql.ResultSet;

import com.moliang.Model.SysOffice;
import com.moliang.Model.SysPageBean;

public interface ISysOfficeBll {

	ResultSet getList(String str, SysPageBean pageBean);

	int getCount(String str);

	boolean officeAdd(SysOffice office);

	boolean officeUpdate(SysOffice office);

	int officeDelete(String delIds);

	ResultSet getListByUserRole(String str, SysPageBean pageBean, int user_role);

	int getCountByUserRole(String str, int user_role);

}
