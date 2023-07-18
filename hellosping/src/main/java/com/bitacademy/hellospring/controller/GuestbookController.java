package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RequestMapping
//	클래스 단독 맵핑
//	Spring MVC 4.X에서만 지원! Spring MVC 5.X이상에서는 사용 금지

//@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	
	@ResponseBody 
	@RequestMapping 			// 이걸 붙이면 handler method가 되서 /guestbook/list로 호출된다.
	public String list() { 			// handler 이름이 url이 됨
		return "Guestbook.list()";
	}
}
