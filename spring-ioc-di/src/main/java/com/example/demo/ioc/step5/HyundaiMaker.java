package com.example.demo.ioc.step5;

public class HyundaiMaker implements CarMaker {
	
	@Override
	public Car sell(Money money)  {
		
		
		System.out.println("HyundaiMaker : sell(Money money) called.");
		
		System.out.println("HyundaiMaker : " + money.getAmount() + "원을 차값으로 받는다.");
		Car car = new Car("Sonata");
		System.out.println("HyundaiMaker : " + car.getName() + "를 만들어 핀다.");
		
		return car;
	}
}
