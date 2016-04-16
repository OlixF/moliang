package com.moliang.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysOfficeBll;
import com.moliang.BLL.impl.SysOfficeBll;
import com.moliang.Model.SysAccount;
import com.moliang.Model.SysOffice;
import com.moliang.Model.SysPageBean;
import com.moliang.Util.DateUtil;
import com.moliang.Util.JsonUtil;
import com.moliang.Util.ResponseUtil;
import com.moliang.Util.StringUtil;

/**
 * Servlet implementation class officeServlet
 */
@WebServlet("/officeServlet")
public class officeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ISysOfficeBll officeBll = new SysOfficeBll();
	SysOffice office = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public officeServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		if(action.equals("listByUserRole")){
			this.listByUserRole(request,response);
		}else if(action.equals("list")){
			this.officeList(request,response);
		}else if(action.equals("add")){
			this.officeAdd(request,response);
		}else if(action.equals("update")){
			this.officeUpdate(request,response);
		}else if(action.equals("delete")){
			this.officeDelete(request,response);
		}
		
	}

	private void listByUserRole(HttpServletRequest request,
			HttpServletResponse response) {
		String m_char = request.getParameter("m_char");
		String m_query = request.getParameter("m_query");
		String m_value = request.getParameter("m_value");
		int user_role = Integer.parseInt(request.getParameter("userRole"));
		System.out.println("userRole="+user_role);
		String str = "";
		if(!"".equals(m_query)&&m_query!=null&&"like".equals(m_query)){
			str = m_char + " "+m_query + " '%"+m_value+"%'";
		}else if((!"".equals(m_char)&&m_char!=null)||(!"".equals(m_value)&&m_value!=null)){
			str = m_char + m_query + "'"+m_value+"'";
		}
		int rows = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));
		SysPageBean pageBean = new SysPageBean(rows,page);
		try {
			JSONArray ar = JsonUtil.formatRsToJsonArray(officeBll.getListByUserRole(str,pageBean,user_role));
			JSONObject result = new JSONObject();
			int total = officeBll.getCountByUserRole(str,user_role);
			result.put("rows", ar);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void officeList(HttpServletRequest request,
			HttpServletResponse response) {
		String m_char = request.getParameter("m_char");
		String m_query = request.getParameter("m_query");
		String m_value = request.getParameter("m_value");
		String str = "";
		if(!"".equals(m_query)&&m_query!=null&&"like".equals(m_query)){
			str = m_char + " "+m_query + " '%"+m_value+"%'";
		}else if((!"".equals(m_char)&&m_char!=null)||(!"".equals(m_value)&&m_value!=null)){
			str = m_char + m_query + "'"+m_value+"'";
		}
		int rows = Integer.parseInt(request.getParameter("rows"));
		int page = Integer.parseInt(request.getParameter("page"));
		SysPageBean pageBean = new SysPageBean(rows,page);
		try {
			JSONArray ar = JsonUtil.formatRsToJsonArray(officeBll.getList(str,pageBean));
			JSONObject result = new JSONObject();
			int total = officeBll.getCount(str);
			result.put("rows", ar);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void officeAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Date info_time = null;
		try {
			info_time = DateUtil.formatString(request.getParameter("info_time"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String info_role = request.getParameter("info_role");
		String info_title = request.getParameter("info_title");
		String info_content = request.getParameter("info_content");
		String comment = request.getParameter("comment"); 
		office = new SysOffice(info_time,info_role,info_title,info_content,comment);
		JSONObject ob = new JSONObject();
		if(officeBll.officeAdd(office)){
			System.out.println("数据添加成功。。。");
			ob.put("success", true);
		}else{
			System.out.println("数据添加失败。。。");
			ob.put("success", true);
			ob.put("errorMsg", "数据添加失败!");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void officeUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		int info_id = Integer.parseInt(request.getParameter("info_id"));
		Date info_time = null;
		try {
			info_time = DateUtil.formatString(request.getParameter("info_time"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String info_role = request.getParameter("info_role");
		String info_title = request.getParameter("info_title");
		String info_content = request.getParameter("info_content");
		String comment = request.getParameter("comment"); 
		office = new SysOffice(info_id,info_time,info_role,info_title,info_content,comment);
		JSONObject ob = new JSONObject();
		if(officeBll.officeUpdate(office)){
			System.out.println("数据修改成功。。。");
			ob.put("success", true);
		}else{
			System.out.println("数据修改失败。。。");
			ob.put("success", true);
			ob.put("errorMsg", "数据修改失败!");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void officeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String delIds = request.getParameter("delIds");
		JSONObject ob = new JSONObject();
		int count = 0;
		count =officeBll.officeDelete(delIds);
		if(count != 0){
			System.out.println("成功删除"+count+"条数据。。。");
			ob.put("success", true);
			ob.put("count", count);
		}else{
			System.out.println("删除数据失败。。。");
			ob.put("success", true);
			ob.put("errorMsg", "删除数据失败。。。");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
