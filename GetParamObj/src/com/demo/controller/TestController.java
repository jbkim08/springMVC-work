package com.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.DataBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map,
						@RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
		
		for(String str : data3) {
			System.out.println("data3 : " + str);
		}
		
		return "result";
	}
	
	@GetMapping("/test2")
	public String test2(DataBean bean1) {
		
		System.out.printf("data1 : %d\n", bean1.getData1());
		System.out.printf("data2 : %d\n", bean1.getData2());
		
		for(int number1 : bean1.getData3()) {
			System.out.printf("data3 : %d\n", number1);
		}

		return "result";
	}
	
	//기본적으로 spring MVC 에서는 forward로 view 페이지 전달됨
	@GetMapping("/test3")
	public String test3() {
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4(HttpServletRequest request) {
		request.setAttribute("data1", 100);
		request.setAttribute("data2", 200);
		return "test4";
	}
	
	//Model 객체에 전달할 데이터를 입력하면 view 페이지에 리퀘스트로 전달됨
	@GetMapping("/test5")
	public String test5(Model model) {
		model.addAttribute("data1", 300);
		model.addAttribute("data2", 400);
		return "test5";
	}
	
	@GetMapping("/test6")
	public ModelAndView test6(ModelAndView mv) {
		mv.addObject("data1", 500);
		mv.addObject("data2", 600);
		mv.setViewName("test6");
		return mv; //화면 view 이름과 데이터를 같이 전달
	}
}




