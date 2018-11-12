package com.example.demo.review.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * TeamManager use Employee. (팀메니져가 임플로이를 사용함)
 * TeamManager has Employee. (팀매니져가 임플로이를 가지고 있어야함)
 * TeamManager depend Employee. (팀매니져가 임플로이에게 의존한다)
 */
@Data
@NoArgsConstructor
@Component("manager2")
public class TeamManager {
//	private Employee worker = new Programmer();
//	private Employee worker = new Designer();
	private Employee worker;
	
	@Autowired	
	public TeamManager(@Qualifier("designer") Employee worker) {
		super();
		this.worker = worker;
	}	
	
	public void order() {
		System.out.println("TeamManager가 " + worker.getClass().getSimpleName() + "에게 일을 시킨다.");
		worker.work();
	}
	
	// @Data가 지정되어있기때문에 getter/setter 사용가능
}
