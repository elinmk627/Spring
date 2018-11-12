package com.example.demo.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

//<context:property-placeholder location="my.properties"/>
//@PropertySource(value = { "my.properties" })
@Component
@Data
public class Person {
	
	// #{} : bean id로 찾음
	@Value("#{member.name}")
	private String name;
	
	@Value("#{member.age}")
	private int age;
	
	// ${} : 프로포티에서 찾음
	// :null : car.default.name 키로 찾았는데 없으면 대신 null을 할당
	@Value("${car.default.name:null}")
	private String carName;
	
	@Value("${car.default.doors:0}")
	private int carDoors;
	
	// Run As > Run Configuration > VM arguments > -Duser.region=KR
	// java -jar 빌드결과.jar -Duser.region=KR
	@Value("#{systemProperties['user.region'] == null ? 'US' : systemProperties['user.region']}")
	// user.region 옵션준게 없으면 US로 할당 / 있으면 사용자가 입력한값 할당
	private String defaultLocale;
}