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
@Table(name="prototype_widget_tb")
public class WidgetVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column	
	private java.math.BigDecimal widgetId;
	
	@Column
	private String prototypeId;
	
	@Column	
	private String widgetText;
	
	@Column
	private String widgetLabelType;
	
	@Column
	private java.util.Date createDatetime = new Date();
	
	@Column
	private java.util.Date lastUpdateDatetime = new Date();

	public WidgetVO() {}
	
	@Builder
	public WidgetVO(BigDecimal widgetId, String prototypeId, String widgetText, String widgetLabelType,
			Date createDatetime, Date lastUpdateDatetime) {
		this.widgetId = widgetId;
		this.prototypeId = prototypeId;
		this.widgetText = widgetText;
		this.widgetLabelType = widgetLabelType;
		this.createDatetime = createDatetime;
		this.lastUpdateDatetime = lastUpdateDatetime;
	}

	public java.math.BigDecimal getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(java.math.BigDecimal widgetId) {
		this.widgetId = widgetId;
	}

	public String getPrototypeId() {
		return prototypeId;
	}

	public void setPrototypeId(String prototypeId) {
		this.prototypeId = prototypeId;
	}

	public String getWidgetText() {
		return widgetText;
	}

	public void setWidgetText(String widgetText) {
		this.widgetText = widgetText;
	}

	public String getWidgetLabelType() {
		return widgetLabelType;
	}

	public void setWidgetLabelType(String widgetLabelType) {
		this.widgetLabelType = widgetLabelType;
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
