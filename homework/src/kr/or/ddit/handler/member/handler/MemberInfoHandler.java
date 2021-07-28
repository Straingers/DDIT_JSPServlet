package kr.or.ddit.handler.member.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;


public class MemberInfoHandler implements Handler {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "view/memberInfo";
		String id = request.getParameter("id");
		MemberVO mv = new MemberVO();
		try {
			mv = memberService.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("mv", mv);
		return url;
	}

}
