package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/out")
public class BufferTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//case1
//		for (int i = 0; i < 100; i++) {
//			out.println("<h3>ㅎㅇㅎㅇ</h3>");
//		}
//		new Scanner(System.in).nextLine(); // 콘솔창에 enter 치기 전까지 브라우저가 실행 안됨.
		
		//case2
//		out.println("<script>alert('네이버로 이동합니다');"
//				+ "location.href='http://www.naver.com'"
//				+ "</script>");
		
		//case3
		String url = "/WEB-INF/views/out.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
