package com.moliang.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysMenuBll;
import com.moliang.BLL.ISysRoleBll;
import com.moliang.BLL.impl.SysMenuBll;
import com.moliang.BLL.impl.SysRoleBll;
import com.moliang.Model.SysMenu;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysUser;
import com.moliang.Util.ResponseUtil;


/**
 * Servlet implementation class meanServlet
 */
@WebServlet("/menuServlet")
public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ISysRoleBll roleBll = new SysRoleBll();
	ISysMenuBll menuBll = new SysMenuBll();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public menuServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action.equals("menu")){
			this.menuAction(request, response);
		} else if (action.equals("list")){
			this.menuList(request,response);
		} else if (action.equals("add")){
			this.menuAdd(request,response);
		} else if (action.equals("update")){
			this.menuUpdate(request,response);
		} else if (action.equals("delete")){
			this.menuDelete(request,response);
		}
	}

	private void menuDelete(HttpServletRequest request,
			HttpServletResponse response) {
		int menuId = Integer.parseInt(request.getParameter("menuId")); 
		JSONObject ob = new JSONObject();
		if(menuBll.menuDelete(menuId)){
			System.out.println("数据删除成功。。。");
			ob.put("success", true);
		}else{
			System.out.println("数据删除失败。。。");
			ob.put("success", true);
			ob.put("errorMsg", "数据删除失败！");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void menuUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		String menuName = request.getParameter("menuName");
		String menuLink = request.getParameter("menuLink");
		String menuIcon = request.getParameter("menuIcon");
		String comment = request.getParameter("comment");
		
		SysMenu menu = new SysMenu(menuName,menuLink,menuIcon,comment,menuId);
		JSONObject ob = new JSONObject();
		if(menuBll.menuUpdate(menu)){
			System.out.println("数据更新成功。。。");
			ob.put("success", true);
		}else{
			System.out.println("数据更新失败。。。");
			ob.put("success",true);
			ob.put("erroeMsg","数据更新失败！");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void menuAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String menuName = request.getParameter("menuName");
		String menuLink = request.getParameter("menuLink");
		String menuIcon = request.getParameter("menuIcon");
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String comment = request.getParameter("comment");
		
		JSONObject ob = new JSONObject();
		SysMenu menu = new SysMenu(menuName, menuLink, menuIcon, parentId, comment);
		if(menuBll.menuAdd(menu)){
			System.out.println("数据添加成功。。。");
			ob.put("success", "true");
		}else{
			System.out.println("数据添加失败。。。");
			ob.put("success", "true");
			ob.put("errorMsg", "数据添加失败！");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void menuList(HttpServletRequest request,
			HttpServletResponse response) {
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		JSONArray array = menuBll.getListByParentId(parentId);
		try {
			ResponseUtil.write(response, array);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void menuAction(HttpServletRequest request,
			HttpServletResponse response) {
		String parentId = request.getParameter("parentId");
		HttpSession session=request.getSession();
		SysUser user = (SysUser) session.getAttribute("COMPANY_SESSION");
		String menuIds = roleBll.getMenuIdsByRoleId(user.getUser_role());
		JSONArray jsonArray = menuBll.getMenusByParentId(parentId, menuIds);
		try {
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
