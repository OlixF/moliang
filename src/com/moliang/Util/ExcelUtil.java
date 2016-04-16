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
		// ��ȡ����
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
	 * Excel���ݴ���
		Excel�洢���ڡ�ʱ�������ֵ���ͽ��д洢����ȡʱPOI���ж����Ƿ�����ֵ���ͣ��ٽ����ж�ת��
	1����ֵ��ʽ(CELL_TYPE_NUMERIC):
		1.1����ֵ��ʽ��getNumericCellValue() ֱ�ӻ�ȡ����
		1.2���ڸ�ʽ������yyyy-MM-dd, d/m/yyyy h:mm, HH:mm �Ȳ������ֵ����ڸ�ʽ
			1).�ж��Ƿ������ڸ�ʽ��HSSFDateUtil.isCellDateFormatted(cell)
			2).�ж������ڻ���ʱ��
				cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")
			OR:	cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("yyyy-MM-dd")
		1.3�Զ������ڸ�ʽ������yyyy��m��d��,hʱmm��,yyyy��m�µȺ����ֵ����ڸ�ʽ
			�ж�cell.getCellStyle().getDataFormat()ֵ��������ֵ��ʽ
				yyyy��m��d��----->31
				m��d��---->58
				hʱmm��--->32
	2���ַ���ʽ(CELL_TYPE_STRING):ֱ�ӻ�ȡ����
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
