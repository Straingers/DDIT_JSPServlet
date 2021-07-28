package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.NotFoundMemberException;
import kr.or.ddit.exception.NullMemIDException;
import kr.or.ddit.exception.NullMemNameException;
import kr.or.ddit.exception.NullMemPwException;
import kr.or.ddit.exception.NullMemTelException;
import kr.or.ddit.exception.OverLapIDException;


public interface MemberService {

	List<MemberVO> getAllMember() throws NotFoundMemberException, SQLException;
	Map<String, Object> getAllMember(SearchCriteria cri) throws NotFoundMemberException, SQLException;
	
	MemberVO getMember(String id) throws SQLException;
	
	int memberInsert(MemberVO mv) throws NullMemIDException, OverLapIDException, NullMemPwException
								, NullMemNameException, NullMemTelException, SQLException;

	int memberUpdate(MemberVO mv) throws NullMemPwException
								,  NullMemTelException, SQLException;
	
	int memberDelete(String id) throws SQLException;
	
}
