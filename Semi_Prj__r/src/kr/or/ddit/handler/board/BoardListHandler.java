package kr.or.ddit.handler.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.BoardService;
import kr.or.ddit.service.MemberService;

public class BoardListHandler implements Handler {
	

	private BoardService boardService;// = new BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String url = "board/list";

		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		Map<String,Object> dataMap=boardService.getBoardList(cri);

		request.setAttribute("dataMap", dataMap);
		
		return url;
	}

}
