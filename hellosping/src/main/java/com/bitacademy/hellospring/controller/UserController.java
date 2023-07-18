package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// @RequestMapping
// 클래스 + 메서드(핸들러) 맵핑 강추!

@Controller
@RequestMapping("/user")   	//중복되는 거는 위로 올리기
public class UserController {
	
	 
	@RequestMapping(value="/join", method=RequestMethod.GET)  // method는 어떤 방식으로 받아올 것인지
	public String joinform() {
		return "/WEB-INF/views/join.jsp";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)  // method는 어떤 방식으로 받아올 것인지, get, post 방식에 따라 구분할 수 있다.
	public String join(UserVo userVo) {							// Spring이 null이 아닌 new를 해서 보내줌
		System.out.println(userVo);								// 변수명이 같으면 아주 간결해짐. 
		return "redirect:/";
	}
	
	@ResponseBody 
	@RequestMapping("/list")
	public String list() {
		return "UserController.list()";
	}
	
	@ResponseBody 
	@RequestMapping("/logout")
	public String logout() {
		return "UserController.logout()";
	}
}
