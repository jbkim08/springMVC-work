package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.beans.DataBean;
import com.demo.mapper.MapperInterface;

@Controller
public class TestController {
	
	//마이바티스에서 생성된 매퍼 객체를 자동주입
	@Autowired
	MapperInterface mapper1;

	@GetMapping("/input_data")
	public String input_data() {
		return "input_data"; //데이터 입력 jsp 페이지
	}
	
	@PostMapping("/input_pro")
	public String input_pro(DataBean dataBean) {
		//DB에 저장한다
		mapper1.insert_data(dataBean);
		return "input_pro";
	}
	
	@GetMapping("/read_data")
	public String read_data(Model model) {
		List<DataBean> list = mapper1.select_data();
		model.addAttribute("list", list); 
		return "read_data"; 
	}
	
}
