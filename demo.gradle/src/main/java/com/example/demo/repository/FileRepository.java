package com.example.demo.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.FileMasterVO;
import com.example.demo.domain.FileVO;

@Repository
public interface FileRepository extends JpaRepository<FileVO, BigDecimal> {

	FileVO findByFileMasterId(BigDecimal fileMasterId);

}
