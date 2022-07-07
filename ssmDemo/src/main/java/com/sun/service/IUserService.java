package com.sun.service;

import com.sun.pojo.User;

import java.util.List;

public interface IUserService {

	List<User> findUserList();

	User findUserById();

}
