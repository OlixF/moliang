package com.moliang.DAL;

import com.moliang.Model.User;

public interface IUserDao {
	public User findByNameAndPwd(String nickName, String passWord);
	
	public User findByEmailAndPwd(String email, String passWord);
	
	public boolean findByName(String nickName);
	
	public boolean findByEmail(String email);
	
	public int AddUser(User user);
	
	public int UpdateUser(User user);
}
