package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.AttachVO;

public class AttachDAOImpl implements AttachDAO {

	@Override
	public List<AttachVO> selectAttachByPno(SqlSession session, int pno) throws SQLException {
		return session.selectList("Attach-Mapper.selectAttachByPno", pno);
	}

	@Override
	public AttachVO selectAttachByAno(SqlSession session, int ano) throws SQLException {
		return session.selectOne("Attach-Mapper.selectAttachByAno", ano);
	}

	@Override
	public void insertAttach(SqlSession session, AttachVO attach) throws SQLException {
		session.update("Attach-Mapper.insertAttach", attach);
	}

	@Override
	public void deleteAttach(SqlSession session, int ano) throws SQLException {
		session.update("Attach-Mapper.deleteAttach", ano);
	}

	@Override
	public void deleteAllAttach(SqlSession session, int pno) throws SQLException {
		session.update("Attach-Mapper.deleteAllAttach", pno);
	}

}
