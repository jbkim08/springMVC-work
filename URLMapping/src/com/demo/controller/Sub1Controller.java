package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sub1")
public class Sub1Controller {

	@GetMapping("/test3")
	public String sub1test3() {
		 return "sub1/test3";
	}
	
	@GetMapping("/test4")
	public String sub1test4() {
		 return "sub1/test4";
	}
}
