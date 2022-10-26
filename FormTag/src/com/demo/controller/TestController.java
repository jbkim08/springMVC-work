package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.beans.UserDataBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(@ModelAttribute(name = "user") UserDataBean user) {
		user.setUser_name("홍길동");
		user.setUser_id("abcd");
		user.setUser_pw("1234");
		user.setUser_postcode("12345");
		user.setUser_address1("주소1번입니다");
		user.setUser_address2("주소 2번입니다");

		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(@ModelAttribute(name = "user") UserDataBean user) {
		user.setUser_name("홍길동");
		user.setUser_id("abcd");
		user.setUser_pw("1234");
		user.setUser_postcode("12345");
		user.setUser_address1("주소1번입니다");
		user.setUser_address2("주소 2번입니다");

		return "test2";
	}
}
