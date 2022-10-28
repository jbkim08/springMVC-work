package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.beans.LoginUserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{

	private LoginUserBean loginUserBean;
	
	public CheckLoginInterceptor(LoginUserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	 @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 // 현재 로그인 상태가 아니라면 user/not_login으로 요청하고 원래의 요청은 생략
		 if(loginUserBean.isUserLogin() == false) {
			 String contextPath = request.getContextPath();
			 response.sendRedirect(contextPath + "/user/not_login");
			 return false;
		 }
		 
		 return true; //원래 요청으로 
	}
}





