package com.example.demo.ioc.step7;


public class OrderManager {
	CarMaker maker;	
	
	public OrderManager() {
		
	}
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
	}
	
	public void order() {
		System.out.println("OrderManager : order() called");
				
		Money money = new Money(2000);
		System.out.println("OrderManager : " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager : " + car.getName() + "를 얻는다.");
	}

	//1. 인터페이스 도입 효과 : CarMaker 구현체는 뭐든지 받을 수 있다.
	public void setMaker(CarMaker maker) {
		//2. 객체 관리를 클래스 내에서 직업하지않는다.
		//OM가 사용하는 객체를 스스로 생성하지 않고 외부에서 주는대로 받아서 사용한다.
		this.maker = maker;
	}
}
