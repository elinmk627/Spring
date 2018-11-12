package com.example.demo.ioc.step6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * 축구에서 공격수, 수비수, 골키퍼로 나두듯이
 * 웹 프로그램을 컨트롤러, 서비스, 리파지토리로 나누어 관리함.
 * 이는 역할에 따라서 구분하면 관리성이 증대되기 때문임.
 * 클래스를 빈 컨테이너에 등록할 때, 역할에 따라 @Conponent를 상속한
 * @Service 애노테이션을 대신 사용하는 이유가됨.
 */
@Service("manager")
public class OrderManager {
	
	// @Autowired : 빈 컨테이너에서 자료형이 CarMaker인 객체를 직접 변수에 할당하라.
	// 현재 인터페이스로 현대와 기아가 있기때문에 @Qualifier("kiaMaker") 기아로 지정해줌
	@Autowired()
	@Qualifier("kiaMaker")
	CarMaker maker;	
	
	public OrderManager() {
		
	}
	
	/*
	 * expected single matching bean but found 2: hyundaiMaker,kiaMaker
	 * @Qualifier("kiaMaker") 생성자에는 붙일수 없지만 파라미터에서 사용가능
	 */
		
	public OrderManager(@Qualifier("kiaMaker") CarMaker maker) {
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

	public CarMaker getMaker() {
		return maker;
	}

	// 빈 컨테이너에서 id가 hyundaiMaker인 객체를 파라미터로 주입하라.
//	@Resource(name="hyundaiMaker")
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
}
