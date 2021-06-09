package com.example.demo.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.LogVO;
import com.example.demo.domain.PrototypeMasterVO;

@Repository
public interface PrototypeMasterRepository extends JpaRepository<PrototypeMasterVO, BigDecimal> {

	PrototypeMasterVO findByUserKey(BigDecimal userKey);

}
