package kr.or.ddit.handler.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.OrderVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderService;

public class OrderChangeQtyHandler implements Handler {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "order/changeQty_success";
		
		String orderNo = request.getParameter("orderNo");
		String orderNoDetail = request.getParameter("orderNoDetail");
		int orderQty = Integer.parseInt(request.getParameter("orderQty"));
		
		OrderVO order = new OrderVO();
		order.setOrderNo(orderNo);
		order.setOrderNoDetail(orderNoDetail);
		order.setOrderQty(orderQty);

		orderService.changeOrderQty(order);
		
		return url;
	}
	
}
