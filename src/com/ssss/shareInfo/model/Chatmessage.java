package com.ssss.shareInfo.model;

import java.sql.Time;

/**
 * Chatmessage entity. @author MyEclipse Persistence Tools
 */

public class Chatmessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer receiveId;
	private String sendName;
	private Integer sendId;
	private String content;
	private Boolean readedSign;
	private Time time;

	// Constructors

	/** default constructor */
	public Chatmessage() {
	}

	/** full constructor */
	public Chatmessage(Integer receiveId, String sendName, Integer sendId,
			String content, Boolean readedSign, Time time) {
		this.receiveId = receiveId;
		this.sendName = sendName;
		this.sendId = sendId;
		this.content = content;
		this.readedSign = readedSign;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReceiveId() {
		return this.receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	public String getSendName() {
		return this.sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public Integer getSendId() {
		return this.sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getReadedSign() {
		return this.readedSign;
	}

	public void setReadedSign(Boolean readedSign) {
		this.readedSign = readedSign;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}