package com.moliang.DAL;

import java.sql.ResultSet;

import com.moliang.Model.SysMember;
import com.moliang.Model.SysPageBean;

import net.sf.json.JSONArray;

public interface ISysMemberDal {

	public ResultSet getList(String str,SysPageBean pageBean);

	public int getCount(String str);

	public int memberAdd(SysMember member);

	public int memberUpdate(SysMember member);

	public int memberDelete(String delIds);

	public boolean exist(String member_number);

	public ResultSet memberExport(String Ids);

	public boolean exist(SysMember member);

}
