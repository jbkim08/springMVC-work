package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.demo.beans.DataBean;

public interface MapperInterface {
	//sql 쿼리문 작성
	@Insert("insert into spring_mvc_table values(#{data1},#{data2},#{data3})")
	void insert_data(DataBean dataBean);
	
	@Select("select data1, data2, data3 from spring_mvc_table")
	List<DataBean> select_data();
	
}
