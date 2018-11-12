package com.example.demo.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Qualifier("myService")
@Order(2)
public class Service1 implements TheService {

}
