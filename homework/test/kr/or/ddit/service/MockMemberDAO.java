package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dto.MemberVO;

public class MockMemberDAO implements MemberDAO {

	@Override
	public List<MemberVO> selectAllMember(SqlSession session) throws SQLException {
		List<MemberVO> memberList = null;
		if(session == null) throw new SQLException();
		
		MemberVO member = new MemberVO();
		member.setName("테스트");
		
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
			member.setName("테스트");
		}
		return member;
	}

	@Override
	public int createMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		if(session == null) throw new SQLException();
		if(mv.getId().equals("test")) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		if(session == null) throw new SQLException();
		if(mv.getId().equals("test")) {
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

	@Override
	public int overlapMemberIdCheck(SqlSession session, String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAllMember(SqlSession session, SearchCriteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectAllMemberCount(SqlSession session, SearchCriteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
