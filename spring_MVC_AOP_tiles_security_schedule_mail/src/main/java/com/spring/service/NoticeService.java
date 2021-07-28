package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;

public interface NoticeService {
	
	// 목록조회
	Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException;

	// 파일명으로 찾기
	NoticeVO findFileInContent(String fileName) throws SQLException;
	
	// 게시글 상세조회
	NoticeVO getNotice(int nno) throws SQLException;
	NoticeVO getNoticeForModify(int nno) throws SQLException;
	
	// 공지사항 등록
	void regist(NoticeVO notice) throws SQLException;
	
	// 공지사항 수정
	void modify(NoticeVO notice) throws SQLException;
	
	// 공지사항 삭제
	void remove(int nno) throws SQLException;
}
