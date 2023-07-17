package com.bitacademy.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	// 데이터 넘길 때, 이 방법 추천!
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		
		model.addAttribute("name", name);
		
		return "/WEB-INF/views/hello3.jsp";

	}
	
	@ResponseBody   // 호출한 메서드에 ResponseBody가 붙어있으면 다르게 해석한다. 리턴하는 애가 message라고 생각.
	@RequestMapping("/hello5")
	public String hello5() {
		
		return "<h1>Hello World</h1>";

	}
	
	
	// 리다이렉트 방법
	@RequestMapping("/hello6")
	public String hello6() {
		
		return "redirect:/hello";  //자기가 controller에 맵핑한 부분만 적기

	}
	
	
	// 기술 침투한 예시 (Servlet이 Spring에 침투함)
	@RequestMapping("/hello7")
	public void hello7(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
		
		String name = request.getParameter("name");
		out.write("hello" + name);
		
	}
}
