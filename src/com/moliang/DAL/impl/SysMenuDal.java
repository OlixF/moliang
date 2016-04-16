package com.moliang.DAL.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.DAL.ISysMenuDal;
import com.moliang.Model.SysMenu;
import com.moliang.Model.SysPageBean;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

public class SysMenuDal implements ISysMenuDal {

	ISysJDBC jdbc = null;
	ResultSet rs = null;
	public SysMenuDal(){
		jdbc = new SysJDBC();
	}

	@Override
	public JSONArray getMenuByParentId(String parentId, String menuIds) {
		JSONArray jsonArray=new JSONArray();
		String sql="select * from sysmenu where parent_id= ? and menu_id in ("+menuIds+")";
		jdbc.getConnection();
		rs=jdbc.executeQuery(sql,parentId);
		try {
			while(rs.next()){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("id", rs.getInt("menu_id"));
				jsonObject.put("text", rs.getString("menu_name"));
				if(!hasChildren(rs.getString("menu_id"), menuIds)){
					jsonObject.put("state", "open");
				}else{
					jsonObject.put("state", rs.getString("menu_state"));				
				}
				jsonObject.put("icon", rs.getString("menu_icon"));
				JSONObject attributeObject=new JSONObject();
				attributeObject.put("menuPath", rs.getString("menu_link"));
				jsonObject.put("attributes", attributeObject);
				jsonArray.add(jsonObject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return jsonArray;
	}

	//判断有没有子菜单
	private boolean hasChildren(String parentId, String menuIds) throws SQLException {
		String sql="select * from sysmenu where parent_id=? and menu_id in ("+menuIds+")";
		ResultSet rs=jdbc.executeQuery(sql,parentId);
		return rs.next();
	}

	@Override
	public int getCount(SysPageBean pageBean) {
		String sSql = "select count(*) from sysmenu";
		jdbc.getConnection();
		rs = jdbc.executeQuery(sSql);
		int count = 0;
		try {
			if(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close();
		}
		return count;
	}

	@Override
	public JSONArray getList() {
		String sSql = "select * from sysmenu";
		JSONArray array = new JSONArray();
		JSONObject ob = new JSONObject();
		jdbc.getConnection();
		rs = jdbc.executeQuery(sSql);
		try {
			while(rs.next()){
				ob.put("menuId", rs.getInt("menu_id"));
				ob.put("menuName", rs.getString("menu_name"));
				ob.put("menuLink", rs.getString("menu_link"));
				ob.put("menuState", rs.getString("menu_state"));
				ob.put("parentId", rs.getInt("parent_id"));
				ob.put("menuIcon",rs.getString("menu_icon"));
				array.add(ob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			jdbc.close();
		}
		return array;
	}

	//获取父目录为parentId菜单信息
	@Override
	public JSONArray getTreeByparentId(int parentId) {
		String sSql = "select * from sysmenu where parent_id = ?";
		jdbc.getConnection();
		rs = jdbc.executeQuery(sSql, parentId);
		JSONObject ob = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			while(rs.next()){
				ob.put("menuId", rs.getInt("menu_id"));
				ob.put("menuName", rs.getString("menu_name"));
				ob.put("menuLink", rs.getString("menu_link"));
				ob.put("menuState", rs.getString("menu_state"));
				ob.put("parentId",rs.getInt("parent_id"));
				ob.put("menuIcon", rs.getString("menu_icon"));
				ob.put("comment", rs.getString("comment"));
				array.add(ob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			jdbc.close();
		}
		return array;
	}

	@Override
	public int menuAdd(SysMenu menu) {
		String sSql = "insert into sysmenu values(null,?,?,'open',?,?,?)";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql, menu.getMenu_name(),
				menu.getMenu_link(),
				menu.getParent_id(),
				menu.getMenu_icon(),
				menu.getComment());
		jdbc.close();
		return count;
	}

	@Override
	public int menuUpdate(SysMenu menu) {
		String sSql = "update sysmenu set menu_name=?,menu_link=?,menu_icon=?,comment=? where menu_id=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql, menu.getMenu_name(),
				menu.getMenu_link(),menu.getMenu_icon(),
				menu.getComment(),menu.getMenu_id());
		jdbc.close();
		return count;
	}

	@Override
	public int menuDelete(int menuId) {
		String sSql = "delete from sysmenu where menu_id=?";
		jdbc.getConnection();
		int count = 0;
		count = jdbc.executeUpdate(sSql, menuId);
		jdbc.close();
		return count;
	}

}
