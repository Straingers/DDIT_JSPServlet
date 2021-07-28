package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	
	//회원정보 조회
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;

	int checkedEnabledMember(SqlSession session, String id) throws SQLException;
	
	//회원 등록
	public void insertMember(SqlSession session, MemberVO member) throws SQLException;
	
	//회원 수정
	public void modifyMember(SqlSession session, MemberVO member) throws SQLException;
	
	//회원 정보 수정
	public void updateMember(SqlSession session, MemberVO member) throws SQLException;
	
	//회원 삭제
	public void deleteMember(SqlSession session, String id) throws SQLException;
	
	//회원정지
	public void disabledMember(SqlSession session, String id) throws SQLException;

	
}
