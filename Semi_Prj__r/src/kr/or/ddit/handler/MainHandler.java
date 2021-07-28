package kr.or.ddit.handler;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.service.BoardService;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.NoticeService;

public class MainHandler implements Handler {

	private BoardService boardService;// = new BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="common/main";
		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);		
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		Map<String,Object> dataMap = null;
		Map<String,Object> dataMap2 = null;
		
		try {
			dataMap = noticeService.getNoticeList(cri);
			dataMap2 = boardService.getBoardList(cri);

			request.setAttribute("dataMap", dataMap);
			request.setAttribute("dataMap2", dataMap2);
		} catch (SQLException e) {
			e.printStackTrace();
			url=null;
		}		

		return url;
	}

}
