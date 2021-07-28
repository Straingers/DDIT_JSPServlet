package kr.or.ddit.handler.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderService;

public class OrderRemoveHandler implements Handler {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "order/remove_success";
		
		String[] orderNos = request.getParameter("orderNo").split(",");
		String id = request.getParameter("id");
		
		for(String orderNo : orderNos) {
			orderService.remove(orderNo);
		}
		
		request.setAttribute("id", id);
		
		return url;
	}

}
