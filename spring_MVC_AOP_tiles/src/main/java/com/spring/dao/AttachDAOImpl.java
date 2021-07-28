package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.AttachVO;

public class AttachDAOImpl implements AttachDAO {

	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session =  session;
	}
	
	@Override
	public List<AttachVO> selectAttachByPno(int pno) throws SQLException {
		return session.selectList("Attach-Mapper.selectAttachByPno", pno);
	}

	@Override
	public AttachVO selectAttachByAno(int ano) throws SQLException {
		return session.selectOne("Attach-Mapper.selectAttachByAno", ano);
	}

	@Override
	public void insertAttach(AttachVO attach) throws SQLException {
		session.update("Attach-Mapper.insertAttach", attach);
	}

	@Override
	public void deleteAttach(int ano) throws SQLException {
		session.update("Attach-Mapper.deleteAttach", ano);
	}

	@Override
	public void deleteAllAttach(int pno) throws SQLException {
		session.update("Attach-Mapper.deleteAllAttach", pno);
	}

}
