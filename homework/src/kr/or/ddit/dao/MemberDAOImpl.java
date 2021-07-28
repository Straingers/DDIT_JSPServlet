package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;


public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberVO> selectAllMember(SqlSession session) throws SQLException {
		return session.selectList("Member-Mapper.selectAllMember");
	}
	@Override
	public List<MemberVO> selectAllMember(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("Member-Mapper.selectAllMember", cri, rowBounds);
	}
	@Override
	public int selectAllMemberCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int cnt = 0;
		cnt = session.selectOne("Member-Mapper.selectAllMemberCount", cri);
		return cnt;
	}
	
	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		return session.selectOne("Member-Mapper.selectMemberById", id);
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
	public int deleteMember(SqlSession session, String id) throws SQLException {
		return session.delete("Member-Mapper.memberDelete", id);
	}

	@Override
	public int overlapMemberIdCheck(SqlSession session, String id) throws SQLException {
		return session.selectOne("Member-Mapper.MemIdCheck", id);
	}
	

}
