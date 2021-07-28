package kr.or.ddit.handler.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;

public class ProdRegistFormHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "prod/regist";
		return url;
	}

}
