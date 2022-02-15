package test02.ex01.construct;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Hotel {

	@Resource(name="chef1")	//@Resource는 이름을 우선한다. 이름을 지정하지 않으면, 타입
	private Chef chef;

	public Hotel(Chef chef) {
		this.chef = chef;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	
}
