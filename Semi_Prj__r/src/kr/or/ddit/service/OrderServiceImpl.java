package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.OrderDAO;
import kr.or.ddit.dto.OrderVO;

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	private SqlSessionFactory SqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.SqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<OrderVO> getOrderList() throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			List<OrderVO> orderList = orderDAO.selectOrderList(session);
			
			return orderList;
		} finally {
			session.close();
		}
	}

	@Override
	public List<OrderVO> getOrderListById(String id) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			List<OrderVO> orderList = orderDAO.selectOrderListById(session, id);
			
			return orderList;
		} finally {
			session.close();
		}
	}

	@Override
	public void changeOrderQty(OrderVO order) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			orderDAO.changeOrderQty(session, order);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(String orderNo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			orderDAO.deleteOrder(session, orderNo);
		} finally {
			session.close();
		}
	}

	@Override
	public void changeOrderStatus(OrderVO order) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			orderDAO.changeOrderStatus(session, order);
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(OrderVO order) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			orderDAO.insertOrder(session, order);
		} finally {
			session.close();
		}
	}

	@Override
	public OrderVO getOrderByProdId(String prodId) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			OrderVO order = orderDAO.selectOrderByProdId(session, prodId);
			return order;
		} finally {
			session.close();
		}
	}

	@Override
	public OrderVO getOrderByOrderNo(String orderNo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			return orderDAO.selectOrderByOrderNo(session, orderNo);
		} finally {
			session.close();
		}
	}

}
