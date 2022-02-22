package com.zerock.testmapper;

import java.util.ArrayList;
import java.util.Map;

import com.zerock.command.ScoreVO;

public interface TestMapper {

	public String getTime();
	public ArrayList<ScoreVO> select();
	public boolean insert(ScoreVO vo);
	public boolean insert2(Map<String, String> map);
	
}
