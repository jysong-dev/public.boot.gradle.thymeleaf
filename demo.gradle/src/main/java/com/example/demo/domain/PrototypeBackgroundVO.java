package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import groovy.transform.builder.Builder;

@EntityScan
@Entity
@Table(name="prototype_background_tb")
public class PrototypeBackgroundVO {

	@Column	
	private BigDecimal prototypeId;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private BigDecimal backgroundId;
	@Column
	private BigDecimal fileMasterId;
	@Column
	private java.util.Date registDatetime = new Date();

	public PrototypeBackgroundVO() {
	
	}
	
	@Builder
	public PrototypeBackgroundVO(BigDecimal prototypeId, BigDecimal backgroundId, BigDecimal fileMasterId,
			Date registDatetime) {
		super();
		this.prototypeId = prototypeId;
		this.backgroundId = backgroundId;
		this.fileMasterId = fileMasterId;
		this.registDatetime = registDatetime;
	}

	public BigDecimal getPrototypeId() {
		return prototypeId;
	}

	public void setPrototypeId(BigDecimal prototypeId) {
		this.prototypeId = prototypeId;
	}

	public BigDecimal getBackgroundId() {
		return backgroundId;
	}

	public void setBackgroundId(BigDecimal backgroundId) {
		this.backgroundId = backgroundId;
	}

	public BigDecimal getFileMasterId() {
		return fileMasterId;
	}

	public void setFileMasterId(BigDecimal fileMasterId) {
		this.fileMasterId = fileMasterId;
	}

	public java.util.Date getRegistDatetime() {
		return registDatetime;
	}

	public void setRegistDatetime(java.util.Date registDatetime) {
		this.registDatetime = registDatetime;
	}

}
