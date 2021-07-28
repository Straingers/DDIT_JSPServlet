package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.servlet.dao.MemberDAO;
import com.servlet.dao.MemberDAOImpl;
import com.servlet.dto.MemberVO;

@WebServlet("/memberInfo")
public class MemberInfoServlet extends HttpServlet {
	
	private MemberDAO memberDao = MemberDAOImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		MemberVO mv = new MemberVO();
		try {
			mv = memberDao.selectMemberById(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ServletConfig config = getServletConfig();
		ServletContext pageContext = config.getServletContext();
		pageContext.setAttribute("mv", mv);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/memberInfo.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
