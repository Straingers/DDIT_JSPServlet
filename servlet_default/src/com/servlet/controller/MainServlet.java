package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.NotFoundMemberException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;
import com.servlet.view.HTMLView;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	private MemberService memberService = MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		String msg = request.getParameter("msg");
		String script = "";
		
		if(msg != null) {
			script += "alert('" + msg + "');"; 
		}
		List<MemberVO> memberList;
		
		String body = "<h1>MAIN</h1>"
				+ "<table>"
				+ "<tr><th>아이디</th>"
				+ "<th>이름</th>"
				+ "<th>전화번호</th></tr>";
		try {
			memberList = memberService.getAllMember();
			for(int i = 0; i < memberList.size(); i++) {
				body += "<tr>"
						+ "<td>"
						+ "<a href='" + request.getContextPath() + "/memberInfo?memId=" + memberList.get(i).getMemId() + "'>" 
						+ memberList.get(i).getMemId() + "</a></td>"
						+ "<td>" + memberList.get(i).getMemName() + "</td>"
						+ "<td>" + memberList.get(i).getMemTel() + "</td>";
			}
		} catch (NotFoundMemberException e) {
			e.printStackTrace();
			body = "<tr colspan='3'>" + e.getMessage() + "</tr>";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		body += "</table><br><input type='button' onclick='insertMember()' value='회원등록' />";
		script += "function insertMember(){" 
					+ "location.href = '" + request.getContextPath() + "/memberInsert'" 
					+ "}";
		HTMLView.html(response, "메인페이지", null, script, body);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}