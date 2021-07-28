package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;

public interface MemberDAO {

	MemberVO selectMemberById(String memId) throws SQLException;
	
	List<MemberVO> selectAllMember() throws SQLException;
	
	int memberInsert(MemberVO mv) throws SQLException;
	
	int memberUpdate(MemberVO mv) throws SQLException;
	
	int memberDelete(String memId) throws SQLException;
}
