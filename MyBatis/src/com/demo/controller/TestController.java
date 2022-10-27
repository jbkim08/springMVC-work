package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.beans.DataBean;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data() {
		return "input_data"; //데이터 입력 jsp 페이지
	}
	
	@PostMapping("/input_pro")
	public String input_pro(DataBean dataBean) {
		return "input_pro";
	}
}
