package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.demo.beans.DataBean1;

//프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
	//requestCope는 요청시 새로운 객체를 생성
	@Bean
	@RequestScope
	public DataBean1 bean1() {
		return new DataBean1();
	}
}
