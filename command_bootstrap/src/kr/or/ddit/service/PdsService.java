package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.dto.PdsVO;

public interface PdsService {
	
	Map<String, Object> getList(SearchCriteria cri) throws SQLException;
	
	PdsVO getPds(int pno) throws SQLException;
	
	void regist(PdsVO pds) throws SQLException;
	
	void modify(PdsVO pds) throws SQLException;
	
	void remove(int pno) throws SQLException;
	
	PdsVO read(int pno) throws SQLException;
	
	
	AttachVO getAttachByAno(int ano) throws SQLException;
	
	void removeAttachByAno(int ano) throws SQLException;
	
}
