package com.com.dao;


import com.com.pojo.User;
import java.util.List;

public interface IUserDao {
	
	
	List<User> findUserList();

	User findUserById();
}
