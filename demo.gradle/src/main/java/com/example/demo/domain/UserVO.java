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
@Table(name="user_tb")
public class UserVO {
	
	@Id
	@Column	
	private java.math.BigDecimal userKey;
	
	@Column
	private String userId;
	
	@Column	
	private String username;
	
	@Column
	private String password;
	
	@Column(updatable = false)
	private java.util.Date registDatetime = new Date();
	
	@Column
	private java.util.Date lastLoginDatetime = new Date();
	
	@Column
	private String authority;
	
	@Column
	private java.math.BigDecimal fileMasterId;
	
	@Column
	private String userBio;

	public UserVO() {}

	@Builder
	public UserVO(BigDecimal userKey, String userId, String username, String password, Date registDatetime,
			Date lastLoginDatetime, String authority, BigDecimal fileMasterId, String userBio) {
		super();
		this.userKey = userKey;
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.registDatetime = registDatetime;
		this.lastLoginDatetime = lastLoginDatetime;
		this.authority = authority;
		this.fileMasterId = fileMasterId;
		this.userBio = userBio;
	}

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

	public java.math.BigDecimal getFileMasterId() {
		return fileMasterId;
	}

	public void setFileMasterId(java.math.BigDecimal fileMasterId) {
		this.fileMasterId = fileMasterId;
	}

	public String getUserBio() {
		return userBio;
	}

	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}

}
