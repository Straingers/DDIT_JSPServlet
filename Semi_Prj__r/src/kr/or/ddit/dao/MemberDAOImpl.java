package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		return member;
	}

	@Override
	public void insertMember(SqlSession session, MemberVO member) throws SQLException {
		session.update("Member-Mapper.insertMember", member);
		
	}

	@Override
	public void modifyMember(SqlSession session, MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateMember", member);
		
	}
	
	@Override
	public void updateMember(SqlSession session, MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateMember", member);
		
	}

	@Override
	public void deleteMember(SqlSession session, String id) throws SQLException {
		session.update("Member-Mapper.deleteMember", id);
		
	}

	@Override
	public void disabledMember(SqlSession session, String id) throws SQLException {
		session.update("Member-Mapper.disabledMember", id);
		
	}

	@Override
	public int checkedEnabledMember(SqlSession session, String id) throws SQLException {
		int count =  session.selectOne("Member-Mapper.checkedEnabledMember", id);
		return count;
	}

}
