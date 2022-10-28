package com.demo.beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	private int user_idx;  //유저 번호는 자동으로 증가 (시퀀스)
	
	@Size(min = 2, max = 4, message = "이름은 2~4자까지 가능합니다")
	@Pattern(regexp = "[가-힣]*", message = "한글만 입력해 주세요")
	private String user_name; //유저이름
	
	@Size(min = 4, max = 20, message = "아이디는 4~20까지 가능합니다")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "영문소문자 대문자 숫자만 입력가능")
	private String user_id;   //아이디
	
	@Size(min = 4, max = 20, message = "비밀번호는 4~20까지 가능합니다")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "영문소문자 대문자 숫자만 입력가능")
	private String user_pw;   //비번
	
	@Size(min = 4, max = 20, message = "비밀번호는 4~20까지 가능합니다")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "영문소문자 대문자 숫자만 입력가능")
	private String user_pw2;  //비번 확인용
	
	@AssertTrue(message = "아이디 중복체크 해주세요") //true일때 통과
	private boolean userIdChecked; //아이디 확인? true 체크됨
	
	public UserBean() {
		this.userIdChecked = false; //처음에는 아이디 체크안됨
	}
		
	public boolean isUserIdChecked() {
		return userIdChecked;
	}

	public void setUserIdChecked(boolean userIdChecked) {
		this.userIdChecked = userIdChecked;
	}

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

}
