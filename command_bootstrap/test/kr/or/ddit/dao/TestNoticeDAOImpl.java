package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.mybatis.OracleMyBatisSessionFactory;

public class TestNoticeDAOImpl {

	private SqlSession session;
	private NoticeDAO noticeDAO;
	private SqlSessionFactory factory = new OracleMyBatisSessionFactory();
	
	{
		noticeDAO = new NoticeDAOImpl();
	}
	
	@Before
	public void openSession() throws SQLException {
		session = factory.openSession();
		session.getConnection().setAutoCommit(false);
	}
	
	@Test
	public void selectSearchNoticeList() throws SQLException {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		cri.setSearchType("w");
		cri.setKeyword("mimi");
		
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(session, cri);
		NoticeVO notice = noticeList.get(0);
		
		Assert.assertEquals("mimi", notice.getWriter());
		Assert.assertEquals(9, noticeList.size());
	}
	
	@After
	public void closeSession() {
		session.rollback();
		session.close();
	}
}
