package kr.or.ddit.handler.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.dto.OrderVO;
import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.OrderService;
import kr.or.ddit.service.ProdService;

public class OrderAddCartHandler implements Handler {

	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	private ProdService prodService;
	
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		OrderVO order = mapper.readValue(request.getReader(), OrderVO.class);
		OrderVO existOrder = orderService.getOrderByProdId(order.getProdId());
		
		if(existOrder == null) {
			orderService.regist(order);
			return null;
		}
		order.setOrderNo(existOrder.getOrderNo());
		order.setOrderQty(order.getOrderQty() + existOrder.getOrderQty());
		orderService.changeOrderQty(order);
		
		ProdVO prod = new ProdVO();
		prod.setId(order.getProdId());
		prod.setQty(order.getOrderQty());
		prodService.modifyProdQty(prod);
		return url;
	}

}
