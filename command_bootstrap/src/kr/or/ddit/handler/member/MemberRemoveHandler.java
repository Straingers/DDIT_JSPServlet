package kr.or.ddit.handler.member;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.utils.GetUploadPath;

public class MemberRemoveHandler implements Handler {

	private MemberService memberService;
	
	public void setMemberSerivce(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/remove_success";
		
		String id = request.getParameter("id");
		
		MemberVO member = memberService.getMember(id);
		
		// 이미지 삭제
		String savePath = GetUploadPath.getUploadPath("member.picture.upload");
		String fileName = member.getPicture();
		
		File picture = new File(savePath, fileName);
		
		if(picture.exists()) {
			picture.delete();
		}
		
		// DB 삭제
		memberService.remove(id);
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(member.getId().equals(loginUser.getId())) {
			session.invalidate();
		}
		
		return url;
	}

}
