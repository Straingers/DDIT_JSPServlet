package com.servlet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.servlet.dao.MyMemberDAO;
import com.servlet.dto.MemberVO;

public class MockMyMemberDAO implements MyMemberDAO {

	@Override
	public List<MemberVO> selectAllMember(SqlSession session) throws SQLException {
		List<MemberVO> memberList = null;
		if(session == null) throw new SQLException();
		
		MemberVO member = new MemberVO();
		member.setMemName("테스트");
		
		memberList = new ArrayList<MemberVO>();
		memberList.add(member);
		
		return memberList;
	}

	@Override
	public MemberVO selectMemberById(SqlSession session, String memId) throws SQLException {
		MemberVO member = null;
		
		if(session == null) throw new SQLException();
		
		if(memId.equals("test01")) {
			member = new MemberVO();
			member.setMemName("테스트");
		}
		return member;
	}

	@Override
	public int createMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		if(session == null) throw new SQLException();
		if(mv.getMemId().equals("test")) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		if(session == null) throw new SQLException();
		if(mv.getMemId().equals("test")) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		int cnt = 0;
		if(session == null) throw new SQLException();
		if(memId.equals("test")) {
			cnt = 1;
		}
		return cnt;
	}

}
