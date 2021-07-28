package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.servlet.dao.MyMemberDAO;
import com.servlet.dao.MyMemberDAOImpl;
import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.exception.NotFoundMemberException;
import com.servlet.exception.NullMemIDException;
import com.servlet.exception.NullMemNameException;
import com.servlet.exception.NullMemPwException;
import com.servlet.exception.NullMemTelException;
import com.servlet.mybatis.OracleMyBatisSessionFactory;

public class MyMemberServiceImpl implements MyMemberService {
	
	private MyMemberDAO memberDAO = new MyMemberDAOImpl();
	private SqlSessionFactory factory = new OracleMyBatisSessionFactory();
	
	public void setMyMemberDAO(MyMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setSqlSessionFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<MemberVO> getAllMember() throws NotFoundMemberException, SQLException {
		SqlSession session = factory.openSession();
		List<MemberVO> memberList = memberDAO.selectAllMember(session);
		session.close();
		return memberList;
	}

	@Override
	public MemberVO getMember(String memId) throws SQLException {
		SqlSession session = factory.openSession();
		MemberVO mv = memberDAO.selectMemberById(session, memId);
		session.close();
		return mv;
	}

	@Override
	public int memberInsert(MemberVO mv)
			throws NullMemIDException, NullMemPwException, NullMemNameException, NullMemTelException, SQLException {
		SqlSession session = factory.openSession();
		if("".equals(mv.getMemId())) {
			throw new NullMemIDException();
		} else if("".equals(mv.getMemPw())) {
			throw new NullMemPwException();
		} else if("".equals(mv.getMemName())) {
			throw new NullMemNameException();
		} else if("".equals(mv.getMemTel())) {
			throw new NullMemTelException();
		}
		int cnt = memberDAO.createMember(session, mv);
		session.close();
		return cnt;
	}

	@Override
	public int memberUpdate(MemberVO mv) throws NullMemPwException, NullMemTelException, SQLException {
		SqlSession session = factory.openSession();
		if("".equals(mv.getMemPw())) {
			throw new NullMemPwException();
		} else if("".equals(mv.getMemTel())) {
			throw new NullMemTelException();
		}
		int cnt = memberDAO.updateMember(session, mv);
		session.close();
		return cnt;
	}

	@Override
	public int memberDelete(String memId) throws SQLException {
		SqlSession session = factory.openSession();
		int cnt = memberDAO.deleteMember(session, memId);
		session.close();
		return cnt;
	}

}
