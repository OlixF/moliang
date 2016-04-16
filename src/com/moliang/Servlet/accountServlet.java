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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moliang.BLL.ISysAccountBll;
import com.moliang.BLL.impl.SysAccountBll;
import com.moliang.Model.SysAccount;
import com.moliang.Model.SysPageBean;
import com.moliang.Util.DateUtil;
import com.moliang.Util.ExcelUtil;
import com.moliang.Util.JsonUtil;
import com.moliang.Util.ResponseUtil;
import com.moliang.Util.StringUtil;

/**
 * Servlet implementation class accountServlet
 */
@WebServlet("/accountServlet")
public class accountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ISysAccountBll accountBll = new SysAccountBll();
	SysAccount account = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public accountServlet() {
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
			this.accountList(request,response);
		}else if(action.equals("add")){
			this.accountAdd(request,response);
		}else if(action.equals("update")){
			this.accountUpdate(request,response);
		}else if(action.equals("delete")){
			this.accountDelete(request,response);
		}else if(action.equals("import")){
			this.accountImport(request,response);
		}else if(action.equals("export")){
			this.accountExport(request,response);
		}
	}


	/*
	 * ��ȡ��ˮ���б�
	 * */
	private void accountList(HttpServletRequest request,
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
			JSONArray ar = JsonUtil.formatRsToJsonArray(accountBll.getList(str,pageBean));
			JSONArray ar2 = JsonUtil.formatRsToJsonArrayFooter(accountBll.accountTotal(str),"account");
			JSONObject result = new JSONObject();
			int total = accountBll.getCount(str);
			result.put("rows", ar);
			result.put("total", total);
			result.put("footer", ar2);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * �����ˮ������
	 * */
	private void accountAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Date a_date = null;
		try {
			a_date = DateUtil.formatString(request.getParameter("account_date"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String a_id = request.getParameter("account_id");
		String a_abstract = request.getParameter("account_abstract");
		String a_unit = request.getParameter("account_unit");
		String a_side_unit = request.getParameter("account_side_unit");
		double a_income = 0.00;
		double a_expenditure = 0.00;
		if(!StringUtil.isNull(request.getParameter("account_income"))){
			a_income = Double.parseDouble(request.getParameter("account_income"));
		}
		if(!StringUtil.isNull(request.getParameter("account_expenditure"))){
			a_expenditure = Double.parseDouble(request.getParameter("account_expenditure"));
		}
		String comment = request.getParameter("comment"); 
		account = new SysAccount(a_date, a_id, a_abstract, a_unit, a_side_unit, a_income, a_expenditure, comment);
		JSONObject ob = new JSONObject();
		if(accountBll.accountAdd(account)){
			System.out.println("������ӳɹ�������");
			ob.put("success", true);
		}else{
			System.out.println("�������ʧ�ܡ�����");
			ob.put("success", true);
			ob.put("errorMsg", "�������ʧ��!");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * ������ˮ������
	 * */
	private void accountUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Date a_date = null;
		try {
			a_date = DateUtil.formatString(request.getParameter("account_date"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String a_id = request.getParameter("account_id");
		String a_abstract = request.getParameter("account_abstract");
		String a_unit = request.getParameter("account_unit");
		String a_side_unit = request.getParameter("account_side_unit");
		double a_income = 0;
		double a_expenditure = 0;
		if(!StringUtil.isNull(request.getParameter("account_income"))){
			a_income = Double.parseDouble(request.getParameter("account_income"));
		}
		if(!StringUtil.isNull(request.getParameter("account_expenditure"))){
			a_expenditure = Double.parseDouble(request.getParameter("account_expenditure"));
		}
		String comment = request.getParameter("comment"); 
		account = new SysAccount(a_date, a_id, a_abstract, a_unit, a_side_unit, a_income, a_expenditure, comment);
		JSONObject ob = new JSONObject();
		if(accountBll.accountUpdate(account)){
			System.out.println("�����޸ĳɹ�������");
			ob.put("success", true);
		}else{
			System.out.println("�����޸�ʧ�ܡ�����");
			ob.put("success", true);
			ob.put("errorMsg", "�����޸�ʧ��!");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ɾ����ˮ������
	 * */
	private void accountDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String delIds = request.getParameter("delIds");
		JSONObject ob = new JSONObject();
		int count = 0;
		count = accountBll.accountDelete(delIds);
		if(count != 0){
			System.out.println("�ɹ�ɾ��"+count+"�����ݡ�����");
			ob.put("success", true);
			ob.put("count", count);
		}else{
			System.out.println("ɾ������ʧ�ܡ�����");
			ob.put("success", true);
			ob.put("errorMsg", "ɾ������ʧ�ܡ�����");
		}
		try {
			ResponseUtil.write(response, ob);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * ������ˮ������
	 * */
	private void accountImport(HttpServletRequest request,
			HttpServletResponse response) {
		int successNum = 0;//ִ�гɹ�������
		int faileNum = 0;//ִ��ʧ�ܵ�����
		String str = "";
		if(ServletFileUpload.isMultipartContent(request)){//�ж��Ƿ����ϴ��ļ�
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items =null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator iter = items.iterator();//��ȡ�ϴ��ļ�������
			while(iter.hasNext()){
				FileItem formitem = (FileItem) iter.next();//��ȡÿ���ϴ��ļ�
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
						HSSFWorkbook wb=new HSSFWorkbook(fs);//�õ��ĵ�����  
						HSSFSheet hssfSheet=wb.getSheetAt(0);//�õ���һ����  
						if(hssfSheet!=null){
							for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
								HSSFRow hssfRow=hssfSheet.getRow(rowNum);
								if(hssfRow==null){
									continue;
								}
								account = new SysAccount();
								try {
									account.setAccount_date(DateUtil.formatString(ExcelUtil.getCell(hssfRow.getCell(0)), "yyyy-MM-dd"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								account.setAccount_id(ExcelUtil.getCell(hssfRow.getCell(1)));
								account.setAccount_abstract(ExcelUtil.getCell(hssfRow.getCell(2)));
								account.setAccount_unit(ExcelUtil.formatCell(hssfRow.getCell(3)));
								account.setAccount_side_unit(ExcelUtil.formatCell(hssfRow.getCell(4)));
								if(StringUtil.isNull(ExcelUtil.formatCell(hssfRow.getCell(5)))){
									account.setAccount_income(0);
								}else{
									account.setAccount_income(Double.parseDouble(ExcelUtil.formatCell(hssfRow.getCell(5))));
								}
								if(StringUtil.isNull(ExcelUtil.formatCell(hssfRow.getCell(6)))){
									account.setAccount_expenditure(0);
								}else{
									account.setAccount_expenditure(Double.parseDouble(ExcelUtil.formatCell(hssfRow.getCell(6))));
								}
								account.setComment(ExcelUtil.formatCell(hssfRow.getCell(7)));
								if(StringUtil.isNull(account.getAccount_date())||
										StringUtil.isNull(account.getAccount_abstract())||
										StringUtil.isNull(account.getAccount_id())){
									str =str + (rowNum+1) +",";
									faileNum ++ ;
								}else if(accountBll.accountImport(account)){
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
	 * ������ˮ������
	 * */
	private void accountExport(HttpServletRequest request,
			HttpServletResponse response) {
		String Ids = request.getParameter("Ids");
		JSONObject result = new JSONObject();
		Workbook wb;
		try {
			wb = ExcelUtil.fillExcelDataWithTemplate(accountBll.accountExport(Ids), "�ʽ���ˮ��.xls");
			ResponseUtil.export(response, wb, "�ʽ���ˮ��.xls");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
