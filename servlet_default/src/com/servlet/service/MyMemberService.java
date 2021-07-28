package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;
import com.servlet.exception.NotFoundMemberException;
import com.servlet.exception.NullMemIDException;
import com.servlet.exception.NullMemNameException;
import com.servlet.exception.NullMemPwException;
import com.servlet.exception.NullMemTelException;

public interface MyMemberService {

	List<MemberVO> getAllMember() throws NotFoundMemberException, SQLException;
	
	MemberVO getMember(String memId) throws SQLException;
	
	int memberInsert(MemberVO mv) throws NullMemIDException, NullMemPwException
								, NullMemNameException, NullMemTelException, SQLException;

	int memberUpdate(MemberVO mv) throws NullMemPwException
								,  NullMemTelException, SQLException;
	
	int memberDelete(String memId) throws SQLException;
	
}
