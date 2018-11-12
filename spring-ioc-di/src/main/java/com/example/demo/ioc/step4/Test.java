package com.example.demo.ioc.step4;

public class Test {
	
	public static void main(String[] args) {
//		CarMaker maker = new KiaMaker();							// 객체생성
		CarMaker maker = new HyundaiMaker();							
		
		OrderManager manager = new OrderManager();			// 객체생성
		manager.setMaker(maker);										// 관계설정
		manager.order();												// 로직호출
	}
}
