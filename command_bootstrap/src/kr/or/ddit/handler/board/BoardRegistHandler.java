package kr.or.ddit.handler.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.XSSResolver;
import kr.or.ddit.dto.BoardVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.BoardService;

public class BoardRegistHandler implements Handler {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "board/regist_success";
		
		XSSResolver.parseXSS(request);
		
		String title = (String) request.getAttribute("XSStitle");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);

		boardService.regist(board);
		
		return url;
	}

}
