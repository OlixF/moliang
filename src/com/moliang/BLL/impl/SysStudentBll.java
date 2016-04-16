package com.moliang.BLL.impl;

import java.sql.ResultSet;

import com.moliang.BLL.ISysStudentBll;
import com.moliang.DAL.ISysStudentDal;
import com.moliang.DAL.impl.SysStudentDal;
import com.moliang.Model.SysPageBean;
import com.moliang.Model.SysStudent;

public class SysStudentBll implements ISysStudentBll {

	ISysStudentDal studentDal = new SysStudentDal();
	@Override
	public ResultSet getList(String str, SysPageBean pageBean) {
		return studentDal.getList(str, pageBean);
	}

	@Override
	public int getCount(String str) {
		return studentDal.getCount(str);
	}

	@Override
	public boolean studentAdd(SysStudent student) {
		if(studentDal.studentAdd(student)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean studentUpdate(SysStudent student) {
		if(studentDal.studentUpdate(student)==1){
			return true;
		}
		return false;
	}

	@Override
	public int studentDelete(String delIds) {
		return studentDal.studentDelete(delIds);
	}

	@Override
	public boolean studentImport(SysStudent student) {
		if(studentDal.exist(student.getStudent_NO())){
			return studentUpdate(student);
		}else{
			return studentAdd(student);
		}
	}

	@Override
	public ResultSet studentExport(String ids) {
		return studentDal.studentExport(ids);
	}

	@Override
	public boolean exist(SysStudent student) {
		return studentDal.exist(student.getStudent_NO());
	}
}
