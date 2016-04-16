package com.moliang.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysMemberBll;
import com.moliang.BLL.impl.SysMemberBll;
import com.moliang.Model.SysMember;
import com.moliang.Model.SysPageBean;
import com.moliang.Util.DateUtil;
import com.moliang.Util.ExcelUtil;
import com.moliang.Util.JsonUtil;
import com.moliang.Util.ResponseUtil;
import com.moliang.Util.StringUtil;


/**
 * Servlet implementation class memberServlet
 */
@WebServlet("/memberServlet")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ISysMemberBll memberBll = new SysMemberBll();
	SysMember member = null;

	/*
	 * @see HttpServlet#HttpServlet()
	 */
	public memberServlet() {
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
		if(action.equals("list")){
			this.memberList(request,response);
		}else if(action.equals("add")){
			this.memberAdd(request,response);
		}else if(action.equals("update")){
			this.memberUpdate(request,response);
		}else if(action.equals("delete")){
			this.memberDelete(request,response);
		}else if(action.equals("import")){
			this.memberImport(request,response);
		}else if(action.equals("export")){
			this.memberExport(request,response);
		}
	}

	private void memberList(HttpServletRequest request, HttpServletResponse response) {

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
			JSONArray ar = JsonUtil.formatRsToJsonArray(memberBll.getList(str,pageBean));
			JSONObject result = new JSONObject();
			int total = memberBll.getCount(str);
			result.put("rows", ar);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void memberAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String m_id = request.getParameter("member_number");
		String m_name = request.getParameter("member_name");
		String m_sex = request.getParameter("member_sex");
		Date m_birth = null;
		try {
			m_birth = DateUtil.formatString(request.getParameter("member_birth"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String m_card = request.getParameter("member_card");
		String m_photo = request.getParameter("member_photo");
		String m_minz = request.getParameter("member_minz");
		String m_zzmm = request.getParameter("member_zzmm");
		String m_hyzk = request.getParameter("member_hyzk");
		String m_phone = request.getParameter("member_phone");
		String m_email = request.getParameter("member_email");
		String m_qq = request.getParameter("member_qq");
		String m_department = request.getParameter("member_department");
		String m_job = request.getParameter("member_job");
		String m_address = request.getParameter("member_address");
		String comment = request.getParameter("comment");
		SysMember member = new SysMember(m_id, m_name, m_sex, m_birth, 
				m_card, m_photo, m_minz, m_hyzk, m_zzmm, 
				m_phone, m_email, m_qq, m_address, m_department, m_job, comment);
		JSONObject ob = new JSONObject();
		if(!memberBll.exist(member)){
			if(memberBll.memberAdd(member)){
				System.out.println("数据添加成功。。。");
				ob.put("success", true);
			}else{
				System.out.println("数据添加失败。。。");
				ob.put("success", true);
				ob.put("errorMsg", "数据添加失败!");
			}
		}
		else{
			ob.put("success", true);
			ob.put("errorMsg", "用户信息已存在，如需要修改该用户信息请点击用户修改!");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void memberUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		String m_id = request.getParameter("member_number");
		String m_sex = request.getParameter("member_sex");
		Date m_birth = null;
		try {
			m_birth = DateUtil.formatString(request.getParameter("member_birth"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String m_photo = request.getParameter("member_photo");
		String m_minz = request.getParameter("member_minz");
		String m_zzmm = request.getParameter("member_zzmm");
		String m_hyzk = request.getParameter("member_hyzk");
		String m_phone = request.getParameter("member_phone");
		String m_email = request.getParameter("member_email");
		String m_qq = request.getParameter("member_qq");
		String m_department = request.getParameter("member_department");
		String m_job = request.getParameter("member_job");
		String m_address = request.getParameter("member_address");
		String comment = request.getParameter("comment"); 
		SysMember member = new SysMember(m_id, m_sex, m_birth,  m_photo, m_minz, m_hyzk, m_zzmm, 
				m_phone, m_email, m_qq, m_address, m_department, m_job, comment);
		JSONObject ob = new JSONObject();
		if(memberBll.memberUpdate(member)){
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

	private void memberDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String delIds = request.getParameter("delIds");
		JSONObject ob = new JSONObject();
		int count = 0;
		count = memberBll.memberDelete(delIds);
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
	
	private void memberImport(HttpServletRequest request,
			HttpServletResponse response) {
		int successNum = 0;//执行成功的数据
		int faileNum = 0;//执行失败的数据
		String str = "";
		//		//String sDir = request.getSession().getServletContext().getRealPath("file");
		//		String sDir = "D:\\workspace\\OAsystem\\WebContent\\WEB-INF\\upload";
		//		System.out.println("sDir:"+sDir);
		//		File file = new File(sDir);
		//		if (!file.exists()) {
		//			file.mkdirs();//创建目录树
		//		}
		if(ServletFileUpload.isMultipartContent(request)){//判断是否是上传文件
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items =null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator iter = items.iterator();//获取上传文件迭代器
			while(iter.hasNext()){
				FileItem formitem = (FileItem) iter.next();//获取每个上传文件
				if(!formitem.isFormField()){
					String name = formitem.getName();
					if(StringUtil.isNull(name)){
						continue;
					}
					//String path = sDir + "\\" + name.substring(name.lastIndexOf("\\")+1, name.length());
					//String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"\\upload\\"+ name.substring(name.lastIndexOf("\\")+1, name.length());
					String path =name.substring(name.lastIndexOf("\\")+1, name.length());
					System.out.println(path);
					File saveFile = new File(path);
					try {
						formitem.write(saveFile);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JSONObject result=new JSONObject();
					try {
						POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(saveFile));
						HSSFWorkbook wb=new HSSFWorkbook(fs);//得到文档对象  
						HSSFSheet hssfSheet=wb.getSheetAt(0);//得到第一个表单  
						if(hssfSheet!=null){
							for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
								HSSFRow hssfRow=hssfSheet.getRow(rowNum);
								if(hssfRow==null){
									continue;
								}
								SysMember member = new SysMember();
								member.setMember_number(ExcelUtil.getCell(hssfRow.getCell(0)));
								member.setMember_name(ExcelUtil.getCell(hssfRow.getCell(1)));
								member.setMember_sex(ExcelUtil.getCell(hssfRow.getCell(2)));
								try {
									member.setMember_birth(DateUtil.formatString(ExcelUtil.getCell(hssfRow.getCell(3)), "yyyy-MM-dd"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								member.setMember_card(ExcelUtil.getCell(hssfRow.getCell(4)));
								member.setMember_photo(ExcelUtil.getCell(hssfRow.getCell(5)));
								member.setMember_minz(ExcelUtil.getCell(hssfRow.getCell(6)));
								member.setMember_hyzk(ExcelUtil.getCell(hssfRow.getCell(7)));
								member.setMember_zzmm(ExcelUtil.getCell(hssfRow.getCell(8)));
								member.setMember_phone(ExcelUtil.getCell(hssfRow.getCell(9)));
								member.setMember_email(ExcelUtil.getCell(hssfRow.getCell(10)));
								member.setMember_qq(ExcelUtil.getCell(hssfRow.getCell(11)));
								member.setMember_address(ExcelUtil.getCell(hssfRow.getCell(12)));
								member.setMember_department(ExcelUtil.getCell(hssfRow.getCell(13)));
								member.setMember_job(ExcelUtil.getCell(hssfRow.getCell(14)));
								member.setComment(ExcelUtil.getCell(hssfRow.getCell(15)));
								if(StringUtil.isNull(member.getMember_number())||
										StringUtil.isNull(member.getMember_name())||
										StringUtil.isNull(member.getMember_card())){
									str =str + (rowNum+1) +",";
									faileNum ++ ;
								}else if(memberBll.memberImport(member)){
									successNum ++ ;
								}else{
									str =str + (rowNum+1) +",";
									faileNum ++ ;
								}
							}
						}
					} catch (FileNotFoundException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					}
					result.put("success", true);
					result.put("successNum", successNum);
					result.put("faileNum", faileNum);
					result.put("info",str);
					try {
						ResponseUtil.write(response, result);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void memberExport(HttpServletRequest request,
			HttpServletResponse response) {
		String Ids = request.getParameter("Ids");
		Workbook wb;
		try {
			wb = ExcelUtil.fillExcelDataWithTemplate(memberBll.memberExport(Ids), "员工信息表.xls");
			ResponseUtil.export(response, wb, "员工信息表.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
