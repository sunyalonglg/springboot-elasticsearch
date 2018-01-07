package com.bootdo.model.system.controller;


import com.bootdo.model.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/sys/user")
@Controller
public class UserController  {

	@Autowired
	private UserService userService;

	@GetMapping("byId")
	@ResponseBody
	public Object findById(String id) {
		Map map =new HashMap();
		map.put("id",id);
		return userService.findById(map);
	}
}
