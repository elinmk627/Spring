package com.example.demo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EmpServiceImplTest {

	@Autowired
	private EmpDao empService;

	@Test
	public void testInsert() {
		
		int oldCount = empService.count();
		System.out.println("oldCount = " + oldCount);		
		
		Emp emp = new Emp();
		emp.setEmpno(3201);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);
		
		try {
			int affected = empService.insert(emp);
			System.out.println("affected = " + affected);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int nowCount = 0;
		try {
			nowCount = empService.count();
		} catch (Exception e) { }
		
		System.out.println("nowCount = " + nowCount);
		assertEquals("insert 메소드에서 예외발생, 트랜잭션 어드바이스 적용, " 
				+ "롤백이 되어야 하기 때문에 oldCount 값과 nowCount 값은 같아야 한다.", 
				oldCount, nowCount);
		
		int affected = empService.insert(emp);		
		System.out.println("affected = " + affected);
	}
	
	// 다음 2개의 애노테이션을 동시에 설정하면 메소드가 종료된 후 메소드 내에서 
	// 행한 모든 쿼리작업이 롤백됨.
	@Transactional
	@Test
	public void testUpdate() {
		Emp emp = new Emp();
		emp.setEmpno(4444);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);
		
		try {
			int affected = empService.insert(emp);
			System.out.println("insert affected = " + affected);
		} catch (Exception ignore) { }
		
		System.out.println("수정전 : " +emp);
		
		try {
			emp.setEname("고길동");
			int affected = empService.update(emp);
			System.out.println("update affected = " + affected);
		} catch (Exception ignore) { }
		
		System.out.println("수정후 : " +emp);
		
//		try {
//			int affected = empService.delete(emp.getEmpno());
//			System.out.println("delete affected = " + affected);
//		} catch (Exception e) {}
	}

	public void testFindOne() {
		try {
			Emp emp = empService.findOne(4444);
			System.out.println(emp);
		} catch (Exception ignore) { }
		
	}

}
