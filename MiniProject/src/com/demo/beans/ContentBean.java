package com.demo.beans;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class ContentBean {

	private int content_idx;
	
	@NotBlank(message = "제목을 입력해 주세요")
	private String content_subject;
	
	@NotBlank(message = "내용을 입력해 주세요")
	private String content_text;
	
	private MultipartFile upload_file; //실제 업로드 파일(파일객체)
	private String content_file; //이미지 파일의 이름 
	private int content_writer_idx; // 유저테이블의 user_idx 번호
	private int content_board_idx; // 보드정보테이블의 board_info_idx 번호
	private String content_date; // 작성날짜

	public int getContent_idx() {
		return content_idx;
	}

	public void setContent_idx(int content_idx) {
		this.content_idx = content_idx;
	}

	public String getContent_subject() {
		return content_subject;
	}

	public void setContent_subject(String content_subject) {
		this.content_subject = content_subject;
	}

	public String getContent_text() {
		return content_text;
	}

	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}

	public String getContent_file() {
		return content_file;
	}

	public void setContent_file(String content_file) {
		this.content_file = content_file;
	}

	public int getContent_writer_idx() {
		return content_writer_idx;
	}

	public void setContent_writer_idx(int content_writer_idx) {
		this.content_writer_idx = content_writer_idx;
	}

	public int getContent_board_idx() {
		return content_board_idx;
	}

	public void setContent_board_idx(int content_board_idx) {
		this.content_board_idx = content_board_idx;
	}

	public String getContent_date() {
		return content_date;
	}

	public void setContent_date(String content_date) {
		this.content_date = content_date;
	}

	public MultipartFile getUpload_file() {
		return upload_file;
	}

	public void setUpload_file(MultipartFile upload_file) {
		this.upload_file = upload_file;
	}

}
