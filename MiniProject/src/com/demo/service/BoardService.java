package com.demo.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.beans.ContentBean;
import com.demo.beans.LoginUserBean;
import com.demo.mapper.BoardMapper;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;

	// 로그인할때 저장된 로그인유저객체를 자동주입
	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;

	@Autowired
	private BoardMapper boardMapper;
	
	@Value("${page.listcnt}")
	private int page_listcnt;
	
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;

	// 서버로 업로드 된 파일을 업로드 폴더에 저장하고 파일의 이름을 리턴하는 메소드
	private String saveUploadFile(MultipartFile upload_file) {
		// 현재 시간(밀리세컨드)을 이용해서 파일의 이름이 중복되지 않게 설정
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();

		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file_name;
	}

	// 파일을 입력했으면 실제 서버실행되는 위치의 upload폴더에 저장하고 그 파일이름을 content_file에 저장
	public void addContentInfo(ContentBean writeContentBean) {
		// 입력받은 업로드 파일을 게시글 객체에서 가져온다
		MultipartFile upload_file = writeContentBean.getUpload_file();
		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name);
		}
		// 현재 로그인 상태의 유저인덱스 번호를 입력
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		// DB에 새 게시글 정보 저장
		boardMapper.addContentInfo(writeContentBean);
	}

	public String getBoardInfoName(int board_info_idx) {
		return boardMapper.getBoardInfoName(board_info_idx);
	}

	// 게시판별로 해당하는 게시글들을 불러오기, 페이징 추가
	public List<ContentBean> getContentList(int board_info_idx, int page) {
		//시작인덱스번호 = (페이지 - 1) * 10(페이지당게시물갯수)
		int start = (page - 1) * page_listcnt;
		//마이바티스의 RowBounds 클래스를 사용해서 시작글 번호, 가져올 갯수
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		//매퍼에서 처리하도록 rowBounds 객체를 매개변수로 추가
		return boardMapper.getContentList(board_info_idx, rowBounds);
	}

	// 한개의 게시글의 정보들을 가져오기
	public ContentBean getContentInfo(int content_idx) {
		return boardMapper.getContentInfo(content_idx);
	}
	
	//글 인덱스 번호로 검색해서 글 정보를 modifyContentBean 입력한다.
	public void getContents(ContentBean modifyContentBean) {
		ContentBean temp = boardMapper.getContentInfo(modifyContentBean.getContent_idx());
		
		modifyContentBean.setContent_writer_name(temp.getContent_writer_name());
		modifyContentBean.setContent_date(temp.getContent_date());
		modifyContentBean.setContent_subject(temp.getContent_subject());
		modifyContentBean.setContent_text(temp.getContent_text());
		modifyContentBean.setContent_file(temp.getContent_file());		
	}
	
	public void modifyContentInfo(ContentBean modifyContentBean) {
		//업로드 파일이 있을경우에 이름(content_file)을 입력한다.
		MultipartFile upload_file = modifyContentBean.getUpload_file();
		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file); //파일을 업로드 폴더에 저장
			modifyContentBean.setContent_file(file_name); //파일의 이름을 저장
		}
		boardMapper.modifyContentInfo(modifyContentBean);
	}
	
	public void deleteContentInfo(int content_idx) {
		boardMapper.deleteContentInfo(content_idx);
	}

}




