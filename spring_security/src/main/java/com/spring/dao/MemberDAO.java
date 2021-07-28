package com.spring.dao;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberDAO {
	
	// 회원정보 조회
	MemberVO selectMemberById(String id) throws SQLException;
	
	// 회원 추가
	public void insertMember(MemberVO member) throws SQLException;
	
	// 회원 정보 수정
	public void updateMember(MemberVO member) throws SQLException;
	
	// 회원 삭제
	public void deleteMember(String id) throws SQLException;
	
	// 회원 정지
	public void disabledMember(String id) throws SQLException;

	// 회원 활성화
	public void enabledMember(String id) throws SQLException;
}
