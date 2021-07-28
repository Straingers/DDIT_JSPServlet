package kr.or.ddit.handler.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.NotFoundMemberException;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberListHandler implements Handler {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/memberList";
		List<MemberVO> memberList = new ArrayList<>();
		String msg = (String) request.getAttribute("msg");
		String back = (String) request.getAttribute("back");
		try {
			memberList = memberService.getAllMember();
		} catch (NotFoundMemberException e) {
			e.printStackTrace();
			request.setAttribute("notMember", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("memberList", memberList);
		request.setAttribute("msg", msg);
		request.setAttribute("back", back);
		
		return url;
	}

}
