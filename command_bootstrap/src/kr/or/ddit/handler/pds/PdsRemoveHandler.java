package kr.or.ddit.handler.pds;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.PdsService;

public class PdsRemoveHandler implements Handler {

	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService =pdsService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "pds/remove_success";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		List<AttachVO> attachList = pdsService.getPds(pno).getAttachList();
		
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				String storedFilePath = attach.getUpLoadPath() + File.separator + attach.getFileName();
				File file = new File(storedFilePath);
				if(file.exists()) {
					file.delete();
				}
			}
		}
		pdsService.remove(pno);
		
		return url;
	}

}
