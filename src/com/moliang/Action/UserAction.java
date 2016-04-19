package com.moliang.Action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moliang.BLL.IUserBll;
import com.moliang.BLL.impl.UserBll;
import com.moliang.Model.User;
import com.moliang.Util.DateUtil;
import com.moliang.Util.GlobalUtil;
import com.moliang.Util.ResponseUtil;
import com.moliang.Util.StringUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class userAction
 */
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	IUserBll userBll = new UserBll();
	RequestDispatcher rd = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		} else if ("register".equals(action)){
			register(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (StringUtil.isNull(account) || StringUtil.isNull(password)) {
			request.setAttribute("error", "用户名或密码为空，请重新输入！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		User user = null;
		request.setAttribute("password", password);
		if(StringUtil.emailFormat(account)){
			request.setAttribute("email", account);
			user = userBll.LoginByEmail(account, password);
		}else{
//			request.setAttribute("nickname", account);
			user = userBll.LoginByName(account, password);
		}
		if(user!=null){
			session.setAttribute(GlobalUtil.SESSION_KEY,user);
			userBll.UpdateUser(user);
			request.setAttribute("nickname", account);
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("message", "用户名或密码错误，请重新输入！");
			response.sendRedirect("login.jsp");
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();//清除session
		response.sendRedirect("index.jsp");
	}
	

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		User user = new User();
		if(password1.equals(password2)){
			user.setAccount(request.getParameter(""));
			user.setNickname(request.getParameter("name"));
			user.setPasswd(password1);
			user.setAvatar(request.getParameter("avatar"));
			user.setEmail(request.getParameter("email"));
			user.setPhone(request.getParameter("phone"));
			user.setCreate_at(new Timestamp(System.currentTimeMillis()));
		}
		if(userBll.AddUser(user)){
			System.out.println("注册成功。。。");
			request.setAttribute("message", "注册成功，请输入邮箱验证码验证！");
			response.sendRedirect("login.jsp");
		}else{
			System.out.println("注册失败。。。");
			request.setAttribute("message", "注册失败！");
		}
	}
}
