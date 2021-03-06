package com.example.demo.scope;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {
	@Autowired		// 자료형을 찾음(List라 다수를 가질수 있음)
	private List<Car> cars;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("scope-test.xml");

		Car car = context.getBean("car1", Car.class);
		System.out.println(car);

		Car car2 = context.getBean("car1", Car.class);
		System.out.println(car2);

		// Singleton : 컨테이너 안에 해당 객체는 한 개만 존재한다.
		System.out.println(car == car2);		// false
		
		Car car3 = context.getBean("car2", Car.class);
		Car car4 = context.getBean("car2", Car.class);
		System.out.println(car3 == car4);		// false		
		
		// 개발자가 직접 만든 객체를 스프링은 인식하지 못함		
		// 따라서 DI 서비스를 제공하지 못한다.
		// Test test = new Test();							
		
		Test test = (Test) context.getBean("test");	// 주의. Test클래스에 @컴포넌트 붙여야 인식이됨
		System.out.println(test.cars.size());				// 2		
		test.cars.forEach(System.out::println);
		//Car(name=Sonata, maker=Hyundai)
		//Car(name=null, maker=null)	
		
	}

}
