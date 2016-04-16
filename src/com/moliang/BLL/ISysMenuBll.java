package com.moliang.BLL;

import com.moliang.Model.SysMenu;
import com.moliang.Model.SysPageBean;

import net.sf.json.JSONArray;

public interface ISysMenuBll {
	
	//获取单个菜单信息
	public JSONArray getMenuByParentId(String parentId,String menuIds);
	
	//获取所有菜单信息
	public JSONArray getMenusByParentId(String parentId,String menuIds);

	/*
	 * 通过父目录获取列表
	 * */
	public JSONArray getListByParentId(int parentId);

	public boolean menuAdd(SysMenu menu);

	public boolean menuUpdate(SysMenu menu);

	public boolean menuDelete(int menuId);
	
}
