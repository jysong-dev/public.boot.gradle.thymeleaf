package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import groovy.transform.builder.Builder;

@EntityScan
@Entity
@Table(name="file_master_tb")
public class FileMasterVO {
	
	@Id
	@Column
	private BigDecimal fileMasterId;
	
	public FileMasterVO() {}

	@Builder
	public FileMasterVO(BigDecimal fileMasterId, BigDecimal fileId, BigDecimal fileSn, String fileName, String filePath,
			Date registDate, String fileSize) {
		this.fileMasterId = fileMasterId;
	}

	public BigDecimal getFileMasterId() {
		return fileMasterId;
	}

	public void setFileMasterId(BigDecimal fileMasterId) {
		this.fileMasterId = fileMasterId;
	}
	
}
