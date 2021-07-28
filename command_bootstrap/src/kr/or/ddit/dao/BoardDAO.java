package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;

public interface BoardDAO {
	
	List<BoardVO> selectSearchBoardList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	int selectSearchBoardListCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	BoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException;
	
	void increaseViewCount(SqlSession session, int bno) throws SQLException;
	
	int selectBoardSequenceNextValue(SqlSession session) throws SQLException;
	
	void insertBoard(SqlSession session, BoardVO board) throws SQLException;
	
	void updateBoard(SqlSession session, BoardVO board) throws SQLException;
	
	void deleteBoard(SqlSession session, int bno) throws SQLException;
	
}
