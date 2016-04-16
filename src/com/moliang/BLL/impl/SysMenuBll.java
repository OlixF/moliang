package com.moliang.BLL.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysMenuBll;
import com.moliang.DAL.ISysMenuDal;
import com.moliang.DAL.impl.SysMenuDal;
import com.moliang.Model.SysMenu;
import com.moliang.Model.SysPageBean;

public class SysMenuBll implements ISysMenuBll {

	ISysMenuDal menuDal = new SysMenuDal();
	
	//ͨ������ڵ��ȡ�˵�
	@Override
	public JSONArray getMenuByParentId(String parentId, String menuIds) {
		return menuDal.getMenuByParentId(parentId,menuIds);
	}

	//��ȡ���в˵�
	@Override
	public JSONArray getMenusByParentId(String parentId,String menuIds){
		JSONArray jsonArray=this.getMenuByParentId(parentId,menuIds);
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))){
				continue;
			}else{
				jsonObject.put("children", getMenusByParentId(jsonObject.getString("id"),menuIds));
			}
		}
		return jsonArray;
	}


	//��ȡ�˵�
	private JSONArray getTreeByParentId(int parentId) {
		return menuDal.getTreeByparentId(parentId);
	}
	
	//��ȡ�˵��б�
	@Override
	public JSONArray getListByParentId(int parentId) {
		JSONArray array = this.getTreeByParentId(parentId);
		for(int i=0;i<array.size();i++){
			JSONObject ob= array.getJSONObject(i);
			if("open".equals(ob.getString("menuState"))){
				continue;
			}else{
				ob.put("children", this.getListByParentId(ob.getInt("menuId")));
			}
		}
		return array;
	}

	//���
	@Override
	public boolean menuAdd(SysMenu menu) {
		if(menuDal.menuAdd(menu) == 1){
			return true;
		}
		return false;
	}

	//����
	@Override
	public boolean menuUpdate(SysMenu menu) {
		if(menuDal.menuUpdate(menu) == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean menuDelete(int menuId) {
		if(menuDal.menuDelete(menuId) == 1){
			return true;
		}
		return false;
	}

}
