package com.example.demo.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Qualifier("myService")
@Order(1)
public class Service2 implements TheService {

}
