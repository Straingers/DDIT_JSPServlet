package kr.or.ddit.handler.member;

import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.NotFoundMemberException;
import kr.or.ddit.exception.NullMemIDException;
import kr.or.ddit.exception.NullMemNameException;
import kr.or.ddit.exception.NullMemPwException;
import kr.or.ddit.exception.NullMemTelException;
import kr.or.ddit.exception.OverLapIDException;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberInsertHandler implements Handler {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "";
		
		if(request.getMethod().equals("GET")) {
			url = "view/memberInsert";
			return url;
		} else {
			MemberVO mv = new MemberVO();
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String picture = request.getParameter("picture");
			String phone = request.getParameter("phone");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			mv.setId(id);
			mv.setPwd(pwd);
			mv.setEmail(email);
			mv.setPicture(picture);
			mv.setPhone(phone);
			mv.setName(name);
			mv.setAddress(address);
			
			int cnt = 0;
			String msg = "";
			String back = "N";
			try {
				cnt = memberService.memberInsert(mv);
			} catch (SQLException e) {
				e.printStackTrace();
				msg = "회원등록 중 오류가 발생하였습니다.";
			} catch (NullMemIDException e) {
				msg = e.getMessage();
				back = "Y";
			} catch (OverLapIDException e) {
				msg = e.getMessage();
				back = "Y";
			} 
			catch (NullMemPwException e) {
				msg = e.getMessage();
				back = "Y";
			} catch (NullMemNameException e) {
				msg = e.getMessage();
				back = "Y";
			} catch (NullMemTelException e) {
				msg = e.getMessage();
				back = "Y";
			} 
			if(cnt > 0) {
				msg = "회원 등록 성공!";
			}
			List<MemberVO> memberList = null;
			try {
				memberList = memberService.getAllMember();
			} catch (NotFoundMemberException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("msg", msg);
			request.setAttribute("back", back);
			request.setAttribute("memberList", memberList);
			
			url = "redirect:" + request.getContextPath() + "/member/main.do?msg=" 
					+ URLEncoder.encode(msg, "UTF-8") + "back="
					+ URLEncoder.encode(back, "UTF-8");
			return url;
		}
	}

}
