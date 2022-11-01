package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.beans.ContentBean;
import com.demo.beans.LoginUserBean;
import com.demo.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor {

	//현재 로그인정보와 게시글의 글쓴이를 비교
	private LoginUserBean loginUserBean;
	private BoardService boardService;
	
	public CheckWriterInterceptor(LoginUserBean loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String str1 = request.getParameter("content_idx"); //글번호
		int content_idx = Integer.parseInt(str1); //글번호를 숫자로 변환
		//글번호로 DB에서 게시글 정보를 가져옴
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		//글쓴이 번호와 로그인유저 번호와 같지 않으면
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/not_writer");
			return false; //요청주소는 가지않음
		}
		return true; //요청 주소로 이동
	}
	
	
}
