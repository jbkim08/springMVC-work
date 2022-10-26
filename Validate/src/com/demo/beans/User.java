package com.demo.beans;

import javax.validation.constraints.Size;

public class User {

	@Size(min = 4, max = 6, message = "아이디는 4~6까지 적어주세요")
	private String id;
	
	@Size(min = 4, max = 6, message = "비밀번호는 4~6까지 적어주세요")
	private String pass;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
