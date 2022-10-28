package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;

@RestController
public class RestApiController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/check/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		
		boolean check = userService.checkUserIdExist(user_id);
		
		return check + ""; //불린+문자열 : 문자열
	}
}







