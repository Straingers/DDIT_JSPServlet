package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdVO;

public interface ProdDAO {
	
	
	List<ProdVO> selectSearchProdList(SqlSession session,SearchCriteria cri) 
				throws SQLException;
	List<ProdVO> selectSearchProdListByCategory(SqlSession session,SearchCriteria cri) 
			throws SQLException;

	int selectSearchProdListCount(SqlSession session,SearchCriteria cri) 
				throws SQLException;
	
	int selectSearchProdListByCategoryCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	ProdVO selectProdById(SqlSession session,String id) throws SQLException;
	
	void increaseViewCount(SqlSession session,String id) throws SQLException;

	void modifyProdQty(SqlSession session, ProdVO prod) throws SQLException;
	
	int selectProdSequenceNextValue(SqlSession session) throws SQLException;
	
	void insertProd(SqlSession session,ProdVO Prod) throws SQLException;
	
	void updateProd(SqlSession session,ProdVO Prod) throws SQLException;

	void deleteProd(SqlSession session,String id) throws SQLException;

}











