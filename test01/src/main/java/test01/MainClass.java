package test01;





import org.springframework.context.support.GenericXmlApplicationContext;

import test02.ex01.construct.Hotel;
import test02.ex02.setter.DatabaseDev;

public class MainClass {

	
	
	
	
	
	public static void main(String[] args) {
		
		//SpringTest st = new SpringTest(); // 기존 방식으로 객체를 생성
		
		//st.method();						// 객체에 생성된 메서드를 실행
		
		
		String resources = "classpath:test/applicationContext.xml";
		
		//XML을 로드, applicationContext.xml을 이용한 ct 객체 생성
		GenericXmlApplicationContext ct
		= new GenericXmlApplicationContext(resources);
		
		
		// ct객체에 의해서 생성된 bean을 호출(getBean("객체이름",불러올 클래스 object)
		SpringTest test = ct.getBean("good", SpringTest.class);
		test.method();	//test.객체에 스프링 Container에 생성되어 호출된 객체 저장.method()사용
		
		//ApplicationContext.xml에서 정의된 Bean을 호출
		Hotel hotel = ct.getBean("hotel", Hotel.class);
		//XML에 정의된 DI에 의해서 Chef클래스를 별도로 불러오지 않고, 정의하지 않은 상태에서 불러옴.
		hotel.getChef().cook();
		
		DatabaseDev DBdev = ct.getBean("Dbdev", DatabaseDev.class);
		DBdev.test();
		
		
		
		ct.close();
		
	
	
		
		
		
	}
	
	
	
	
	
}


