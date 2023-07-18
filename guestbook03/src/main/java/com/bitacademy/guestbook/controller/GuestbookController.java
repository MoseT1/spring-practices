package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;
	

	@RequestMapping("/")
	public String index(Model model) {
		
		List<GuestbookVo> list = guestbookRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value="n", required=true, defaultValue="0") Long no, Model model) {
		
		model.addAttribute("no", no);
		
		return "/WEB-INF/views/deleteform.jsp";
		
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam(value="n", required=true, defaultValue="0") Long no, String password) {  //변수명이 다르니까 작동 못함
		
		guestbookRepository.deleteByPassword(no, password);
		return "redirect:/";
		
	}
}
