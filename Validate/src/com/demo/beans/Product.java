package com.demo.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {

	@Size(min = 2, message = "상품명은 2자 이상")
	private String name; //상품명
	
	@NotBlank(message = "이메일을 입력해 주세요")
	@Email(message = "이메일 형식에 맞지 않습니다")
	private String email;
	
	@Pattern(regexp = "^[1-9][0-9]*", message = "숫자만 입력가능합니다") //숫자만 1~99999999999 까지
	private String price;	          //사용시 정수로 변환

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
