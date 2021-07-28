package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class HTMLView {

	public static void html(HttpServletResponse resp, String title, String css, String script, String body) 
														throws IOException, ServletException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("<style>" + css + "</style>");
		out.println("<script>" + script + "</script>");
		out.println("</head>");
		out.println("<body>" + body + "</body>");
		out.println("</html>");
	}
	
	public static void html(HttpServletResponse resp, String title, String body) throws IOException, ServletException {
		html(resp, title, null, null, body);
	}
	
	public static void html(HttpServletResponse resp, String script) throws IOException, ServletException {
		html(resp, null, null, script, null);
	}
	
	
	public static void loginView(HttpServletResponse resp) throws IOException, ServletException {
		
		String title = "LOGIN";
		String body = "<form action='/servlet_default/login' method='post'>"
				+ "ID : <input type='text' name='memId' /><br/>"
				+ "PW : <input type='password' name='memPw' /><br/>"
				+ "<input type='submit' value='로그인' />"
				+ "</form>";
		
		html(resp, title, body);
	}
	
}
