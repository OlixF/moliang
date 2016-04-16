package com.moliang.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysUserBll;
import com.moliang.BLL.impl.SysUserBll;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysUser;
import com.moliang.Util.GlobalUtil;
import com.moliang.Util.JsonUtil;
import com.moliang.Util.ResponseUtil;
import com.moliang.Util.StringUtil;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ISysUserBll userBll = new SysUserBll();
	RequestDispatcher rd = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userServlet() {
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
		if ("login".equals(action)) {
			login(request, response);
		} else if ("logout".equals(action)) {
			logout(request, response);
		} else if ("modifyPassword".equals(action)) {
			modifyPassword(request, response);
		} else if ("list".equals(action)) {
			list(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
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
			JSONArray ar = JsonUtil.formatRsToJsonArray(userBll.getList(str,pageBean));
			JSONObject result = new JSONObject();
			int total = userBll.getCount(str);
			result.put("rows", ar);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		/*String imageCode = request.getParameter("imageCode");*/
		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		/*request.setAttribute("imageCode", imageCode);*/
		if (StringUtil.isNull(userName) || StringUtil.isNull(password)) {
			request.setAttribute("error", "用户名或密码为空！");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}
		/*if (StringUtil.isNull(imageCode)) {
			request.setAttribute("error", "验证码为空！");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}
		if (!imageCode.equals(session.getAttribute("sRand"))) {
			request.setAttribute("error", "验证码错误！");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}*/
		SysUser user = null;
		user = userBll.Login(userName, password);
		if(user!=null){
			session.setAttribute(GlobalUtil.SESSION_KEY,user);
			session.setAttribute("user_role", user.getUser_role());
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("massage", "用户名或密码错误，请重新输入！");
			response.sendRedirect("login.jsp");
		}
	}

	private void modifyPassword(HttpServletRequest request,
			HttpServletResponse response) {
		String newPwd = request.getParameter("newPwd");
		int userId = Integer.parseInt(request.getParameter("userId"));
		JSONObject result = new JSONObject();
		try {
			if(userBll.updatePwdById(userId,newPwd)){
				System.out.println("密码修改成功。。。");
				result.put("success", "true");
			} else{
				System.out.println("密码修改失败。。。");
				result.put("success", "true");
				result.put("errorMsg", "修改密码失败！");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();//清除session
		response.sendRedirect("login.jsp");
	}
}
