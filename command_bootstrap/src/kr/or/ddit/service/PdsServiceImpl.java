package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.AttachDAO;
import kr.or.ddit.dao.PdsDAO;
import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.dto.PdsVO;

public class PdsServiceImpl implements PdsService {

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private PdsDAO PdsDAO;
	public void setPdsDAO(PdsDAO pdsDAO) {
		this.PdsDAO = pdsDAO;
	}
	
	private AttachDAO attachDAO;
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO = attachDAO;
	}
	
	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			List<PdsVO> pdsList = PdsDAO.selectSearchPdsList(session, cri);
			
			if(pdsList != null) {
				for(PdsVO pds : pdsList) {
					addAttachList(session, pds);
				}
			}
			
			int totalCount = PdsDAO.selectSearchPdsListCount(session, cri);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);
			
			dataMap.put("pdsList", pdsList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public PdsVO getPds(int pno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			PdsVO pds = PdsDAO.selectPdsByPno(session, pno);

			addAttachList(session, pds);
			
			return pds;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(PdsVO pds) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int pno = PdsDAO.selectPdsSequenceNextValue(session);
			pds.setPno(pno);
			
			PdsDAO.insertPds(session, pds);

			if(pds.getAttachList() != null) {
				for(AttachVO attach : pds.getAttachList()) {
					attach.setPno(pno);
					attach.setAttacher(pds.getWriter());
					attachDAO.insertAttach(session, attach);
				}
			}
		} finally {
			session.close();
		}
		
	}

	@Override
	public void modify(PdsVO pds) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			if(pds.getAttachList() != null) {
				for(AttachVO attach : pds.getAttachList()) {
					attach.setPno(pds.getPno());
					attach.setAttacher(pds.getWriter());
					attachDAO.insertAttach(session, attach);
				}
			}
			PdsDAO.updatePds(session, pds);
		} finally {
			session.close();
		}
		
	}

	@Override
	public void remove(int pno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			PdsDAO.deletePds(session, pno);
		} finally {
			session.close();
		}
	}

	@Override
	public PdsVO read(int pno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			PdsVO pds = PdsDAO.selectPdsByPno(session, pno);
			PdsDAO.increaseViewCount(session, pno);
			
			addAttachList(session, pds);
			
			return pds;
		} finally {
			session.close();
		}
	}

	@Override
	public AttachVO getAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			AttachVO attach = attachDAO.selectAttachByAno(session, ano);
			return attach;
		} finally {
			session.close();
		}
	}

	@Override
	public void removeAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			attachDAO.deleteAttach(session, ano);
		} finally {
			session.close();
		}
	}


	private void addAttachList(SqlSession session, PdsVO pds) throws SQLException {
		if(pds == null) return;
		
		int pno = pds.getPno();
		
		List<AttachVO> attachList = attachDAO.selectAttachByPno(session, pno);
		
		pds.setAttachList(attachList);
	}
	
	
}
