package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	
	// 회원정보 조회
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
	
	// 회원 리스트 조회
	List<MemberVO> selectMemberList(SqlSession session) throws SQLException;
	List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws SQLException;
	List<MemberVO> selectMemberList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 검색 결과의 전체 리스트 갯수
	int selectMemberListCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 회원 추가
	public void insertMember(SqlSession session, MemberVO member) throws SQLException;
	
	// 회원 정보 수정
	public void updateMember(SqlSession session, MemberVO member) throws SQLException;
	
	// 회원 삭제
	public void deleteMember(SqlSession session, String id) throws SQLException;
	
	// 회원 정지
	public void disabledMember(SqlSession session, String id) throws SQLException;

	// 회원 활성화
	public void enabledMember(SqlSession session, String id) throws SQLException;
}
