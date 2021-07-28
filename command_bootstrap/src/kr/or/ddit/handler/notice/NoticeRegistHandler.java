package kr.or.ddit.handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.XSSResolver;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.NoticeService;

public class NoticeRegistHandler implements Handler {

	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/regist_success";
		
		//String title = request.getParameter("title");
		XSSResolver.parseXSS(request);
		
		String title = (String) request.getAttribute("XSStitle");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		NoticeVO notice = new NoticeVO();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		noticeService.regist(notice);
		
		return url;
	}

}
