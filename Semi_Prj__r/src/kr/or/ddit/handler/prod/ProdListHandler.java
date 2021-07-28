package kr.or.ddit.handler.prod;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdListHandler implements Handler {
	
	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "prod/list";
		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);		
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		Map<String,Object> dataMap=null;
		
		try {
			dataMap=prodService.getProdList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {
			e.printStackTrace();
			url=null;
		}		
		
		
		
		
		return url;
	}

}









