package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping("/logout")
	public String logout() {
		return "UserController.logout()";
	}
	
	
	//400에러 처리 
	@ResponseBody 
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name ) {  //n으로 오는 파라미터는 name에 넣으라는 의미 (name도 당연히 된다)(자동으로 세팅된것)
		
		//만일, n이라는 이름의 파라미터가 없으면 
		// 400 bad request 에러가 발생한다.
		return "UserController.update("+name+")";
	}
	
	@ResponseBody 
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=false) String name ) {  //n으로 오는 파라미터는 name에 넣으라는 의미 (name도 당연히 된다)(자동으로 세팅된것)
		//required=false는 400에러를 안띄움. null setting 됨. 
	
		return "UserController.update2("+name+")";
	}
	
	@ResponseBody 
	@RequestMapping("/update3")
	public String update3(@RequestParam(value="n", required=true, defaultValue="") String name ) {  //n으로 오는 파라미터는 name에 넣으라는 의미 (name도 당연히 된다)(자동으로 세팅된것)
		
		//값은 넣어야하는데, 없어도 빈스트링을 기본값으로 세팅
		return "UserController.update2("+name+")";
	}
	
	@ResponseBody 
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) {  // int를 string으로 자동 형변환
		return "UserController.list(" + pageNo + ")";											//defaultValue는 String으로 줘야한다. 어차피 형변환 해줌.
	}
}
