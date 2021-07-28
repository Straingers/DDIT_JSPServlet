package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.OrderVO;

public interface OrderDAO {
	
	List<OrderVO> selectOrderList(SqlSession session) throws SQLException;
	
	List<OrderVO> selectOrderListById(SqlSession session, String id) throws SQLException;
	
	OrderVO selectOrderByProdId(SqlSession session, String prodId) throws SQLException;
	
	OrderVO selectOrderByOrderNo(SqlSession session, String orderNo) throws SQLException;
	
	void insertOrder(SqlSession session, OrderVO order) throws SQLException;
	
	void changeOrderStatus(SqlSession session, OrderVO order) throws SQLException;
	
	void changeOrderQty(SqlSession session, OrderVO order) throws SQLException;
	
	void deleteOrder(SqlSession session, String orderNo) throws SQLException;
}
