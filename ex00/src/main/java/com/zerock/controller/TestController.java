package com.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class TestController {
	
	@RequestMapping(value="/req_ex01") //test/* ���Ŀ� ��� ������ �����ϴ� controller
	public void req_ex01() {
		//@RequestMapping���� ������ /test/req_ex01�� ����
		System.out.println("void�޼����� ������ �̵�");
	}
	
	
	/* return���� ��� ������ �� �־�� �ؿ�
	@RequestMapping(value="/req_ex01")
	public String req_ex01() {
		return "test/req_ex01";
		
	}
	*/
	/*
	@RequestMapping(value="/")
	public String req_ex01() {
		return "redirect:req_ex01";
	
				
	}
	*/	
}
