package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;

public interface BoardService {
	
	Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException;
	
	BoardVO getBoard(int bno) throws SQLException;
	
	BoardVO getBoardForModify(int bno) throws SQLException;
	
	void regist(BoardVO board) throws SQLException;
	
	void modify(BoardVO board) throws SQLException;
	
	void remove(int bno) throws SQLException;
	
}
