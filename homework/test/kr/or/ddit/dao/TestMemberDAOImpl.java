package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSessionFactory;

public class TestMemberDAOImpl {

	private SqlSession session;
	private MemberDAO memberDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSessionFactory().openSession(false);
		memberDAO = new MemberDAOImpl();
	}
	
	@Test
	public void testSelectAllMember() throws Exception {
		List<MemberVO> memberList = memberDAO.selectAllMember(session);
		Assert.assertEquals(1, memberList.size());
	}
	
	@Test
	public void testSelectMemberById() throws Exception {
		MemberVO mv = memberDAO.selectMemberById(session, "test01");
		Assert.assertEquals("테스트", mv.getName());
	}
	
	@Test
	public void testCreateMember() throws Exception {
		MemberVO mv = new MemberVO();
		mv.setId("test");
		mv.setName("테스트");
		mv.setPwd("test");
		mv.setPhone("010-1111-1111");
		int cnt = memberDAO.createMember(session, mv);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdateMember() throws Exception {
		MemberVO mv = new MemberVO();
		mv.setId("test");
		mv.setName("테스트2");
		mv.setPwd("test2");
		mv.setPhone("010-2222-2222");
		int cnt = memberDAO.updateMember(session, mv);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testDeleteMember() throws Exception {
		String memId = "test";
		int cnt = memberDAO.deleteMember(session, memId);
		Assert.assertEquals(1, cnt);
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
