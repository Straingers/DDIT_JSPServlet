package kr.or.ddit.handler.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.OrderVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderService;

public class OrderPayPageHandler implements Handler {
	
	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "order/paypage";
		
		String[] orderNos = request.getParameter("orderNo").split(",");
		String orderStatus = "결제대기";
		
		for(String orderNo : orderNos) {
			OrderVO order = new OrderVO();
			order.setOrderNo(orderNo);
			order.setOrderStatus(orderStatus);
			
			orderService.changeOrderStatus(order);
		}
		
		List<OrderVO> orderList = orderService.getOrderList();
		
		request.setAttribute("orderList", orderList);
		
		return url;
	}

}
