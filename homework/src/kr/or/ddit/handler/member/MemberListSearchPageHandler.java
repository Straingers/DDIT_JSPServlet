package kr.or.ddit.handler.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberListSearchPageHandler implements Handler {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/memberList";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		String searchTypeParam = request.getParameter("searchType");
		String keywordParam = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(pageParam);
		cri.setPerPageNum(perPageNumParam);
		cri.setSearchType(searchTypeParam);
		cri.setKeyword(keywordParam);
		
		Map<String, Object> dataMap = memberService.getAllMember(cri);
		
		request.setAttribute("memberList", dataMap.get("memberList"));
		request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		
		return url;
	}

}
