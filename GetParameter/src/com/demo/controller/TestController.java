package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		for(String s: data3) {
			System.out.println("data3 : " + s);
		}

		return "result";
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		if(data3 != null) {
			for(String s: data3) {
				System.out.println("data3 : " + s);
			}
		}

		return "result";
	}
}
