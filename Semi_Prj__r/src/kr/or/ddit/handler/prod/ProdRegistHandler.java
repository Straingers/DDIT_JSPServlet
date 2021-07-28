package kr.or.ddit.handler.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.XSSResolver;
import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdRegistHandler implements Handler {
	

	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="prod/regist_success";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String outline = request.getParameter("outline");
		String detail = request.getParameter("detail");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		String picture = request.getParameter("picture");
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		ProdVO prod = new ProdVO();
		
		prod.setId(id);
		prod.setName(name);
		prod.setOutline(outline);
		prod.setDetail(detail);
		prod.setPrice(price);
		prod.setCategory(category);
		prod.setPicture(picture);
		prod.setQty(qty);
		
		prodService.regist(prod);
		
		
		return url;
	}

}





