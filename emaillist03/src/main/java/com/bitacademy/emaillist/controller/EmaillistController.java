package com.bitacademy.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.emaillist.repository.EmaillistRepository;
import com.bitacademy.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "/WEB-INF/views/add.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {  //한글 깨진다고 여기다가 request 받아서 servlet 문법 쓰지말고, filter이용해서 기술 분리해주기
		
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
