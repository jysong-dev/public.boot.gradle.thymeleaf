package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.WidgetVO;

@Repository
public interface WidgetRepository extends JpaRepository<WidgetVO, BigDecimal> {

	List<WidgetVO> findByPrototypeId(String prototypeId);

}
