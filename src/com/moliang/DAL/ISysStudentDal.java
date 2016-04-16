package com.moliang.DAL;

import java.sql.ResultSet;

import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysStudent;

public interface ISysStudentDal {

	ResultSet getList(String str, SysPageBean pageBean);

	int getCount(String str);
	
	int studentAdd(SysStudent student);

	int studentUpdate(SysStudent student);

	int studentDelete(String delIds);

	boolean exist(String student_NO);

	ResultSet studentExport(String ids);

}
