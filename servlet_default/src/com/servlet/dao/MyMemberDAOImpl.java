package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.servlet.dto.MemberVO;

public class MyMemberDAOImpl implements MyMemberDAO {

	@Override
	public List<MemberVO> selectAllMember(SqlSession session) throws SQLException {
		return session.selectList("Member-Mapper.selectAllMember");
	}

	@Override
	public MemberVO selectMemberById(SqlSession session, String memId) throws SQLException {
		return session.selectOne("Member-Mapper.selectMemberById", memId);
	}

	@Override
	public int createMember(SqlSession session, MemberVO mv) throws SQLException {
		return session.update("Member-Mapper.memberInsert", mv);
	}

	@Override
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
		return session.update("Member-Mapper.memberUpdate", mv);
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		return session.delete("Member-Mapper.memberDelete", memId);
	}

}
