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
@Table(name="file_tb")
public class FileVO {
	
	@Id
	@Column
	private BigDecimal fileMasterId;
	@Column
	private BigDecimal fileId;
	@Column
	private BigDecimal fileSn;
	@Column
	private String orgFileName;
	@Column
	private String fileName;
	@Column
	private String filePath;
	@Column
	private Date registDate = new Date();
	@Column
	private java.math.BigDecimal fileSize;
	
	public FileVO() {}

	@Builder
	public FileVO(BigDecimal fileMasterId, BigDecimal fileId, BigDecimal fileSn, String fileName, String filePath,
			Date registDate, BigDecimal fileSize, String orgFileName) {
		this.fileMasterId = fileMasterId;
		this.fileId = fileId;
		this.fileSn = fileSn;
		this.orgFileName = orgFileName;
		this.fileName = fileName;
		this.filePath = filePath;
		this.registDate = registDate;
		this.fileSize = fileSize;
	}

	public BigDecimal getFileMasterId() {
		return fileMasterId;
	}

	public void setFileMasterId(BigDecimal fileMasterId) {
		this.fileMasterId = fileMasterId;
	}

	public BigDecimal getFileId() {
		return fileId;
	}

	public void setFileId(BigDecimal fileId) {
		this.fileId = fileId;
	}

	public BigDecimal getFileSn() {
		return fileSn;
	}

	public void setFileSn(BigDecimal fileSn) {
		this.fileSn = fileSn;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public BigDecimal getFileSize() {
		return fileSize;
	}

	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	
}
