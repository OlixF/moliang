package com.moliang.BLL;

import java.sql.ResultSet;

import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysStudent;

public interface ISysStudentBll {

	ResultSet getList(String str, SysPageBean pageBean);

	int getCount(String str);

	boolean studentAdd(SysStudent student);

	boolean studentUpdate(SysStudent student);

	int studentDelete(String delIds);

	boolean studentImport(SysStudent student);

	ResultSet studentExport(String ids);

	boolean exist(SysStudent student);

}
