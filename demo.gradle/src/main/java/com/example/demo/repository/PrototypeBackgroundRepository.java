package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.PrototypeBackgroundVO;

@Repository
public interface PrototypeBackgroundRepository extends JpaRepository<PrototypeBackgroundVO, BigDecimal>{

	Optional<PrototypeBackgroundVO> findByPrototypeId(BigDecimal prototypeId);
	
}
