package com.moliang.DAL;

import com.moliang.Model.SysMenu;
import com.moliang.Model.SysPageBean;

import net.sf.json.JSONArray;

public interface ISysMenuDal {

	public JSONArray getMenuByParentId(String parentId, String menuIds);

	public int getCount(SysPageBean pageBean);

	public JSONArray getList();

	public JSONArray getTreeByparentId(int parentId);

	public int menuAdd(SysMenu menu);

	public int menuUpdate(SysMenu menu);

	public int menuDelete(int menuId);

}
