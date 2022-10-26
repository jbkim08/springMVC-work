package com.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.beans.DataBean1;
import com.demo.beans.DataBean2;

@Controller
public class TestController {
	
	@Autowired
	DataBean1 bean1; //타입에 맞는 객체가 자동 주입
	
	@Resource(name = "bean2") //이름과 타입이 맞는 객체가 자동 주입
	DataBean2 bean2;
	
	@GetMapping("/test3")
	public String test3() {
		bean1.setData1("문자열1");
		bean1.setData2("문자열2");
		bean2.setData1("문자열3");
		bean2.setData2("문자열4");
				
		return "forward:/beanResult";
	}
	
	@GetMapping("/beanResult")
	public String result1(Model model) {
		
		System.out.printf("requestBean1.data1 : %s\n", bean1.getData1());
		System.out.printf("requestBean1.data2 : %s\n", bean1.getData2());
		
		System.out.printf("requestBean2.data3 : %s\n", bean2.getData1());
		System.out.printf("requestBean2.data4 : %s\n", bean2.getData2());
		
		
		model.addAttribute("bean1", bean1);
		model.addAttribute("bean2", bean2);
		
		return "beanResult";
	} 
	
	

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		request.setAttribute("data1", "문자열1");
		return "forward:/result1"; // 겟 /result요청
	}
	@GetMapping("/result1")
	public String result(HttpServletRequest request) {
		
		String data1 = (String)request.getAttribute("data1");
		System.out.printf("data1 : %s\n", data1);

		return "result1"; // result1.jsp
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("data2", "문자열2");
		return "forward:/result2"; // 겟 /result요청
	}
	@GetMapping("/result2")
	public String result2(HttpServletRequest request) {
		
		String data2 = (String)request.getAttribute("data2");
		System.out.printf("data2 : %s\n", data2);

		return "result2"; // result1.jsp
	}
	
}
