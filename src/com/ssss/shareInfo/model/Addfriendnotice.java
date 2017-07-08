package com.ssss.shareInfo.model;

import java.sql.Timestamp;

/**
 * Addfriendnotice entity. @author MyEclipse Persistence Tools
 */

public class Addfriendnotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Boolean deletedSign;
	private Integer receiveId;
	private Integer sendId;
	private String content;
	private String sendName;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Addfriendnotice() {
	}

	/** full constructor */
	public Addfriendnotice(Boolean deletedSign, Integer receiveId,
			Integer sendId, String content, String sendName, Timestamp time) {
		this.deletedSign = deletedSign;
		this.receiveId = receiveId;
		this.sendId = sendId;
		this.content = content;
		this.sendName = sendName;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDeletedSign() {
		return this.deletedSign;
	}

	public void setDeletedSign(Boolean deletedSign) {
		this.deletedSign = deletedSign;
	}

	public Integer getReceiveId() {
		return this.receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
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

	public String getSendName() {
		return this.sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}