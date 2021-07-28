package kr.or.ddit.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;

public class LoginCheckFilter implements Filter {

	private List<String> exURLs = new ArrayList<String>();
	
	public void init(FilterConfig fConfig) throws ServletException {
		String excludeURLNames = fConfig.getInitParameter("exclude");
		StringTokenizer st = new StringTokenizer(excludeURLNames, ",");
		while(st.hasMoreTokens()) {
			exURLs.add(st.nextToken().trim());
		}
		System.out.println("LoginCheckFilter 준비 완료");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		// 제외할 url 확인
		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());
		
//		System.out.println("request URI : " + reqUrl);
//		return;
		
		// 제외 url 체크
		if(excludeCheck(reqUrl)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인 상태 확인
		if(loginUser == null) { // 비 로그인 상태
			httpResp.setContentType("text/html;charset=utf-8");
			PrintWriter out = httpResp.getWriter();
			out.println("<script>");
			out.println("alert('로그인은 필수입니다.');");
			out.println("if(window.opener) {"
					+ "window.close(); window.opener.parent.location.href = '"
					+ httpReq.getContextPath() + "/';} else {");
			out.println("window.parent.location.href = '" + httpReq.getContextPath() + "/';");
			out.println("}");
			out.println("</script>");
			out.close();
		} else { // 로그인 상태
			chain.doFilter(request, response); // 통과
		}
	}
	
	// 제외할 URL체크 메서드
	private boolean excludeCheck(String url) {
		if(url.length() <= 1) {
			return true;
		}
		for(String exURL : exURLs) {
			if(url.contains(exURL)) {
				return true;
			}
		}
		return false;
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
