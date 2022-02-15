package test01;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.GenericXmlApplicationContext;

import test02.ex01.construct.Chef;
import test02.ex01.construct.Hotel;
import test02.ex02.setter.DatabaseDev;
import test03.ex01.auto.AuTest;
import test03.ex01.auto.MemTest;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//SpringTest st = new SpringTest();   	//기존 방식으로 객체를 생성
		//st.method();							//객체에 생성된 메서드를 실행
		
		String resources = "classpath:test/applicationContext.xml";
		
		//XML을 로드, applicationContext.xml을 이용한 ct객체 생성 
		GenericXmlApplicationContext ct = new GenericXmlApplicationContext(resources);
		
		//ct객체에 의해서 생성된 bean을 호출(getBean("객체이름",불러올 클래스object)
		SpringTest test = ct.getBean("good", SpringTest.class);
		SpringTest test2 = ct.getBean("good", SpringTest.class);
		//test.method();    	//test.객체에 스프링 Container에 생성되어 호출된 객체 저장. method()사용
		
		System.out.println("프로토타입1 : "+test);
		System.out.println("프로토타입2 : "+test2);
		//ApplicationContext.xml에서 정의된 Bean을 호출
		Hotel hotel = ct.getBean("hotel", Hotel.class);
		//XML에 정의된 DI에 의해서 Chef클래스를 별로 불러오지 않고, 정의하지 않은 상태에서 불러옴. 
		//의존성 주입 처리됨. 
		hotel.getChef().cook();
		System.out.println("hotel1 객체 : "+hotel);
		Hotel hotel2 = ct.getBean("hotel",Hotel.class);
		System.out.println("hotel2 객체 : "+hotel2);
		
		Chef cf = ct.getBean("chef",Chef.class);
		System.out.println("Chef 객체 : "+cf);
		Chef cf2 = ct.getBean("chef2",Chef.class);
		System.out.println("Chef2 객체 : "+cf2);
		/*
		DatabaseDev DBdev = ct.getBean("DBdev",DatabaseDev.class);
		DBdev.test();
		QueryOut testQuery = new QueryOut(DBdev.testQuery("select * from users"));
		testQuery.method();
		*/
		
		AuTest atest = ct.getBean("auTest", AuTest.class);
		MemTest mtest = ct.getBean("memTest", MemTest.class);
		MemTest mtest2 = ct.getBean("memTest2", MemTest.class);
		
		System.out.println("atest 결과 : "+atest.getMem().getUid());
		System.out.println("memTest 결과 : "+mtest.getUid());
		System.out.println("memtest2 결과 : "+mtest2.getUid());
		
		
		
		ct.close();  		//ct 객체를 닫기
		
	}
}
