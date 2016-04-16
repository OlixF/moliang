package com.moliang.DAL;

import java.sql.ResultSet;

import com.moliang.Model.SysAccount;
import com.moliang.Model.SysPageBean;

public interface ISysAccountDal {

	ResultSet getList(String str, SysPageBean pageBean);

	int getCount(String str);
	
	int accountAdd(SysAccount account);

	int accountUpdate(SysAccount account);

	int accountDelete(String delIds);

	boolean exist(String account_id);

	ResultSet accountTotal(String str);
	
	ResultSet accountExport(String Ids);

}
