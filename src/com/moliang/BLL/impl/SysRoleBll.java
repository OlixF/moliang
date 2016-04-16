/**
 * 
 */
package com.moliang.BLL.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysRoleBll;
import com.moliang.DAL.ISysRoleDal;
import com.moliang.DAL.impl.SysRoleDal;
import com.moliang.Model.SysRole;

/**
 * @author Hards
 *
 */
public class SysRoleBll implements ISysRoleBll {


	ISysRoleDal roleDal = new SysRoleDal();
	
	//通过权限ID获取菜单ID
	@Override
	public String getMenuIdsByRoleId(int roleId) {
		String menuIds = roleDal.getMenuIdsByRoleId(roleId);
		return menuIds;
	}

}
