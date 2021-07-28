package kr.or.ddit.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberEnabledHandler implements Handler {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/enabled_success";
		
		String id = request.getParameter("id");
		
		memberService.enabled(id);
		
		MemberVO member = memberService.getMember(id);
		request.setAttribute("member", member);
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(member.getId().equals(loginUser.getId())) {
			session.invalidate();
		}
		return url;
	}

}
