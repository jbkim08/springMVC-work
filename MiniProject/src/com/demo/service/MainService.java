package com.demo.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.ContentBean;
import com.demo.mapper.BoardMapper;

@Service
public class MainService {

	@Autowired
	private BoardMapper boardMapper;
	
	public List<ContentBean> getMainList(int board_info_idx){		
		// 시작 0번째 부터 5개의 게시글을 가져오기
		RowBounds rowBounds = new RowBounds(0, 5);
		return boardMapper.getContentList(board_info_idx, rowBounds);
	}
}







