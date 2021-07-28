package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdVO;

public interface ProdService {
	
	// 목록조회
	Map<String, Object> getProdList(SearchCriteria cri) throws SQLException;
	Map<String, Object> getProdCategoryList(SearchCriteria cri) throws SQLException;
	
	// 상세보기
	ProdVO getProd(String id) throws SQLException;
	
	// 수정화면 상세
	ProdVO getProdForModify(String id) throws SQLException;

	void modifyProdQty(ProdVO prod) throws SQLException;
	
	// 등록
	void regist(ProdVO prod)throws SQLException;
	
	// 수정
	void modify(ProdVO board) throws SQLException;

	// 삭제
	void remove(String id) throws SQLException;
}
