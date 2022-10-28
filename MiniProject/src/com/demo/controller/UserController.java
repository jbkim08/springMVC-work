package com.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//세션에 저장된 로그인유저객체를 가져온다
	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;


	@GetMapping("/login")
	public String login(@ModelAttribute("loginBean") LoginUserBean loginBean, Model model,
						@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
		model.addAttribute("fail", fail);
		return "user/login";
	}
	
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("loginBean") LoginUserBean loginBean,
							BindingResult result) {
		if(result.hasErrors()) {
			return "user/login";
		}
		//DB에서 유저가 있는지 검사하여 있을시 로그인유저객체에 저장
		userService.getLoginUserInfo(loginBean);
		
		if(loginUserBean.isUserLogin() == true) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean,
							BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "user/join"; //유효성검사 실패시 에러메세지와 함께 다시 조인페이지로 돌아감
		}
		if(!joinUserBean.getUser_pw().equals(joinUserBean.getUser_pw2())) {
			model.addAttribute("msg", "비밀번호가 같지 않습니다!");
			return "user/join";
		}
		//DB에 유저 정보를 저장하기
		userService.addUserInfo(joinUserBean);
		
		return "user/join_success"; //가입성공
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
}
