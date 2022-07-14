package com.sun.controller;

import com.sun.Interceptor.TokenHandler;
import com.sun.pojo.User;
import com.sun.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/third-party")
@Slf4j
public class UserController {

	@Autowired
	private IUserService userService;
	private  final Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("/findUserList")
	@ResponseBody
	public Map<String, Object> findUserList(){
		Map<String,Object> map = new HashMap<String,Object>();
		List<User>  user   = userService.findUserList();
		map.put("user", user);
		return map;
	}
	@RequestMapping("/findUserById")
	@ResponseBody
	public Map<String, Object> findUserById(){
		Map<String,Object> map = new HashMap<String,Object>();
		 User  user   = userService.findUserById();
		map.put("user", user);
		return map;
	}

	@RequestMapping("/mock")
	@ResponseBody
	public String  index(){
		logger.info("callback integration");
		return "4132";
	}
}
