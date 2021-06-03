package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.LogVO;

@Repository
public class LogRepositorySupport {
	
	@PersistenceContext
    private EntityManager em;

	public List<LogVO> findByLogSeCode(String logSeCode) {
		
		String queryString = "select "
						+ "	date_format(a.createDatetime, '%Y-%m-%d') as visitDay "
						+ ", count(a) as hits "
						+ "from LogVO a "
						+ "where "
						+ "a.logSeCode = :logSeCode ";
//						+ "	and a.create_datetime <= sysdate "
//						+ "	and a.create_datetime >= date_add(sysdate, interval -7 day) "
//						+ " group by function('date_format', a.create_datetime, '%Y-%m-%d')";
	
		TypedQuery<LogVO> query = em.createQuery(queryString, LogVO.class);
		query.setParameter("logSeCode", logSeCode);
		
		List<LogVO> resultList = query.getResultList();

		return resultList;
	}
}
