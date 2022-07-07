package com.sun.controller;

import com.sun.pojo.User;
import com.sun.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
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

	@RequestMapping("/getAllMends")
	@ResponseBody
	public String  index(){
		return "4132";
	}
}
