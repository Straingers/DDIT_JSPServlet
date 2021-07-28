package com.spring.service;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberService {
	
	
	// 회원 정보 조회
	MemberVO getMember(String id) throws SQLException;
	
	// 회원등록
	public void regist(MemberVO member) throws SQLException;
	
	// 회원 정보 수정
	void modify(MemberVO member) throws SQLException;
	
	// 회원 삭제
	void remove(String id) throws SQLException;
	
	// 회원 정지
	void disabled(String id) throws SQLException;
	
	// 회원 활성화
	void enabled(String id) throws SQLException;
}

