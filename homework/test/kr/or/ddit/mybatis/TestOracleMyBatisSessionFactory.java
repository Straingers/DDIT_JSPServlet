package kr.or.ddit.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;


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
		MemberVO mv = session.selectOne("Member-Mapper.selectMemberById", "mimi");
		Assert.assertEquals("김형민", mv.getName());
	}
	
	@After 
	public void closeSession() {
		session.close();
	}
	
}
