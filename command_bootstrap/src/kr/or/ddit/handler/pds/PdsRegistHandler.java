package kr.or.ddit.handler.pds;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;

import kr.or.ddit.controller.FileUploadResolver;
import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.dto.PdsVO;
import kr.or.ddit.exception.NotMultipartFormDataException;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.PdsService;
import kr.or.ddit.utils.ExceptionLoggerHelper;
import kr.or.ddit.utils.GetUploadPath;
import kr.or.ddit.utils.MultipartHttpServletRequestParser;

public class PdsRegistHandler implements Handler {

	private PdsService pdsService;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	private final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	private final int MAX_FILE_SIZE = 1024 * 1024 * 40;
	private final int MAX_REQUEST_SIZE = 1024 * 1024 * 200;
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "pds/regist_success";
		
		MultipartHttpServletRequestParser multi = null;
		List<AttachVO> attachList = null;
		try {
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			String uploadPath = GetUploadPath.getUploadPath("pds.upload");
			
			attachList = FileUploadResolver.fileUpload(multi.getFileItems("uploadFile"), uploadPath);
			
		} catch (NotMultipartFormDataException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			e.printStackTrace();
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		PdsVO pds = new PdsVO();
		pds.setTitle(HTMLInputFilter.htmlSpecialChars(multi.getParameter("title")));
		pds.setWriter(multi.getParameter("writer"));
		pds.setContent(multi.getParameter("content"));
		pds.setAttachList(attachList);
		
		try {
			pdsService.regist(pds);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionLoggerHelper.writer(request, e, pdsService);
			throw e;
		}
		return url;
	}

}
