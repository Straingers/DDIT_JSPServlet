package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping("/test.do")
	public String test() {
		return "test";
	}
	
	// tiles를 사용
	@RequestMapping("/testPage.do")
	public String testPage() {
		return "test.page";
	}
}
