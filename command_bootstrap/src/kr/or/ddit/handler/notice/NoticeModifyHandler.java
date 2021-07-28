package kr.or.ddit.handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.XSSResolver;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.NoticeService;

public class NoticeModifyHandler implements Handler {
	
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:notice/detail.do?from=modify&nno=" + request.getParameter("nno");
		
		XSSResolver.parseXSS(request);
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		String title = (String) request.getAttribute("XSStitle");
		String content = request.getParameter("content");
		
		NoticeVO notice = new NoticeVO();
		notice.setNno(nno);
		notice.setTitle(title);
		notice.setContent(content);
		
		noticeService.modify(notice);
		request.setAttribute("notice", notice);
		
		return url;
	}

}
