package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.BoardModifyCommand;
import com.spring.command.BoardRegistCommand;
import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/main")
	public String main() {
		String url = "board/main.open";
		return url;
	}
	
	@RequestMapping("/list")
	public String list(SearchCriteria cri, Model model) throws Exception {
		String url = "board/list.open";
		
		Map<String, Object> dataMap = boardService.getBoardList(cri);
		
		model.addAttribute("dataMap", dataMap);
		
		return url;
	}
	
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "board/regist.open";
		return url;
	}
	
	@RequestMapping("/regist")
	public String regist(BoardRegistCommand regReq, HttpServletRequest request) throws Exception {
		String url = "board/regist_success";
		
		BoardVO board = regReq.toBoardVO();
		board.setTitle((String)request.getParameter("XSStitle"));
		
		boardService.regist(board);
		
		return url;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(int bno, @RequestParam(defaultValue="")String from, ModelAndView mnv)
													throws SQLException {
		String url = "board/detail.open";
		
		BoardVO board = null;
		
		if(from.equals("modify")) {
			board = boardService.getBoardForModify(bno);
		} else {
			board = boardService.getBoard(bno);
		}
		mnv.addObject("board", board);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(int bno, ModelAndView mnv) throws Exception {
		String url = "board/modify.open";
		
		BoardVO board = boardService.getBoardForModify(bno);
		
		mnv.addObject(board);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardModifyCommand modifyReq, HttpServletRequest request) throws Exception {
		String url = "board/modify_success";
		
		BoardVO board = modifyReq.toBoardVO();
		board.setTitle((String)request.getAttribute("XSStitle"));
		
		boardService.modify(board);
		
		return url;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(int bno) throws Exception {
		String url = "board/remove_success";
		
		boardService.remove(bno);
		
		return url;
	}
}
