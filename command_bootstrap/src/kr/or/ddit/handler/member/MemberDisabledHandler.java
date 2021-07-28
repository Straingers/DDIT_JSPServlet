package kr.or.ddit.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberDisabledHandler implements Handler {

	private MemberService memberSerivce;
	
	public void setMemberSerivce(MemberService memberService) {
		this.memberSerivce = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/stop_success";
		
		String id = request.getParameter("id");
		
		memberSerivce.disabled(id);

		MemberVO member = memberSerivce.getMember(id);
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(member.getId().equals(loginUser.getId())) {
			session.invalidate();
		}
		request.setAttribute("member", member);
		
		return url;
	}

}
