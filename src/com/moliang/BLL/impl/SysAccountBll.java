package com.moliang.BLL.impl;

import java.sql.ResultSet;

import com.moliang.BLL.ISysAccountBll;
import com.moliang.DAL.ISysAccountDal;
import com.moliang.DAL.impl.SysAccountDal;
import com.moliang.Model.SysAccount;
import com.moliang.Model.SysPageBean;

public class SysAccountBll implements ISysAccountBll {

	ISysAccountDal accountDal = new SysAccountDal();
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		return accountDal.getList(str,pageBean);
	}

	@Override
	public int getCount(String str) {
		return accountDal.getCount(str);
	}

	@Override
	public boolean accountAdd(SysAccount account) {
		if(accountDal.accountAdd(account)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean accountUpdate(SysAccount account) {
		if(accountDal.accountUpdate(account)==1){
			return true;
		}
		return false;
	}

	@Override
	public int accountDelete(String delIds) {
		return accountDal.accountDelete(delIds);
	}

	@Override
	public boolean accountImport(SysAccount account) {
		if(accountDal.exist(account.getAccount_id())){
			return accountUpdate(account);
		}else{
			return accountAdd(account);
		}
	}

	@Override
	public ResultSet accountExport(String ids) {
		return accountDal.accountExport(ids);
	}

	@Override
	public ResultSet accountTotal(String str) {
		return accountDal.accountTotal(str);
	}

}
