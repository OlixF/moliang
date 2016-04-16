package com.moliang.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
/*import org.apache.struts2.ServletActionContext;*/

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysStudentBll;
import com.moliang.BLL.impl.SysStudentBll;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysStudent;
import com.moliang.Util.DateUtil;
import com.moliang.Util.ExcelUtil;
import com.moliang.Util.JsonUtil;
import com.moliang.Util.ResponseUtil;
import com.moliang.Util.StringUtil;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/studentServlet")
public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ISysStudentBll studentBll = new SysStudentBll();
	SysStudent student = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public studentServlet() {
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
		if(action.equals("list")){
			this.studentList(request,response);
		}else if(action.equals("add")){
			this.studentAdd(request,response);
		}else if(action.equals("update")){
			this.studentUpdate(request,response);
		}else if(action.equals("delete")){
			this.studentDelete(request,response);
		}else if(action.equals("import")){
			this.studentImport(request,response);
		}else if(action.equals("export")){
			this.studentExport(request,response);
		}
	}


	/*
	 * 获取流水账列表
	 * */
	private void studentList(HttpServletRequest request,
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
			JSONArray ar = JsonUtil.formatRsToJsonArray(studentBll.getList(str,pageBean));
			JSONObject result = new JSONObject();
			int total = studentBll.getCount(str);
			result.put("rows", ar);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 添加流水账数据
	 * */
	private void studentAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String s_NO = request.getParameter("student_NO");
		String s_name = request.getParameter("student_name");
		String s_sex = request.getParameter("student_sex");
		String s_card = request.getParameter("student_card");
		Date s_birth = null;
		try {
			s_birth = DateUtil.formatString(request.getParameter("student_birth"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String s_minz = request.getParameter("student_minz");
		String s_zzmm = request.getParameter("student_zzmm");
		String s_phone = request.getParameter("student_phone");
		String s_email = request.getParameter("student_email");
		String s_qq = request.getParameter("student_qq");
		String s_address = request.getParameter("student_address");
		String s_school = request.getParameter("student_school");
		String s_major = request.getParameter("student_major");
		String s_job = request.getParameter("student_job");
		String comment = request.getParameter("comment"); 
		student = new SysStudent(s_NO,s_name,s_sex,s_birth,s_card,s_minz,s_zzmm,s_phone,
				s_email,s_qq,s_address,s_school,s_major,s_job,comment);
		JSONObject ob = new JSONObject();
		if(!studentBll.exist(student)){
			if(studentBll.studentAdd(student)){
				System.out.println("数据添加成功。。。");
				ob.put("success", true);
			}else{
				System.out.println("数据添加失败。。。");
				ob.put("success", true);
				ob.put("errorMsg", "数据添加失败!");
			}
		}else{
			System.out.println("该学生信息已存在。。。");
			ob.put("success", true);
			ob.put("errorMsg", "该学生信息已存在，如需修改该学生信息请点击修改!");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 更新流水账数据
	 * */
	private void studentUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		String s_NO = request.getParameter("student_NO");
		String s_name = request.getParameter("student_name");
		String s_sex = request.getParameter("student_sex");
		String s_card = request.getParameter("student_card");
		Date s_birth = null;
		try {
			s_birth = DateUtil.formatString(request.getParameter("student_birth"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String s_minz = request.getParameter("student_minz");
		String s_zzmm = request.getParameter("student_zzmm");
		String s_phone = request.getParameter("student_phone");
		String s_email = request.getParameter("student_email");
		String s_qq = request.getParameter("student_qq");
		String s_address = request.getParameter("student_address");
		String s_school = request.getParameter("student_school");
		String s_major = request.getParameter("student_major");
		String s_job = request.getParameter("student_job");
		String comment = request.getParameter("comment"); 
		student = new SysStudent(s_NO,s_name,s_sex,s_birth,s_card,s_minz,s_zzmm,s_phone,
				s_email,s_qq,s_address,s_school,s_major,s_job,comment);
		JSONObject ob = new JSONObject();
		if(studentBll.studentUpdate(student)){
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

	/*
	 * 删除流水账数据
	 * */
	private void studentDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String delIds = request.getParameter("delIds");
		JSONObject ob = new JSONObject();
		int count = 0;
		count = studentBll.studentDelete(delIds);
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

	/*
	 * 导入流水账数据
	 * */
	private void studentImport(HttpServletRequest request,
			HttpServletResponse response) {
		int successNum = 0;//执行成功的数据
		int faileNum = 0;//执行失败的数据
		String str = "";
		if(ServletFileUpload.isMultipartContent(request)){//判断是否是上传文件
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items =null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
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
								student = new SysStudent();
								student.setStudent_NO(ExcelUtil.getCell(hssfRow.getCell(0)));
								student.setStudent_name(ExcelUtil.getCell(hssfRow.getCell(1)));
								student.setStudent_sex(ExcelUtil.getCell(hssfRow.getCell(2)));
								try {
									student.setStudent_birth(DateUtil.formatString(ExcelUtil.getCell(hssfRow.getCell(3)), "yyyy-MM-dd"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								student.setStudent_card(ExcelUtil.getCell(hssfRow.getCell(4)));
								student.setStudent_minz(ExcelUtil.getCell(hssfRow.getCell(5)));
								student.setStudent_zzmm(ExcelUtil.getCell(hssfRow.getCell(6)));
								student.setStudent_phone(ExcelUtil.getCell(hssfRow.getCell(7)));
								student.setStudent_email(ExcelUtil.getCell(hssfRow.getCell(8)));
								student.setStudent_qq(ExcelUtil.getCell(hssfRow.getCell(9)));
								student.setStudent_address(ExcelUtil.getCell(hssfRow.getCell(10)));
								student.setStudent_school(ExcelUtil.getCell(hssfRow.getCell(11)));
								student.setStudent_major(ExcelUtil.getCell(hssfRow.getCell(12)));
								student.setStudent_job(ExcelUtil.getCell(hssfRow.getCell(13)));
								student.setComment(ExcelUtil.formatCell(hssfRow.getCell(14)));
								if(StringUtil.isNull(student.getStudent_NO())||
										StringUtil.isNull(student.getStudent_name())||
										StringUtil.isNull(student.getStudent_card())){
									str =str + (rowNum+1) +",";
									faileNum ++ ;
								}else if(studentBll.studentImport(student)){
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

	/*
	 * 导出流水账数据
	 * */
	private void studentExport(HttpServletRequest request,
			HttpServletResponse response) {
		String Ids = request.getParameter("Ids");
		Workbook wb;
		try {
			wb = ExcelUtil.fillExcelDataWithTemplate(studentBll.studentExport(Ids), "学生信息表.xls");
			ResponseUtil.export(response, wb, "学生信息表.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
