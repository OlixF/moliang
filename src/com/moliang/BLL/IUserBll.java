package com.moliang.BLL;

import com.moliang.Model.User;

public interface IUserBll {
	public User LoginByName(String nickName, String passWord);
	
	public User LoginByEmail(String email, String passWord);
	
	public boolean AddUser(User user);
	
	public boolean UpdateUser(User user);
	
	public boolean existByName(String nickName);
	
	public boolean existByEmail(String email);
	
}
