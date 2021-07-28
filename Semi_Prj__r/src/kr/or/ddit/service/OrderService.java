package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.OrderVO;

public interface OrderService {
	
	List<OrderVO> getOrderList() throws SQLException;
	
	List<OrderVO> getOrderListById(String id) throws SQLException;
	
	OrderVO getOrderByProdId(String prodId) throws SQLException;
	
	OrderVO getOrderByOrderNo(String orderNo) throws SQLException;
	
	void regist(OrderVO order) throws SQLException;
	
	void changeOrderQty(OrderVO order) throws SQLException;
	
	void remove(String orderNo) throws SQLException;
	
	void changeOrderStatus(OrderVO order) throws SQLException;
}
