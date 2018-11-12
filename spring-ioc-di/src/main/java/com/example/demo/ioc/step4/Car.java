package com.example.demo.ioc.step4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 상태를 보관하는 용도의 클래스를 관점에 따라서 다음과 같이 부른다.
 * VO(Value Object) - 값을보관하는객체
 * DTO(Data Transfer Object) - 값을 전송하는 객체
 * Domain
 * Model - 클래스가 테이블의 정보와 일치
 * Entity(자바클래스로 테이블 제어) - ORM기술에서 사용
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private String name;
}
