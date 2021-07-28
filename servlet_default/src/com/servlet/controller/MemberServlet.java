package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.service.IMemberService;
import com.servlet.service.IMemberServiceImpl;

@WebServlet("/loginMember")
public class MemberServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>로그인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>로그인</h1>");
		out.println("<form id='fm'>");
		out.println("ID : <input type='text' id='memId' name='memId'><br>");
		out.println("PW : <input type='password' id='memPw' name='memPw'><br>");
		out.println("<input type='button' onclick='login()' value='로그인'>");
		out.println("</form>");
		out.println("<script type='text/javascript'>");
		out.println("function login(){");
		out.println("	if(document.getElementById('memId').value == ''){");
		out.println("		alert('아이디가 입력되지 않았습니다.');");
		out.println("		return;");
		out.println("	}");
		out.println("	if(document.getElementById('memPw').value == ''){");
		out.println("		alert('비밀번호가 입력되지 않았습니다.');");
		out.println("		return;");
		out.println("	}");
		out.println("	var fm = document.getElementById('fm');");
		out.println("	fm.action = '/servlet_default/login';");
		out.println("	fm.method = 'post';");
		out.println("	fm.submit();");
		out.println("}");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		
		IMemberService service = IMemberServiceImpl.getInstance();
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		int cnt = service.MemIdCheck(memId);
		
		if(cnt == 0) {
			out.println("<script type='text/javascript'>");
			out.println("alert('존재하지 않는 아이디 입니다.');");
			out.println("</script>");
			doGet(req, resp);
			return;
		}
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemPw(memPw);
		cnt = service.memberSign(mv);
		if(cnt == 0) {
			out.println("<script type='text/javascript'>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("</script>");
			doGet(req, resp);
			return;
		}
		
		mv = service.getMember(memId);
		out.println("<script type='text/javascript'>");
		out.println("alert('"+ mv.getMemName() + "님 환영합니다!');");
		out.println("</script>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>메인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Main</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
