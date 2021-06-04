package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import groovy.transform.builder.Builder;

@EntityScan
@Entity
@Table(name="log_tb")
public class LogVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column	
	private BigDecimal logId;
	@Column
	private String sessionId;
	@Column
	private String logSeCode;
	@Column
	private Date createDatetime = new Date();
	@Column
	private String userAgent;
	@Column
	private String referer;
	@Column
	private String requesterIp;
	@Transient
	private String visitDay;
	@Transient
	private Integer hits;
	@Transient
	private String browser;
	
	public LogVO() {
		
	}
	
	@Builder
	public LogVO(BigDecimal logId, String sessionId, String logSeCode, Date createDatetime, String userAgent,
			String referer, String requesterIp, String visitDay, Integer hits, String browser) {
		super();
		this.logId = logId;
		this.sessionId = sessionId;
		this.logSeCode = logSeCode;
		this.createDatetime = createDatetime;
		this.userAgent = userAgent;
		this.referer = referer;
		this.requesterIp = requesterIp;
		this.visitDay = visitDay;
		this.hits = hits;
		this.browser = browser;
	}
	
	public BigDecimal getLogId() {
		return logId;
	}
	public void setLogId(BigDecimal logId) {
		this.logId = logId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getLogSeCode() {
		return logSeCode;
	}
	public void setLogSeCode(String logSeCode) {
		this.logSeCode = logSeCode;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getRequesterIp() {
		return requesterIp;
	}
	public void setRequesterIp(String requesterIp) {
		this.requesterIp = requesterIp;
	}
	public String getVisitDay() {
		return visitDay;
	}
	public void setVisitDay(String visitDay) {
		this.visitDay = visitDay;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
}
