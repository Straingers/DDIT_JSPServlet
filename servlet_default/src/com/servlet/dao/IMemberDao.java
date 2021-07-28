package com.servlet.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public interface IMemberDao {
	/**
	 * 유저 정보 가져오는 메서드
	 * @param smc
	 * @param mv
	 * @return MemberVO
	 * @throws SQLException
	 */
	public MemberVO getMember(SqlMapClient smc, String memId) throws SQLException;
	
	/**
	 * 유저 ID 유무확인 메서드
	 * @param smc
	 * @param memId
	 * @return 존재하지 않을때 : 0, 존재할때 : 1
	 * @throws SQLException
	 */
	public int MemIdCheck(SqlMapClient smc, String memId) throws SQLException;

	/**
	 * 유저 ID, 비밀번호 확인 메서드
	 * @param smc
	 * @param mv
	 * @return 맞지 않을때 : 0, 맞을때 : 1
	 * @throws SQLException
	 */
	public int memberSign(SqlMapClient smc, MemberVO mv) throws SQLException;
	
}
