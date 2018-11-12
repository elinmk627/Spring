package com.example.demo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TheClientBean {
	@Autowired
	@Qualifier("myService")
	private List<TheService> list;
}
