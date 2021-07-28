package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.OrderVO;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<OrderVO> selectOrderList(SqlSession session) throws SQLException {
		return session.selectList("Order-Mapper.selectOrderList");
	}

	@Override
	public List<OrderVO> selectOrderListById(SqlSession session, String id) throws SQLException {
		return session.selectList("Order-Mapper.selectOrderListById", id);
	}

	@Override
	public void changeOrderQty(SqlSession session, OrderVO order) throws SQLException {
		session.update("Order-Mapper.changeOrderQty", order);
	}

	@Override
	public void deleteOrder(SqlSession session, String orderNo) throws SQLException {
		session.update("Order-Mapper.deleteOrder", orderNo);
	}

	@Override
	public void changeOrderStatus(SqlSession session, OrderVO order) throws SQLException {
		session.update("Order-Mapper.changeOrderStatus", order);
	}

	@Override
	public void insertOrder(SqlSession session, OrderVO order) throws SQLException {
		session.insert("Order-Mapper.insertOrder", order);
	}

	@Override
	public OrderVO selectOrderByProdId(SqlSession session, String prodId) throws SQLException {
		return session.selectOne("Order-Mapper.selectOrderByProdId", prodId);
	}

	@Override
	public OrderVO selectOrderByOrderNo(SqlSession session, String orderNo) throws SQLException {
		return session.selectOne("Order-Mapper.selectOrderByOrderNo", orderNo);
	}

}
