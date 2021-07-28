package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {

	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberVO> memberList = new ArrayList<>();
		String msg = (String) req.getAttribute("msg");
		String back = (String) req.getAttribute("back");
		try {
			memberList = memberService.getAllMember();
		} catch (NotFoundMemberException e) {
			e.printStackTrace();
			req.setAttribute("notMember", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("memberList", memberList);
		req.setAttribute("msg", msg);
		req.setAttribute("back", back);
		
		req.getRequestDispatcher("WEB-INF/view/memberList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
