package com.servlet.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dao.IMemberDao;
import com.servlet.dao.IMemberDaoImpl;
import com.servlet.dto.MemberVO;
import com.servlet.util.SqlMapClientUtil;

public class IMemberServiceImpl implements IMemberService {

	private IMemberDao memberDao;
	private SqlMapClient smc;
	
	private static IMemberService memberService;
	
	public IMemberServiceImpl() {
		memberDao = IMemberDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memberService == null) {
			memberService = new IMemberServiceImpl();
		}
		return memberService;
	}
	
	@Override
	public MemberVO getMember(String memId) {
		MemberVO mv = new MemberVO();
		try {
			mv = memberDao.getMember(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public int MemIdCheck(String memId) {
		int cnt = 0;
		try {
			cnt = memberDao.MemIdCheck(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int memberSign(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = memberDao.memberSign(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
