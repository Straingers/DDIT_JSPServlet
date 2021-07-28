package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;
import com.servlet.util.SqlMapClientUtil;

public class MemberDAOImpl implements MemberDAO {
	
	private static MemberDAO memberDao;
	
	private SqlMapClient smc = SqlMapClientUtil.getInstance();
	
	public static MemberDAO getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDAOImpl();
		}
		return memberDao;
	}
	
	@Override
	public MemberVO selectMemberById(String memId) throws SQLException {
		return (MemberVO) smc.queryForObject("member.selectMemberById", memId);
	}

	@Override
	public List<MemberVO> selectAllMember() throws SQLException {
		return smc.queryForList("member.selectAllMember");
	}

	@Override
	public int memberInsert(MemberVO mv) throws SQLException {
		return smc.update("member.memberInsert", mv);
	}

	@Override
	public int memberUpdate(MemberVO mv) throws SQLException {
		return smc.update("member.memberUpdate", mv);
	}

	@Override
	public int memberDelete(String memId) throws SQLException {
		return smc.delete("member.memberDelete", memId);
	}

}