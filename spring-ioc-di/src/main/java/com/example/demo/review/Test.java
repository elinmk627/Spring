package com.example.demo.review;

// Client
public class Test {
	
	public static void main(String[] args) {
		Employee worker = new Programmer();					// 객체생성
		
		TeamManager manager = new TeamManager();		// 객체생성
		
		manager.setWorker(worker);								// 관계설정(DI)
		manager.order();											// 로직수행(프레임워크가 하지못함)
		
		manager.setWorker(new Designer());						// 객체생성
		manager.order();
		
		manager.setWorker(worker);								// 관계설정(DI)
		manager.order();
		
		/*
		 * A 객체가 의존하는 객체가 B, B2, B3 식으로 자주 변경될 때 
		 * 클래스 내 코드변경을 막고자 객체생성, 관계설정 관련작업을
		 * 개발자가 하지 않고 스프링 프레임워크가 대신 수항하도록 요청함.
		 * 1. XML
		 * 2. Annotation
		 * 3. Java Configuration Class
		 */
	}
}
