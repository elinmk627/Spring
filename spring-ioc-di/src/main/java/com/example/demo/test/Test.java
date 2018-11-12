package com.example.demo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {
	@Autowired
	private List<TheService> list;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		
		Test test = (Test) context.getBean("test");
		test.list.forEach(System.out::println);
	}

}
