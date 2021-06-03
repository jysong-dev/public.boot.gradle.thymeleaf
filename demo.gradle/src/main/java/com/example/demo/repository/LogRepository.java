package com.example.demo.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.LogVO;

@Repository
public interface LogRepository extends JpaRepository<LogVO, BigDecimal> {

}
