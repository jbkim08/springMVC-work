package com.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	//로그인을 위해 이미 만들어진 세션 객체를 불러온다
	@Resource(name = "loginUserBean")  
	private LoginUserBean loginUserBean;
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userMapper.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true; //이름이 없으므로 아이디 사용가능
		} else {
			return false; //똑같은 아이디 있음
		}
	}
	
	//DB에 새 유저를 저장
	public void addUserInfo(UserBean joinUserBean) {
		userMapper.addUserInfo(joinUserBean);
	}
	
	public void getLoginUserInfo(LoginUserBean loginBean) {
		
		LoginUserBean temp = userMapper.getLoginUserInfo(loginBean);
		//널이 아니면 가입이 된 상태
		if(temp != null) {
			//세션의 로그인유저빈 객체에 유저정보를 저장한다.
			loginUserBean.setUser_idx(temp.getUser_idx());
			loginUserBean.setUser_name(temp.getUser_name());
			loginUserBean.setUserLogin(true); //로그인 상태
		}
	}
}








