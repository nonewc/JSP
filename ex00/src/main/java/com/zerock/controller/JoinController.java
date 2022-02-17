package com.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.JoinVO;
import com.zerock.service.JoinService;


@Controller
@RequestMapping("/join/*")
public class JoinController {

	@Autowired
	JoinService joinService;
	
	
	
		@RequestMapping("/join_view")
		public String join_view() {
		
		return "join/join_view";
		}
		
		@RequestMapping("/welcome")
		public String welcome() {
		return "join/welcome";
		}
	
	
	@RequestMapping("/join")
	public String join(JoinVO vo, RedirectAttributes RA) {
		
		int result = joinService.insertMember(vo);
		
		if (result == 0) {
		return "join/welcome";
		
		} else {
			
		RA.addFlashAttribute("msg", "아이디가 중복됩니다.");
		return "redirect:/join/join_view";
		
		}
	}
	
	
}
