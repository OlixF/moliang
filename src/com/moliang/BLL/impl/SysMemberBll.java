package com.moliang.BLL.impl;

import java.sql.ResultSet;

import net.sf.json.JSONArray;

import com.moliang.BLL.ISysMemberBll;
import com.moliang.DAL.ISysMemberDal;
import com.moliang.DAL.impl.SysMemberDal;
import com.moliang.Model.SysMember;
import com.moliang.Model.SysPageBean;

public class SysMemberBll implements ISysMemberBll {

	ISysMemberDal memberDal = new SysMemberDal();
	@Override
	public ResultSet getList(String str,SysPageBean pageBean) {
		return memberDal.getList(str,pageBean);
	}
	@Override
	public int getCount(String str) {
		
		return memberDal.getCount(str);
	}
	
	@Override
	public boolean memberAdd(SysMember member) {
		if(memberDal.memberAdd(member)==1){
			return true;
		}
		return false;
	}
	@Override
	public boolean memberUpdate(SysMember member) {
		if(memberDal.memberUpdate(member)==1){
			return true;
		}
		return false;
	}
	@Override
	public int memberDelete(String delIds) {
		return memberDal.memberDelete(delIds);
	}
	@Override
	public boolean memberImport(SysMember member) {
		if(memberDal.exist(member.getMember_number())){
			return memberUpdate(member);
		}else{
			return memberAdd(member);
		}
	}
	@Override
	public ResultSet memberExport(String Ids) {
		return memberDal.memberExport(Ids);
	}
	@Override
	public boolean exist(SysMember member) {
		return memberDal.exist(member);
	}

}
