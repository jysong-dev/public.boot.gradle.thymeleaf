package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.LogVO;
import com.example.demo.domain.UserVO;

@Repository
public interface LogRepository extends JpaRepository<LogVO, BigDecimal> {
	
}
