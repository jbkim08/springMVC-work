package com.demo.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.beans.BoardInfoBean;
import com.demo.service.MenuService;

public class MenuInterceptor implements HandlerInterceptor {

	private MenuService menuService;
	
	public MenuInterceptor(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		List<BoardInfoBean> topMenuList = menuService.getMenuList();
		request.setAttribute("topMenuList", topMenuList);
		
		return true; //원래 요청을 실행
	}
}






