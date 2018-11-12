package com.example.demo.ioc.step4;

public class HyundaiMaker implements CarMaker {
	
	@Override  // 부모가 지정한것을 재정의함
	public Car sell(Money money) {
		System.out.println("HyundaiMaker: sell(Money money) called.");
		
		System.out.println("HyundaiMaker: " + money.getAmount() + "원을 차 값으로 받는다.");
		
		Car car = new Car("Sonata");
		System.out.println("HyundaiMake : " + car.getName() + "를 만들어 판다.");
		
		return car;
	}
}
