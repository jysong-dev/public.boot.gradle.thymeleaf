package com.example.demo.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.FileMasterVO;

@Repository
public interface FileMasterRepository extends JpaRepository<FileMasterVO, BigDecimal> {

}
