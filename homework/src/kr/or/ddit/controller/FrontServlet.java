package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;

public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapper handerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String handlerMapperType = config.getInitParameter("HandlerMapper");
		
		try {
			this.handerMapper = (HandlerMapper) injectionBean(handlerMapperType);
			System.out.println("[FrontHandler] HandlerMapper 준비 완료!");
		} catch (Exception e) {
			System.out.println("[FrontHandler] HandlerMapper 준비되지 않음.");
		}
	}
	
	private Object injectionBean(String klass) throws Exception {
		Class<?> cls = Class.forName(klass);
		return cls.newInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		Handler handler = null;
		String view = null;
		
		if(handerMapper != null) {
			handler = handerMapper.getHandler(command);
			if(handler != null) {
				try {
					view = handler.process(request, response);
					
					if(view != null) {
						ViewResolver.view(request, response, view);
					}
				} catch (Exception e) {
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
			} else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
		} else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
