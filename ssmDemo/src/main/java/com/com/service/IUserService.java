package com.com.service;

import com.com.pojo.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IUserService {

	List<User> findUserList();

	User findUserById();

}
