package com.demo.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//로그인을 하기위한 클래스
//LoginUserBean의 객체를 loginUserBean 이름으로 세션에 등록함
@Component("loginUserBean")
@SessionScope
public class LoginUserBean {

	private int user_idx;
	private String user_name;
	
	@Size(min = 4, max = 20, message = "아이디는 4~20까지 가능합니다")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "영문소문자 대문자 숫자만 입력가능")
	private String user_id;   //아이디
	
	@Size(min = 4, max = 20, message = "비밀번호는 4~20까지 가능합니다")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "영문소문자 대문자 숫자만 입력가능")
	private String user_pw;   //비번
	
	private boolean userLogin; //로그인 상태 추가
	
	public LoginUserBean() {
		this.userLogin = false; //처음 상태는 로그인 false
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

	public boolean isUserLogin() {
		return userLogin;
	}

	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}
	
	
}
