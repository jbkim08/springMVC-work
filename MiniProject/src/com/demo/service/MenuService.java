package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.BoardInfoBean;
import com.demo.mapper.MenuMapper;

@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper; //마이바티스의 메뉴매퍼 객체가 주입됨
	
	public List<BoardInfoBean> getMenuList(){
		List<BoardInfoBean> menuList = menuMapper.getMenuList();
		return menuList;
	}
}
