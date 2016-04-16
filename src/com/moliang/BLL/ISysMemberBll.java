package com.moliang.BLL;

import java.sql.ResultSet;

import com.moliang.Model.SysMember;
import com.moliang.Model.SysPageBean;

import net.sf.json.JSONArray;

public interface ISysMemberBll {

	public ResultSet getList(String str,SysPageBean pageBean);

	public int getCount(String str);

	public boolean memberAdd(SysMember member);

	public boolean memberUpdate(SysMember member);

	public int memberDelete(String delIds);

	public boolean memberImport(SysMember member);

	public ResultSet memberExport(String Ids);

	public boolean exist(SysMember member);
	
}
