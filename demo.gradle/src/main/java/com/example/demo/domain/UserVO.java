package com.example.demo.domain;

public class UserVO {
	
	private java.math.BigDecimal userKey;
	private String userId;
	private String username;
	private String password;
	private java.util.Date registDatetime;
	private java.util.Date lastLoginDatetime;
	private String authority;
	
	public java.math.BigDecimal getUserKey() {
		return userKey;
	}
	public void setUserKey(java.math.BigDecimal userKey) {
		this.userKey = userKey;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public java.util.Date getRegistDatetime() {
		return registDatetime;
	}
	public void setRegistDatetime(java.util.Date registDatetime) {
		this.registDatetime = registDatetime;
	}
	public java.util.Date getLastLoginDatetime() {
		return lastLoginDatetime;
	}
	public void setLastLoginDatetime(java.util.Date lastLoginDatetime) {
		this.lastLoginDatetime = lastLoginDatetime;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
