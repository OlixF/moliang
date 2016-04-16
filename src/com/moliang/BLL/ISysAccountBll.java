package com.moliang.BLL;

import java.sql.ResultSet;

import com.moliang.Model.SysAccount;
import com.moliang.Model.SysPageBean;

public interface ISysAccountBll {

	ResultSet getList(String str, SysPageBean pageBean);

	int getCount(String str);

	boolean accountAdd(SysAccount account);

	boolean accountUpdate(SysAccount account);

	int accountDelete(String delIds);

	boolean accountImport(SysAccount account);

	ResultSet accountExport(String ids);

	ResultSet accountTotal(String str);

}
