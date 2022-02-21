package com.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.MemberVO;
import com.zerock.service.MemberService;

@Controller
@RequestMapping("/service/*")
public class MemberServiceController {
	
	@Autowired
	MemberService memberService;
	
	
	
	//ȭ��ó�� (����)
	@RequestMapping("/member_ex01")
	public String member_ex01() {
	
	return "service/member_ex01";
	}
	
	
	
	//ȭ��ó�� (ȸ������)
	@RequestMapping("/member_ex00")
	public String member_ex00() {
		//ȸ�� ���� �Է�
		return "service/member_ex00";
		
	}
	
	//ȸ������ �޼���
	@RequestMapping("/join")
	public String join(MemberVO vo) {
		
		memberService.insertMember(vo);
		
		return "service/member_ex02";
	}
	
	//�α��� ȭ��ó��
	@RequestMapping("/member_ex03")
	public String member_ex03() {
		
		return "service/member_ex03";
	}
	
	//�α��� �޼��� ó��
	@RequestMapping("login")
	public String login(MemberVO vo, Model model, RedirectAttributes RA) {
		
		//�α��� ��ȿ�� �˻� (���񽺷� ���̵� ����)
		int result = memberService.memberCheck(vo);
		
		if (result == 1) { //�α��� ����
			
			model.addAttribute("memberInfo", vo);
			return "service/member_mypage"; //�α��� ������ ������������ �̵�
			
		} else { //�α��� ���н� �α��� �������� �̵�
			
			RA.addFlashAttribute("msg", "���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���");
			return "redirect:/service/member_ex03";
			
		}
		
		
	}
	
	//model and view �� ����
	
	//ModelAndView mav = new ModelAndView(); // ��ü ����
	//mav.addAttribute("memberInfo", vo);
	//mav.setViewName("service/member_mypage");
	//return mav;
	
	
	
	
	
	
	
	
	
	//�������� ���
	@RequestMapping(value="memlogin", method=RequestMethod.POST)
	public String memlogin(Model model, HttpServletRequest request) {
		
		String memid = request.getParameter("memid");
		String mempw = request.getParameter("mempw");
		
		model.addAttribute("memId",memid);
		model.addAttribute("memPw",mempw);
		
		return "service/result";
	}
	
	//RequestParam ������̼��� �̿��� HTTP ���� ���� ���
	@RequestMapping(value="memlogin2", method=RequestMethod.POST)
	public String memlogin(Model model,
			@RequestParam("memid") String memid,
			@RequestParam("mempw") String mempw
			) {
		
		model.addAttribute("memId",memid);
		model.addAttribute("memPw",mempw);
		
		return "service/result";
	}
	
	// Ŀ�ǵ� ��ü�� �̿��� HTTP ���� ���� ���
	@RequestMapping(value="memlogin3", method=RequestMethod.POST)
	public String memlogin3(Model model, MemberVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		model.addAttribute("memId", vo.getId());
		model.addAttribute("memPw", vo.getPw());
		
		
		return "service/result";
	}
	
}
