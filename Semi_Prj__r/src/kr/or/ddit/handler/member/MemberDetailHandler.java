package kr.or.ddit.handler.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberDetailHandler implements Handler {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService=memberService;
	}

	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");		
		String id = loginUser.getId();
		
		String url="member/detail";
//		System.out.println(loginUser.getId());
		MemberVO member = null;
		
		try {
			member = memberService.getMember(id);
			request.setAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
