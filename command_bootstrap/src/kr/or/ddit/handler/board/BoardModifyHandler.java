package kr.or.ddit.handler.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.XSSResolver;
import kr.or.ddit.dto.BoardVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.BoardService;

public class BoardModifyHandler implements Handler {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "board/modify_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		XSSResolver.parseXSS(request);
		
		String title = (String) request.getAttribute("XSStitle");
		String content = request.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setTitle(title);
		board.setContent(content);
		
		boardService.modify(board);
		request.setAttribute("board", board);
		
		return url;
	}

}
