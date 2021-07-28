package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public interface BoardDAO {
	
	List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException;
	
	int selectSearchBoardListCount(SearchCriteria cri) throws SQLException;
	
	BoardVO selectBoardByBno(int bno) throws SQLException;
	
	BoardVO selectBarodByFileName(String fileName) throws SQLException;
	
	void increaseViewCount(int bno) throws SQLException;
	
	int selectBoardSequenceNextValue() throws SQLException;
	
	void insertBoard(BoardVO board) throws SQLException;
	
	void updateBoard(BoardVO board) throws SQLException;
	
	void deleteBoard(int bno) throws SQLException;
	
}
