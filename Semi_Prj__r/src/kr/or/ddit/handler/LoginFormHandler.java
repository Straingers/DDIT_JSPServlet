package kr.or.ddit.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="include/main_aside";
		return url;
	}

}
