package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dao.MemberDAO;
import com.servlet.dao.MemberDAOImpl;
import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.exception.NotFoundMemberException;
import com.servlet.exception.NullMemIDException;
import com.servlet.exception.NullMemNameException;
import com.servlet.exception.NullMemPwException;
import com.servlet.exception.NullMemTelException;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDao = MemberDAOImpl.getInstance();
	private static MemberService memberService;
	
	public static MemberService getInstance() {
		if(memberService == null) {
			memberService = new MemberServiceImpl();
		}
		return memberService;
	}
	
	@Override
	public MemberVO login(String memId, String memPw)
			throws NotFoundIDException, InvalidPasswordException, SQLException {
		MemberVO mv = null;
		try {
			mv = memberDao.selectMemberById(memId);
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(mv != null) {
			if(memPw.equals(mv.getMemPw())) {
				return mv;
			} else {
				throw new InvalidPasswordException();
			}
		} else {
			throw new NotFoundIDException();
		}
	}

	@Override
	public List<MemberVO> getAllMember() throws NotFoundMemberException ,SQLException {
		List<MemberVO> memberList = null;
		try {
			memberList = memberDao.selectAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("SQL 오류");
		}
		if(memberList.size() != 0) {
			return memberList;
		} else {
			throw new NotFoundMemberException();
		}
	}

	@Override
	public int memberInsert(MemberVO mv) throws NullMemIDException, NullMemPwException
									, NullMemNameException, NullMemTelException, SQLException {
		int cnt = 0;
		if(mv.getMemId().equals("")) {
			throw new NullMemIDException();
		} else if(mv.getMemPw().equals("")) {
			throw new NullMemPwException();
		} else if(mv.getMemName().equals("")) {
			throw new NullMemNameException();
		} else if(mv.getMemTel().equals("")) {
			throw new NullMemTelException();
		} else {
			try {
				cnt = memberDao.memberInsert(mv);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException("SQL 오류");
			}
			return cnt;
		}
	}

	@Override
	public int memberUpdate(MemberVO mv) throws NullMemPwException
								,  NullMemTelException, SQLException {
		int cnt = 0;
		if(mv.getMemPw().equals("")) {
			throw new NullMemPwException();
		} else if(mv.getMemTel().equals("")) {
			throw new NullMemTelException();
		} else {
			try {
				cnt = memberDao.memberUpdate(mv);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException("SQL 오류");
			}
			return cnt;
		}
	}

	@Override
	public int memberDelete(String memId) throws SQLException {
		int cnt = 0;
		try {
			cnt = memberDao.memberDelete(memId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("SQL 오류");
		}
		return cnt;
	}

	@Override
	public MemberVO getMember(String memId) {
		MemberVO mv = new MemberVO();
		try {
			mv = memberDao.selectMemberById(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
