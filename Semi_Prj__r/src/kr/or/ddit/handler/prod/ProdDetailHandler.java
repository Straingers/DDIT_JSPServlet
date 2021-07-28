package kr.or.ddit.handler.prod;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdDetailHandler implements Handler {
	
	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}
	

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String url="prod/detail";
		

		String id=request.getParameter("id");
		String from=request.getParameter("from");
		
		try {
			ProdVO prod=null;
			if(from!=null && from.equals("modify")) {
				prod = prodService.getProdForModify(id);
			}else {
				 prod = prodService.getProd(id);
			}
			
			request.setAttribute("prod", prod);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}

}
