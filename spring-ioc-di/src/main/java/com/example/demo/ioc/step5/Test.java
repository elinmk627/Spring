package com.example.demo.ioc.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	// 왜? 프레임 워크를 사용하는가.
	// 차 안타고 걸어다니셔도 됩니다.
	// 스프링은 100개 이상의 라이브러리 집합체 입니다.
	// 왜? Inversion of Control 개념을 적용해야 하는가?
	// IOC는 객체를 관리하는 주체가 역전(Inversion)되었음을 의미한다.
	// 개발자 ==> 프레임워크
	// 개발자가 객체를 직접관리하지 않고 프레임워크가 대신 객첼글 관리한다.

	public static void main(String[] args) {
////			CarMaker maker = new KiaMaker();	// 객체생성
//		CarMaker maker = new HyundaiMaker();
//
//		OrderManager manager = new OrderManager(); // 객체생성
//		manager.setMaker(maker); // 관계설정
//		manager.order(); // 로직호출
//		
		/*
		 * 스프링에게 객체 생성, 관계 설정을 위임하는 3가지
		 * 1. XML
		 * 2. Annotation
		 * 3. Java Configuration Class
		 */
		
		ApplicationContext context =new ClassPathXmlApplicationContext("car-config.xml");
		OrderManager manager = (OrderManager) context.getBean("manager");
		manager.order();
	} 
}