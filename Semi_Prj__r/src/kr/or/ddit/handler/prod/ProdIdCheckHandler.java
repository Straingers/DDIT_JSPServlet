package kr.or.ddit.handler.prod;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdIdCheckHandler implements Handler {

	private ProdService prodService;
	
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = null;
		String id = request.getParameter("id");
		ProdVO prod = null;
		
		try {
			System.out.println("핸들러 탔니2");
			prod = prodService.getProd(id);
			if(prod != null) {
				System.out.println("핸들러 탔니3");
				PrintWriter out = response.getWriter();
				out.print("duplicated");
				System.out.println("핸들러 탔니4");
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
