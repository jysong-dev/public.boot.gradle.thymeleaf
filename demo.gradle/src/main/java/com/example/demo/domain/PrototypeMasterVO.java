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
@Table(name="prototype_master_tb")
public class PrototypeMasterVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column	
	private BigDecimal prototypeId;
	@Column
	private String prototypeVisiblilty;
	@Column
	private BigDecimal userKey;
	@Column
	private java.util.Date createDatetime = new Date();
	@Column
	private java.util.Date lastUpdateDatetime = new Date();
	
	public PrototypeMasterVO() {
	
	}
	
	@Builder
	public PrototypeMasterVO(BigDecimal prototypeId, String prototypeVisiblilty, BigDecimal userKey,
			Date createDatetime, Date lastUpdateDatetime) {
		this.prototypeId = prototypeId;
		this.prototypeVisiblilty = prototypeVisiblilty;
		this.userKey = userKey;
		this.createDatetime = createDatetime;
		this.lastUpdateDatetime = lastUpdateDatetime;
	}

	public BigDecimal getPrototypeId() {
		return prototypeId;
	}

	public void setPrototypeId(BigDecimal prototypeId) {
		this.prototypeId = prototypeId;
	}

	public String getPrototypeVisiblilty() {
		return prototypeVisiblilty;
	}

	public void setPrototypeVisiblilty(String prototypeVisiblilty) {
		this.prototypeVisiblilty = prototypeVisiblilty;
	}

	public BigDecimal getUserKey() {
		return userKey;
	}

	public void setUserKey(BigDecimal userKey) {
		this.userKey = userKey;
	}

	public java.util.Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(java.util.Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public java.util.Date getLastUpdateDatetime() {
		return lastUpdateDatetime;
	}

	public void setLastUpdateDatetime(java.util.Date lastUpdateDatetime) {
		this.lastUpdateDatetime = lastUpdateDatetime;
	}

}
