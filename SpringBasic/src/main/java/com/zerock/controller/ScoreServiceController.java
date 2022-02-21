package com.zerock.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.ScoreVO;
import com.zerock.service.ScoreService;
import com.zerock.service.ScoreServiceImpl;






@Controller
@RequestMapping("/service/*") //���񽺰� ���������� ����� ����
public class ScoreServiceController {

	
	
	
	
	// 1. 객체 생성
	//ScoreService scoreService = new ScoreServiceImpl();
	
	//2. 설정에 bean 등록 후에 ScoreService scoreService 주입설정
	
	////servlet에 <beans:bean id="scoreService" class="com.zerock.service.ScoreServiceImpl"/>
	//@Resource(name="scoreService")
	//ScoreService scoreService;
	
	//3. 어토네이션을 활용한  반생성 및 자동 주입 설정(//@Service로 주입)
	@Autowired
	ScoreService scoreService;
	
	
	
	//ȭ��ó��
	@RequestMapping("/1scoreRegister")
	public String score() {
		
		
		return "service/1scoreRegister";
	}
	
	//���� ��� �޼���
	@RequestMapping("scoreForm")
	public String scoreForm(ScoreVO vo) {
		
		scoreService.scoreRegist(vo);	// ���� ���
		
		return "service/2scoreResult"; // �� �������� ���ؼ� ���� �̵�
	}
	
	// 점수 리스트
	@RequestMapping("/3scoreList")
	public String scoreList(Model model) {
		//결과 반환메서드
		//메서드의 파라미터에 model을 추가하여, model에 list를 실어줌 (화면에서 사용 가능하게)
		ArrayList<ScoreVO> scorelist = scoreService.scoreResult();
		model.addAttribute("scoreList",scorelist);
		
		return "service/3scoreList";
		
	}
	
	//삭제
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") String num) {
		
		//점수 삭제
		scoreService.scoreDelete(num);
		
		
		// return "service/3scoreList"; // 이렇게 화면으로 넘겨주면 list 값을 가져갈 수 없음.
		return "redirect:/service/3scoreList";	//***다시 컨트롤러를 탈 수 있게 강제 이동
	}
}
