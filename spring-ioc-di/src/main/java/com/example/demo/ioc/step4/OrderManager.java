package com.example.demo.ioc.step4;

public class OrderManager {
	
	// 앞부분 공통적으로 CarMaker - 인터페이스로 업캐스팅하여 사용
	// 1. 인터페이스 도입 효과:  멤버변수 부분은 변경이 필요없게 되었음.
	CarMaker maker;
	
	public OrderManager() {
//       객체생성하여 사용하지 말기!!
//		 maker = new HyundaiMaker();
//		 maker = new KiaMaker();
	}
	
	// OrderManager의 거래처가 변화하더라도 OrderManager 클래스 내에 코드를 변경을 막는방법
	// 1. 인터페이스 도입
	// 2. 객체관리를 클래스내에서 직접하지 않는다.
	
	public void order() {
		System.out.println("OrderManager: order() called.");
		
		Money money = new Money(2000);
		System.out.println("OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager: 돈을 주고 " + car.getName() + "를 얻는다.");
	}

	// 1. 인터페이스 토입 효과: CarMaker 구현체는 모든지 받을 수 있다. 
	public void setMaker(CarMaker maker) {
		// 2. 객체관리를 클래스내에서 직접하지 않는다.
		// OM가 사용하는 객체를 스스로 생성하지 않고 외부에서 주는대로 받아서 사용함
		this.maker = maker;
	}	
}
