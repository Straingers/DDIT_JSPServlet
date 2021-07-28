package com.servlet.service;

import java.io.IOException;
import java.sql.SQLException;

import com.servlet.dto.MemberVO;

public interface IMemberService {
	/**
	 * 유저 정보 가져오는 메서드
	 * @param smc
	 * @param mv
	 * @return MemberVO
	 * @throws SQLException
	 */
	public MemberVO getMember(String memId);
	
	/**
	 * 유저 ID 유무 확인 메서드
	 * @param smc
	 * @param memId
	 * @return 존재하지 않을때 : 0, 존재할때 : 1
	 * @throws SQLException
	 */
	public int MemIdCheck(String memId);

	/**
	 * 유저 ID, 비밀번호 확인 메서드
	 * @param smc
	 * @param mv
	 * @return 맞지 않을때 : 0, 맞을때 : 1
	 * @throws SQLException
	 */
	public int memberSign(MemberVO mv);
}
