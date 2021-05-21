package com.example.demo.domain;

public class LogVO {
	
	private String logId;
	private String sessionId;
	private String logSeCode;
	private String createDatetime;
	private String createYear;
	private String createMonth;
	private String createDay;
	private String createHour;
	private String userAgent;
	private String referer;
	private String requesterIp;
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
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
	public String getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getCreateYear() {
		return createYear;
	}
	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}
	public String getCreateMonth() {
		return createMonth;
	}
	public void setCreateMonth(String createMonth) {
		this.createMonth = createMonth;
	}
	public String getCreateDay() {
		return createDay;
	}
	public void setCreateDay(String createDay) {
		this.createDay = createDay;
	}
	public String getCreateHour() {
		return createHour;
	}
	public void setCreateHour(String createHour) {
		this.createHour = createHour;
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

}
