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

import com.spring.command.NoticeModifyCommand;
import com.spring.command.NoticeRegistCommand;
import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;
import com.spring.service.NoticeService;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/main")
	public void main() throws Exception {}
	
	@RequestMapping(value="/list")  // mapping url과 jsp의 명이 같으면 ModelAndView를 사용하지 않고 Model만 사용해도 된다.
	public void list(SearchCriteria cri, Model model) throws Exception {
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		
		model.addAttribute("dataMap", dataMap);
	}
	
	@RequestMapping(value="/registForm")
	public String registForm() {
		String url = "notice/regist";
		return url;
	}
	
	@RequestMapping(value="/regist")
	public String regist(NoticeRegistCommand noticeReq, HttpServletRequest request) throws Exception {
		String url = "notice/regist_success";
		
		NoticeVO notice = noticeReq.toNoticeVO();
		notice.setTitle((String)request.getAttribute("XSStitle"));
		
		noticeService.regist(notice);
		
		return url;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView detail(int nno, @RequestParam(defaultValue="") String from, ModelAndView mnv) 
											throws SQLException {
		String url = "notice/detail";
		
		NoticeVO notice = null;
		
		if(from.equals("modify")) {
			notice = noticeService.getNoticeForModify(nno);
		} else {
			notice = noticeService.getNotice(nno);
		}
		mnv.addObject("notice", notice);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyFrom(int nno, ModelAndView mnv) throws Exception {
		String url = "notice/modify";
		
		NoticeVO notice = noticeService.getNoticeForModify(nno);
		
		mnv.addObject("notice", notice);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(NoticeModifyCommand modifyReq, HttpServletRequest request) throws Exception {
		String url = "redirect:/notice/detail.do?from=modify&nno=" + request.getParameter("nno");
		
		NoticeVO notice = modifyReq.toNoticeVO();
		notice.setTitle((String)request.getAttribute("XSStitle"));
		
		noticeService.modify(notice);
		
		return url;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(int nno) throws Exception {
		String url = "notice/remove_success";
		
		noticeService.remove(nno);
		
		return url;
	}
	
	
}
