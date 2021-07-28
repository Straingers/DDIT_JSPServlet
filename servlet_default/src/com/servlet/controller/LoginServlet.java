package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;
import com.servlet.view.HTMLView;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/WEB-INF/views/login.jsp";
		
//		HTMLView.loginView(resp);
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/WEB-INF/views/login_success.jsp";
		
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		
		String script = "";
		
		try {
			MemberVO mv = memberService.login(memId, memPw);
			script = "alert('로그인 성공하였습니다.');"
					+ "location.href = '" + req.getContextPath() + "/main';";
			
		} catch (NotFoundIDException e) {
			script = "alert('" + e.getMessage() + "');"
					+ "history.go(-1);";
		} catch (InvalidPasswordException e) {
			script = "alert('" + e.getMessage() + "');"
					+ "location.href = '"+ req.getContextPath() +"/login';";
			e.printStackTrace();
		} catch (SQLException e) {
			script = "alert('서버 장애로 인해 불가합니다.');"
					+ "history.go(-1);";
			e.printStackTrace();
		}
//		HTMLView.html(resp, script);
		req.setAttribute("script", script);
		req.getRequestDispatcher(view).forward(req, resp);
	}
}