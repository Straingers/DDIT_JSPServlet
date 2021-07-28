package kr.or.ddit.handler.prod;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;
import kr.or.ddit.utils.GetUploadPath;

public class ProdRemoveHandler implements Handler {
	

	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="prod/remove_success";
		String id = request.getParameter("id");
		
		ProdVO prod = prodService.getProd(id);
		
		String savedPath = GetUploadPath.getUploadPath("prod.picture.upload");
		String fileName = prod.getPicture();
		File picture = new File(savedPath, fileName);
		
		if (picture.exists()) {
			picture.delete();
		}
		prodService.remove(id);
		
		
		return url;
	}

}
