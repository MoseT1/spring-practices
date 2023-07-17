package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller    //Anotation은 컴파일러가 보고 작동한다.
public class HelloController {
	
	@RequestMapping("/hello")  // requestDispatcher에서 /hellospring 까지를 받겠다 했으므로, 그 다음 부분을 입력해서 url 완성
	public String hello() {
		return "/WEB-INF/views/hello.jsp";  // forward하는 부분.
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println("name" + name);
		return "/WEB-INF/views/hello.jsp";  // forward하는 부분.

	}
	

	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name); 				// jsp에 scope 설정한 것처럼 object에 데이터 넣는 부분
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		
		return mav;

	}
}
