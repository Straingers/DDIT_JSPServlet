package com.servlet.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.servlet.dto.MemberVO;
import com.servlet.exception.NotFoundMemberException;
import com.servlet.exception.NullMemIDException;
import com.servlet.exception.NullMemNameException;
import com.servlet.exception.NullMemPwException;
import com.servlet.exception.NullMemTelException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/memberInsert")
public class MemberInsertServlet extends HttpServlet {
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/memberInsert.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		MemberVO mv = new MemberVO();
		
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		mv.setMemId(memId);
		mv.setMemPw(memPw);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		
		int cnt = 0;
		String msg = "";
		String back = "N";
		try {
			cnt = memberService.memberInsert(mv);
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "회원등록 중 오류가 발생하였습니다.";
		} catch (NullMemIDException e) {
			msg = e.getMessage();
			back = "Y";
		} catch (NullMemPwException e) {
			msg = e.getMessage();
			back = "Y";
		} catch (NullMemNameException e) {
			msg = e.getMessage();
			back = "Y";
		} catch (NullMemTelException e) {
			msg = e.getMessage();
			back = "Y";
		} 
		if(cnt > 0) {
			msg = "회원 등록 성공!";
		}
		List<MemberVO> memberList = null;
		try {
			memberList = memberService.getAllMember();
		} catch (NotFoundMemberException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("back", back);
		req.setAttribute("memberList", memberList);
		
		req.getRequestDispatcher("WEB-INF/view/memberList.jsp").forward(req, resp);
	}
}
