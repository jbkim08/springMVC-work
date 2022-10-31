package com.demo.service;

import java.io.File;

import javax.annotation.Resource;

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
	
	//로그인할때 저장된 로그인유저객체를 자동주입
	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;
	
	@Autowired
	private BoardMapper boardMapper;
	
	//서버로 업로드 된 파일을 업로드 폴더에 저장하고 파일의 이름을 리턴하는 메소드
	private String saveUploadFile(MultipartFile upload_file) {
		//현재 시간(밀리세컨드)을 이용해서 파일의 이름이 중복되지 않게 설정
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return file_name;
	}
	
	//파일을 입력했으면 실제 서버실행되는 위치의 upload폴더에 저장하고 그 파일이름을 content_file에 저장
	public void addContentInfo(ContentBean writeContentBean) {
		// 입력받은 업로드 파일을 게시글 객체에서 가져온다
		MultipartFile upload_file = writeContentBean.getUpload_file();
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name);
		}
		// 현재 로그인 상태의 유저인덱스 번호를 입력
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		// DB에 새 게시글 정보 저장
		boardMapper.addContentInfo(writeContentBean);
	}
}
