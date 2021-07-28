package kr.or.ddit.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONResolver {
	
	public static void view(HttpServletResponse response, Object target) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(mapper.writeValueAsString(target));
		
		out.close();
	}
	
}
