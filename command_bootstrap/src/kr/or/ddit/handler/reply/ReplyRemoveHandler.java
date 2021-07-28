package kr.or.ddit.handler.reply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ReplyService;

public class ReplyRemoveHandler implements Handler {

	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		int page = Integer.parseInt(request.getParameter("page"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			replyService.removeReply(rno);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(new SearchCriteria());
			pageMaker.setTotalCount(replyService.getReplyListCount(bno));
			
			int realEndpage = pageMaker.getRealEndPage();
			
			if(page > realEndpage) {
				page = realEndpage;
			}
			
			PrintWriter out = response.getWriter();
			out.print(page);
			out.close();
			response.sendError(HttpServletResponse.SC_OK);
		} catch (SQLException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		} 
		return url;
	}

}
