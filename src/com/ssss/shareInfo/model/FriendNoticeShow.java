package com.ssss.shareInfo.model;

import java.sql.Timestamp;

/**
 * Addfriendnotice entity. @author MyEclipse Persistence Tools
 */

public class FriendNoticeShow implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer receiveId;
	private Integer sendId;
	private String content;
	private String sendName;
	private String time;
	private Boolean deletedSign;

	// Constructors

	/** default constructor */
	public FriendNoticeShow() {
	}

	/** full constructor */
	public FriendNoticeShow(Integer receiveId, Integer sendId, String content,
			String sendName, String time, Boolean deletedSign) {
		this.receiveId = receiveId;
		this.sendId = sendId;
		this.content = content;
		this.sendName = sendName;
		this.time = time;
		this.deletedSign = deletedSign;
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

	public Boolean getDeletedSign() {
		return this.deletedSign;
	}

	public void setDeletedSign(Boolean deletedSign) {
		this.deletedSign = deletedSign;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}