package com.servlet.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;
import com.servlet.util.SqlMapClientUtil;

public class IMemberDaoImpl implements IMemberDao {
	
	private static IMemberDao memberDao;
	
	public IMemberDaoImpl() {
		SqlMapClientUtil.getInstance();
	}

	public static IMemberDao getInstance() {
		if(memberDao == null) {
			memberDao = new IMemberDaoImpl();
		}
		return memberDao;
	}
	
	@Override
	public MemberVO getMember(SqlMapClient smc, String memId) throws SQLException {
		return (MemberVO) smc.queryForObject("member.getMember", memId);
	}

	@Override
	public int MemIdCheck(SqlMapClient smc, String memId) throws SQLException {
		return (int) smc.queryForObject("member.MemIdCheck", memId);
	}

	@Override
	public int memberSign(SqlMapClient smc, MemberVO mv) throws SQLException {
		return (int) smc.queryForObject("member.memberSign", mv);
	}

}
