package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;

public interface MemberService {
	
	// 로그인
	void login(String id, String pwd) throws SQLException, NotFoundIDException, 
															InvalidPasswordException;
	
	// 회원정보조회
	MemberVO getMember(String id) throws SQLException;
		
	//회원등록
	public void regist(MemberVO member) throws SQLException;
	
	//회원정보 수정
	public void modify(MemberVO member) throws SQLException;
	
	//회원삭제
	public void delete(String id) throws SQLException;
	
	//회원정지
	public void disabled(String id) throws SQLException;

}









