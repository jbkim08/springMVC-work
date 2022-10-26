package com.demo.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//요청할때 마다 새로운 객체로 생성되는 bean2 객체 등록
@Component("bean2")
@RequestScope
public class DataBean2 {

	private String data1;
	private String data2;
	
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	
}
