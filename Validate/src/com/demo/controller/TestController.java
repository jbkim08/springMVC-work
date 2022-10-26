package com.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.beans.Product;
import com.demo.beans.User;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data() {
		
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_data";
		}
		
		System.out.printf("ID : %s\n", user.getId());
		System.out.printf("Pass : %s\n", user.getPass());
		
		return "input_success";
	}
	
	@GetMapping("/input_product")
	public String input_product(@ModelAttribute Product product) {
		
		return "input_product";
	}
	
	@PostMapping("/input_product_pro")
	public String input_product_pro(@Valid Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_product";
		}
		
		return "input_success";
	}
	
}





