package com.example.demo.replacer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("method-replace-magic.xml");
		
		Magician magician = context.getBean(Magician.class);	// class를 넣으면 자료형을 찾음(class중에 'Magician'을 달라)
		magician.show();
	}

}
