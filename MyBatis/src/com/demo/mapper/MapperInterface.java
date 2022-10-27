package com.demo.mapper;

import org.apache.ibatis.annotations.Insert;

import com.demo.beans.DataBean;

public interface MapperInterface {
	//sql 쿼리문 작성
	@Insert("insert into spring_mvc_table values(#{data1},#{data2},#{data3})")
	void insert_data(DataBean dataBean);
}
