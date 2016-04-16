package com.moliang.BLL;

import com.moliang.Model.SysMenu;
import com.moliang.Model.SysPageBean;

import net.sf.json.JSONArray;

public interface ISysMenuBll {
	
	//��ȡ�����˵���Ϣ
	public JSONArray getMenuByParentId(String parentId,String menuIds);
	
	//��ȡ���в˵���Ϣ
	public JSONArray getMenusByParentId(String parentId,String menuIds);

	/*
	 * ͨ����Ŀ¼��ȡ�б�
	 * */
	public JSONArray getListByParentId(int parentId);

	public boolean menuAdd(SysMenu menu);

	public boolean menuUpdate(SysMenu menu);

	public boolean menuDelete(int menuId);
	
}
