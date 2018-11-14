package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Override
	public int insert(Emp emp) throws Exception {
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		
		// 아래 설정은 모두 디폴트 값을 사용하고 있다.
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		transactionDefinition.setTimeout(-1);
		transactionDefinition.setReadOnly(false);
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		int affected = 0;
		
		try {
			// 상단 부분 코드 : Around:Before Advice
			// ************************************
			// Delegation: 타겟 메소드의 핵심로직을 호출한다.
			affected = empDao.insert(emp);
			// ************************************
			// 하단 부분 코드 : Around:After Advice
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			throw e;
		}
		return affected;
	}

	@Override
	public int update(Emp emp) throws Exception {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) throws Exception {
		return empDao.delete(empno);
	}

	@Override
	public List<Emp> findAll() throws Exception {
		return empDao.findAll();
	}

	@Override
	public int count() throws Exception {
		return empDao.count();
	}

	@Override
	public Emp findOne(int empno) throws Exception {
		return empDao.findOne(empno);
	}
}
