package com.spring.command;

import java.util.Date;

import com.spring.dto.BoardVO;

public class BoardRegistCommand {
	
	private String title;
	private String writer;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setTitle(this.title);
		board.setWriter(this.writer);
		board.setContent(this.content);
		board.setRegdate(new Date());
		
		return board;
	}
}
