package com.moliang.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {

	public static void fillExcelData(ResultSet rs,Workbook wb,String[] headers)throws Exception{
		int rowIndex=0;
		Sheet sheet=wb.createSheet();
		Row row=sheet.createRow(rowIndex++);
		for(int i=0;i<headers.length;i++){
			row.createCell(i).setCellValue(headers[i]);
		}
		while(rs.next()){
			row=sheet.createRow(rowIndex++);
			for(int i=0;i<headers.length;i++){
				row.createCell(i).setCellValue(rs.getObject(i+1).toString());
			}
		}
	}

	public static Workbook fillExcelDataWithTemplate(ResultSet rs,String templateFileName)throws Exception{
		InputStream inp=ExcelUtil.class.getResourceAsStream("/com/etc/template/"+templateFileName);
		POIFSFileSystem fs=new POIFSFileSystem(inp);
		Workbook wb=new HSSFWorkbook(fs);
		Sheet sheet=wb.getSheetAt(0);
		// 获取列数
		int cellNums=sheet.getRow(0).getLastCellNum();
		int rowIndex=1;
		while(rs.next()){
			Row row=sheet.createRow(rowIndex++);
			for(int i=0;i<cellNums;i++){
				row.createCell(i).setCellValue(rs.getObject(i+1).toString());
			}
		}
		return wb;
	}

	/*
	 * Excel数据处理：
		Excel存储日期、时间均以数值类型进行存储，读取时POI先判断是是否是数值类型，再进行判断转化
	1、数值格式(CELL_TYPE_NUMERIC):
		1.1纯数值格式：getNumericCellValue() 直接获取数据
		1.2日期格式：处理yyyy-MM-dd, d/m/yyyy h:mm, HH:mm 等不含文字的日期格式
			1).判断是否是日期格式：HSSFDateUtil.isCellDateFormatted(cell)
			2).判断是日期或者时间
				cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")
			OR:	cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("yyyy-MM-dd")
		1.3自定义日期格式：处理yyyy年m月d日,h时mm分,yyyy年m月等含文字的日期格式
			判断cell.getCellStyle().getDataFormat()值，解析数值格式
				yyyy年m月d日----->31
				m月d日---->58
				h时mm分--->32
	2、字符格式(CELL_TYPE_STRING):直接获取内容
	 */
	public static String formatCell(HSSFCell hssfCell){
		if(hssfCell==null){
			return "";
		}else{
			if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
				return String.valueOf(hssfCell.getBooleanCellValue());
			}else if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
				return String.valueOf(hssfCell.getNumericCellValue());
			}else{
				return String.valueOf(hssfCell.getStringCellValue());
			}
		}
	}


	public static String getCell(HSSFCell cell) {
		DecimalFormat df = new DecimalFormat("#");
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			}
			return df.format(cell.getNumericCellValue());
		case HSSFCell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case HSSFCell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		case HSSFCell.CELL_TYPE_BLANK:
			return "";
		case HSSFCell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() + "";
		case HSSFCell.CELL_TYPE_ERROR:
			return cell.getErrorCellValue() + "";
		}
		return "";
	}
	public static String formateDate(HSSFWorkbook wb,HSSFCell hssfCell){
		//HSSFWorkbook wb = new HSSFWorkbook();  
		CreationHelper createHelper=wb.getCreationHelper();
		HSSFCellStyle cellStyle = wb.createCellStyle();  
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));
		//HSSFSheet sheet = wb.createSheet("format sheet");  
		//HSSFDataFormat format = wb.createDataFormat();  
		//HSSFRow row = sheet.createRow(0);  
		//HSSFCell cell = row.createCell(0);  
		//cell = row.getCell(2);
		hssfCell.setCellValue(formatCell(hssfCell));
		hssfCell.setCellStyle(cellStyle);  
		return hssfCell.getStringCellValue();
	}
	 	
}
