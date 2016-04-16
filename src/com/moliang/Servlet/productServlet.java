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

import com.moliang.BLL.ISysProductBll;
import com.moliang.BLL.impl.SysProductBll;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysProduct;
import com.moliang.Util.DateUtil;
import com.moliang.Util.ExcelUtil;
import com.moliang.Util.JsonUtil;
import com.moliang.Util.ResponseUtil;
import com.moliang.Util.StringUtil;


/**
 * Servlet implementation class productServlet
 */
@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ISysProductBll productBll = new SysProductBll();
	SysProduct product = null;

	/*
	 * @see HttpServlet#HttpServlet()
	 */
	public productServlet() {
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
			this.productList(request,response);
		}else if(action.equals("add")){
			this.productAdd(request,response);
		}else if(action.equals("update")){
			this.productUpdate(request,response);
		}else if(action.equals("delete")){
			this.productDelete(request,response);
		}else if(action.equals("import")){
			this.productImport(request,response);
		}else if(action.equals("export")){
			this.productExport(request,response);
		}
	}

	/**
	 * 列出采购记录
	 */
	private void productList(HttpServletRequest request, HttpServletResponse response) {

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
			JSONArray ar = JsonUtil.formatRsToJsonArray(productBll.getList(str,pageBean));
			JSONArray ar2 = JsonUtil.formatRsToJsonArrayFooter(productBll.productTotal(str),"product");
			JSONObject result = new JSONObject();
			int total = productBll.getCount(str);
			result.put("rows", ar);
			result.put("total", total);
			result.put("footer", ar2);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 添加采购记录
	 */
	private void productAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String p_id = request.getParameter("product_id");
		String p_NO = request.getParameter("product_NO");
		String p_name = request.getParameter("product_name");
		double p_price = Double.parseDouble(request.getParameter("product_price"));
		int buy_num = Integer.parseInt(request.getParameter("buy_num"));
		double p_total = Double.parseDouble(request.getParameter("product_total"));
		Date buy_time = null;
		try {
			buy_time = DateUtil.formatString(request.getParameter("buy_time"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String buy_way = request.getParameter("buy_way");
		String buy_person = request.getParameter("buy_person");
		String person_phone = request.getParameter("person_phone");
		String comment = request.getParameter("comment"); 
		SysProduct product = new SysProduct(p_id,p_NO, p_name, p_price, buy_num, 
				p_total, buy_time, buy_way, buy_person, person_phone, comment);
		JSONObject ob = new JSONObject();
		if(productBll.productAdd(product)){
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
	/**
	 * 更新采购记录
	 */
	private void productUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		String p_id = request.getParameter("product_id");
		String p_NO = request.getParameter("product_NO");
		String p_name = request.getParameter("product_name");
		double p_price = Float.parseFloat(request.getParameter("product_price"));
		int buy_num = Integer.parseInt(request.getParameter("buy_num"));
		double p_total = Float.parseFloat(request.getParameter("product_total"));
		Date buy_time = null;
		try {
			buy_time = DateUtil.formatString(request.getParameter("buy_time"), "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String buy_way = request.getParameter("buy_way");
		String buy_person = request.getParameter("buy_person");
		String person_phone = request.getParameter("person_phone");
		String comment = request.getParameter("comment"); 
		SysProduct product = new SysProduct(p_id, p_NO, p_name, p_price, buy_num, 
				p_total, buy_time, buy_way, buy_person, person_phone, comment);
		JSONObject ob = new JSONObject();
		if(productBll.productUpdate(product)){
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
	/**
	 * 删除采购记录
	 */
	private void productDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String delIds = request.getParameter("delIds");
		JSONObject ob = new JSONObject();
		int count = 0;
		count = productBll.productDelete(delIds);
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

	/**
	 * 导入采购数据
	 */
	private void productImport(HttpServletRequest request,
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
								SysProduct product = new SysProduct();
								product.setProduct_id(ExcelUtil.getCell(hssfRow.getCell(0)));
								product.setProduct_NO(ExcelUtil.getCell(hssfRow.getCell(1)));
								product.setProduct_name(ExcelUtil.getCell(hssfRow.getCell(2)));
								product.setProduct_price(Double.parseDouble(ExcelUtil.formatCell(hssfRow.getCell(3))));
								product.setBuy_num((int) Math.floor(Float.parseFloat(ExcelUtil.formatCell(hssfRow.getCell(4)))));
								product.setProduct_total(Double.parseDouble(ExcelUtil.formatCell(hssfRow.getCell(5))));
								try {
									product.setBuy_time(DateUtil.formatString(ExcelUtil.getCell(hssfRow.getCell(6)), "yyyy-MM-dd"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								product.setBuy_way(ExcelUtil.formatCell(hssfRow.getCell(7)));
								product.setBuy_person(ExcelUtil.formatCell(hssfRow.getCell(8)));
								product.setPerson_phone(ExcelUtil.formatCell(hssfRow.getCell(9)));
								product.setComment(ExcelUtil.formatCell(hssfRow.getCell(10)));
								if(StringUtil.isNull(product.getProduct_NO())||
										StringUtil.isNull(product.getProduct_name())||
										StringUtil.isNull(product.getBuy_person())){
									str =str + (rowNum+1) +",";
									faileNum ++ ;
								}else if(productBll.productImport(product)){
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

	/**
	 * 导出采购数据
	 */
	private void productExport(HttpServletRequest request,
			HttpServletResponse response) {
		String Ids = request.getParameter("Ids");
		Workbook wb;
		try {
			wb = ExcelUtil.fillExcelDataWithTemplate(productBll.productExport(Ids), "采购清单.xls");
			ResponseUtil.export(response, wb, "采购清单.xls");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
