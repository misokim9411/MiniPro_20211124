package kr.co.softsoldesk.beans;

import javax.validation.constraints.NotBlank;

public class ContentBean {

	
	private int content_idx;//게시글번호
	
	@NotBlank
	private String content_subject;
	
	@NotBlank
	private String content_text;
	
	public String getContent_text() {
		return content_text;
	}

	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}

	private String content_file;
	
	private int content_write_idx;//글쓴 사람
	
	private int content_board_idx;//글쓴 게시판 번호
	
	private String content_date;
	

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

	

	public String getContent_file() {
		return content_file;
	}

	public void setContent_file(String content_file) {
		this.content_file = content_file;
	}

	public int getContent_write_idx() {
		return content_write_idx;
	}

	public void setContent_write_idx(int content_write_idx) {
		this.content_write_idx = content_write_idx;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
