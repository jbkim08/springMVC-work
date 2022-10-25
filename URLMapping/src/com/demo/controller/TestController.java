package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1_get() {
		return "test1";
	}
	
	@PostMapping("/test1")
	public String test1_post() {
		return "post1";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
	
	@PostMapping("/test2")
	public String test2_post() {
		return "post2";
	}
	
	@RequestMapping(value = "/test5", method = {RequestMethod.GET, RequestMethod.POST})
	public String test5() {
		return "test5";
	}
}








