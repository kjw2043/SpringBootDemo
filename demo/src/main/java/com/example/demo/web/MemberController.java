package com.example.demo.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/member/list")
	public ModelAndView memberList() {
		ModelAndView mv = new ModelAndView("/member/list");
		
		List<Map<String, Object>> list = memberService.selectMemberList();
		
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/member/add")
	public ModelAndView addView() {
		ModelAndView mv = new ModelAndView("/member/add");
		
		return mv;
	}
}
