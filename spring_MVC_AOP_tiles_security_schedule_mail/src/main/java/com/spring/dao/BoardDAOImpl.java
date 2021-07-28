package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session =  session;
	}
	
	@Override
	public List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("Board-Mapper.selectSearchBoardList", cri, rowBounds);
	}

	@Override
	public int selectSearchBoardListCount(SearchCriteria cri) throws SQLException {
		return session.selectOne("Board-Mapper.selectSearchBoardListCount", cri);
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		return session.selectOne("Board-Mapper.selectBoardByBno", bno);
	}

	@Override
	public void increaseViewCount(int bno) throws SQLException {
		session.update("Board-Mapper.increaseViewCount", bno);
	}

	@Override
	public int selectBoardSequenceNextValue() throws SQLException {
		return session.selectOne("Board-Mapper.selectBoardSequenceNextValue");
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		session.update("Board-Mapper.insertBoard", board);
		
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		session.update("Board-Mapper.updateBoard", board);
		
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		session.update("Board-Mapper.deleteBoard", bno);
	}

	@Override
	public BoardVO selectBarodByFileName(String fileName) throws SQLException {
		BoardVO board = session.selectOne("Board-Mapper.selectBoardByFileName", fileName);
		return board;
	}

}
