package kr.or.ddit.handler.order;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.OrderVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderService;

public class OrderListHandler implements Handler {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "order/list";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");		
		
		//String id = request.getParameter("id");
		String id = loginUser.getId();
		
		try {
			List<OrderVO> orderList = orderService.getOrderListById(id);
			
			request.setAttribute("orderList", orderList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return url;
	}

}
