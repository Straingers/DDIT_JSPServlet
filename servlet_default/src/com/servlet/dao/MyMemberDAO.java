package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.servlet.dto.MemberVO;

public interface MyMemberDAO {
	
	List<MemberVO> selectAllMember(SqlSession session) throws SQLException;
	
	MemberVO selectMemberById(SqlSession session, String memId) throws SQLException;
	
	int createMember(SqlSession session, MemberVO mv) throws SQLException;
	
	int updateMember(SqlSession session, MemberVO mv) throws SQLException;
	
	int deleteMember(SqlSession session, String memId) throws SQLException;
	
}
