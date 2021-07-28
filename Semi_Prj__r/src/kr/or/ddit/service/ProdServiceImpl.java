package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.ProdDAO;
import kr.or.ddit.dto.ProdVO;

public class ProdServiceImpl implements ProdService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private ProdDAO prodDAO;
	public void setProdDAO(ProdDAO prodDAO) {
		this.prodDAO = prodDAO;
	}

	@Override
	public Map<String, Object> getProdList(SearchCriteria cri) throws SQLException {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<ProdVO> prodList = prodDAO.selectSearchProdList(session, cri);

			// 전체 board 개수
			int totalCount = prodDAO.selectSearchProdListCount(session, cri);

			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("prodList", prodList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Map<String, Object> getProdCategoryList(SearchCriteria cri) throws SQLException {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<ProdVO> prodList = prodDAO.selectSearchProdListByCategory(session, cri);
			
			// 전체 board 개수
			int totalCount = prodDAO.selectSearchProdListByCategoryCount(session, cri);
			
			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);
			
			dataMap.put("prodList", prodList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public ProdVO getProd(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ProdVO prod = prodDAO.selectProdById(session, id);
			return prod;
		} finally {
			session.close();
		}
	}

	@Override
	public ProdVO getProdForModify(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ProdVO board = prodDAO.selectProdById(session, id);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(ProdVO prod) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			prodDAO.insertProd(session, prod);
		} finally {
			session.close();
		}
	}
	@Override
	public void modify(ProdVO prod) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			prodDAO.updateProd(session, prod);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			prodDAO.deleteProd(session, id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void modifyProdQty(ProdVO prod) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			prodDAO.modifyProdQty(session, prod);
		} finally {
			session.close();
		}
		
	}

	
	
}
