package com.moliang.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moliang.BLL.IGoodsBll;
import com.moliang.BLL.impl.GoodsBll;
import com.moliang.Util.JsonUtil;
import com.moliang.Util.ResponseUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class goodsAction
 */
@WebServlet("/goodsAction")
public class goodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	IGoodsBll goodsBll = new GoodsBll();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsAction() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			try {
				list(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("show".equals(action)){
			show(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("size"));
		JSONArray array = goodsBll.getList(page,size);
		ResponseUtil.write(response, array);
	}
	
	private void show(HttpServletRequest request, HttpServletResponse response) {
		String goodsId = request.getParameter("id");
		
		
	}


}
