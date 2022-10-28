package com.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;

public interface UserMapper {
	//user_id로 검색해서 유저가 있으면 유저이름이 리턴 (만약 없으면 null)
	@Select("select user_name from user_table "
			+ "where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	//새 유저 저장하기 (유저인덱스번호는 시퀀스로 자동생성됨)
	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) " + 
			"values(user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	//id pw로 유저가 가입된 상태인지 확인 (null이 아니면 가입된 상태)
	@Select("select user_idx, user_name from user_table "
			+ "where user_id=#{user_id} and user_pw=#{user_pw}")
	LoginUserBean getLoginUserInfo(LoginUserBean loginBean);
}




