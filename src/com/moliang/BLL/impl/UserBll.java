package com.moliang.BLL.impl;


import com.moliang.BLL.IUserBll;
import com.moliang.DAL.IUserDao;
import com.moliang.DAL.impl.UserDao;
import com.moliang.Model.User;

public class UserBll implements IUserBll {

	User user = null;
	IUserDao userDao = new UserDao();
	@Override
	public User LoginByName(String nickName, String passWord) {
		return userDao.findByNameAndPwd(nickName, passWord);
	}

	@Override
	public User LoginByEmail(String email, String passWord) {
		return userDao.findByEmailAndPwd(email, passWord);
	}

	@Override
	public boolean AddUser(User user) {
		if(userDao.AddUser(user)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean UpdateUser(User user) {
		if(userDao.UpdateUser(user)==1){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean existByName(String nickName) {
		return userDao.findByName(nickName);
	}

	@Override
	public boolean existByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
