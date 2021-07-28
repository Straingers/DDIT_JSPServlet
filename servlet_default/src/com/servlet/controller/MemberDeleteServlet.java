package com.servlet.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
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

@WebServlet("/memberDelete")
public class MemberDeleteServlet extends HttpServlet {

	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		
		String msg = "";
		int cnt = 0;
		try {
			cnt = memberService.memberDelete(memId);
		} catch (SQLException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		if(cnt > 0) {
			msg = "회원 삭제 완료!";
		} else {
			msg = "회원 삭제 실패!";
		}
		List<MemberVO> memberList = null;
		try {
			memberList = memberService.getAllMember();
		} catch (NotFoundMemberException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("memberList", memberList);
		req.setAttribute("msg", msg);
		
		req.getRequestDispatcher("WEB-INF/view/memberList.jsp").forward(req, resp);
	}
	
}
