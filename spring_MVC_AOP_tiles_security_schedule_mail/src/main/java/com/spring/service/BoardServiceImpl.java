package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.command.PageMaker;
import com.spring.command.SearchCriteria;
import com.spring.dao.BoardDAO;
import com.spring.dao.ReplyDAO;
import com.spring.dto.BoardVO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	private ReplyDAO replyDAO;

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	@Override
	public Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<BoardVO> boardList = boardDAO.selectSearchBoardList(cri);

		for (BoardVO board : boardList) {
			int replycnt = replyDAO.countReply(board.getBno());
			board.setReplycnt(replycnt);
		}

		int totalCount = boardDAO.selectSearchBoardListCount(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		boardDAO.increaseViewCount(bno);
		return board;
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		return board;
	}

	@Override
	public void regist(BoardVO board) throws SQLException {
		int bno = boardDAO.selectBoardSequenceNextValue();
		board.setBno(bno);
		boardDAO.insertBoard(board);
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}

	@Override
	public BoardVO findFileInContent(String fileName) throws SQLException {
		BoardVO board = boardDAO.selectBarodByFileName(fileName);
		return board;
	}

}
