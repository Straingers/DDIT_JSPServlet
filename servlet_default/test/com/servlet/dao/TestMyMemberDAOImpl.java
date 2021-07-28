package com.servlet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.servlet.dto.MemberVO;
import com.servlet.mybatis.OracleMyBatisSessionFactory;

public class TestMyMemberDAOImpl {

	private SqlSession session;
	private MyMemberDAO memberDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSessionFactory().openSession(false);
		memberDAO = new MyMemberDAOImpl();
	}
	
	@Test
	public void testSelectAllMember() throws Exception {
		List<MemberVO> memberList = memberDAO.selectAllMember(session);
		Assert.assertEquals(1, memberList.size());
	}
	
	@Test
	public void testSelectMemberById() throws Exception {
		MemberVO mv = memberDAO.selectMemberById(session, "mem001");
		Assert.assertEquals("김회원", mv.getMemName());
	}
	
	@Test
	public void testCreateMember() throws Exception {
		MemberVO mv = new MemberVO();
		mv.setMemId("test01");
		mv.setMemName("테스트");
		mv.setMemPw("test");
		mv.setMemTel("010-1111-1111");
		int cnt = memberDAO.createMember(session, mv);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdateMember() throws Exception {
		MemberVO mv = new MemberVO();
		mv.setMemId("test01");
		mv.setMemName("테스트2");
		mv.setMemPw("test2");
		mv.setMemTel("010-2222-2222");
		int cnt = memberDAO.updateMember(session, mv);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testDeleteMember() throws Exception {
		String memId = "test01";
		int cnt = memberDAO.deleteMember(session, memId);
		Assert.assertEquals(1, cnt);
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
