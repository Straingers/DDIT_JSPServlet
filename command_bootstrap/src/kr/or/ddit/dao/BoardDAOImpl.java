package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<BoardVO> selectSearchBoardList(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("Board-Mapper.selectSearchBoardList", cri, rowBounds);
	}

	@Override
	public int selectSearchBoardListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		return session.selectOne("Board-Mapper.selectSearchBoardListCount", cri);
	}

	@Override
	public BoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException {
		return session.selectOne("Board-Mapper.selectBoardByBno", bno);
	}

	@Override
	public void increaseViewCount(SqlSession session, int bno) throws SQLException {
		session.update("Board-Mapper.increaseViewCount", bno);
	}

	@Override
	public int selectBoardSequenceNextValue(SqlSession session) throws SQLException {
		return session.selectOne("Board-Mapper.selectBoardSequenceNextValue");
	}

	@Override
	public void insertBoard(SqlSession session, BoardVO board) throws SQLException {
		session.update("Board-Mapper.insertBoard", board);
		
	}

	@Override
	public void updateBoard(SqlSession session, BoardVO board) throws SQLException {
		session.update("Board-Mapper.updateBoard", board);
		
	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		session.update("Board-Mapper.deleteBoard", bno);
	}

}
