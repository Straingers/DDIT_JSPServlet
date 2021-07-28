package com.servlet.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.servlet.dto.MemberVO;

public class TestOracleMyBatisSessionFactory {

	private SqlSessionFactory factory = new OracleMyBatisSessionFactory();
	private SqlSession session;
	
	@Before
	public void init() {
		session = factory.openSession();
	}
	
	@Test
	public void testSqlSession() {
		Assert.assertNotNull(session.getConnection());
	}
	
	@Test
	public void testSQL() {
		MemberVO mv = session.selectOne("Member-Mapper.selectMemberById", "mem001");
		Assert.assertEquals("김회원", mv.getMemName());
	}
	
	@After 
	public void closeSession() {
		session.close();
	}
	
}
