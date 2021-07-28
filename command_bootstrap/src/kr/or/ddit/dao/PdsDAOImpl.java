package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.PdsVO;

public class PdsDAOImpl implements PdsDAO {

	@Override
	public List<PdsVO> selectSearchPdsList(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("Pds-Mapper.selectSearchPdsList", cri, rowBounds);
	}

	@Override
	public int selectSearchPdsListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		return session.selectOne("Pds-Mapper.selectSearchPdsListCount", cri);
	}

	@Override
	public PdsVO selectPdsByPno(SqlSession session, int pno) throws SQLException {
		return session.selectOne("Pds-Mapper.selectPdsByPno", pno);
	}

	@Override
	public void increaseViewCount(SqlSession session, int pno) throws SQLException {
		session.update("Pds-Mapper.increaseViewCount", pno);
	}

	@Override
	public int selectPdsSequenceNextValue(SqlSession session) throws SQLException {
		return session.selectOne("Pds-Mapper.selectPdsSequenceNextValue");
	}

	@Override
	public void insertPds(SqlSession session, PdsVO pds) throws SQLException {
		session.update("Pds-Mapper.insertPds", pds);
	}

	@Override
	public void updatePds(SqlSession session, PdsVO pds) throws SQLException {
		session.update("Pds-Mapper.updatePds", pds);
	}

	@Override
	public void deletePds(SqlSession session, int pno) throws SQLException {
		session.update("Pds-Mapper.deletePds", pno);
	}

}
