package com.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(Model model) {
		
		ArrayList<String> list = null;
		list.add("문자열");
		
		int[] array1 = {10, 20, 30};
		model.addAttribute("array1", array1[10]);//없는 배열 인덱스
		return "test1";
	}
	
//	@ExceptionHandler(Exception.class)
//	public String exeption1() {
//		return "error/error";
//	}

}
