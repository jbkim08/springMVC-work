package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.demo.beans.ContentBean;

public interface BoardMapper {
	
	@Insert("insert into content_table(content_idx, content_subject, content_text, " +
			"content_file, content_writer_idx, content_board_idx, content_date) " +
			"values (content_seq.nextval, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);
	
	@Select("select board_info_name from board_info_table "
			+ "where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);
	
	@Select("select t1.content_idx, t1.content_subject, t2.user_name as content_writer_name, " + 
			"to_char(t1.content_date, 'YYYY-MM-DD') as content_date " + 
			"from content_table t1 " + 
			"JOIN user_table t2 " + 
			"ON t1.content_writer_idx = t2.user_idx " + 
			"and t1.content_board_idx = #{board_info_idx} order by 1 desc")
	List<ContentBean> getContentList(int board_info_idx);

	//게시글 상세 정보 가져오기 
	@Select("select t2.user_name as content_writer_name, " + 
			"to_char(t1.content_date, 'YYYY-MM-DD') as content_date," + 
			"t1.content_subject, t1.content_text, t1.content_file " + 
			"from content_table t1 join user_table t2 " + 
			"on t1.content_writer_idx = t2.user_idx " + 
			"and content_idx = #{ ? }")
	ContentBean getContentInfo(int content_idx);
}





