package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;


public interface MemberDAO {
	
	List<MemberVO> selectAllMember(SqlSession session) throws SQLException;
	List<MemberVO> selectAllMember(SqlSession session, SearchCriteria cri) throws SQLException;
	int selectAllMemberCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
	
	int createMember(SqlSession session, MemberVO mv) throws SQLException;
	
	int updateMember(SqlSession session, MemberVO mv) throws SQLException;
	
	int deleteMember(SqlSession session, String id) throws SQLException;
	
	int overlapMemberIdCheck(SqlSession session, String id) throws SQLException;
}
