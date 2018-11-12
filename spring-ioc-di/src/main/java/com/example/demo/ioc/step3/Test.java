package com.example.demo.ioc.step3;

public class Test {

	// 왜? 프레임워크를 사용하는가
	// 차 안타고 걸어다녀도 됨.
	// 스프링은 100개이상의 라이브러리 집합체
	// 왜? Inversion of Control 개념을 적용해야 하는가?
	// IoC: 객체를 관리하는 주체가 역전되었음을 의미함
	// 개발자 ==> 프레임워크
	// 개발자가 객체를 직접 관리하지 않고 프레임워크가 대신 객체를 관리함.
	
	public static void main(String[] args) {
		OrderManager manager = new OrderManager();		
		manager.order();
	}
}
