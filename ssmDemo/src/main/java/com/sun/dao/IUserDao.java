package com.sun.dao;

import java.util.List;



import com.sun.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
	
	
	List<User> findUserList();

	User findUserById();
}
