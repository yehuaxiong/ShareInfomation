package com.ssss.shareInfo.model;

/**
 * Receivenotice entity. @author MyEclipse Persistence Tools
 */

public class Receivenotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Notice notice;
	private Integer receiver;
	private Boolean readSign;
	private Boolean deleteSign;

	// Constructors

	/** default constructor */
	public Receivenotice() {
	}

	/** full constructor */
	public Receivenotice(Notice notice, Integer receiver, Boolean readSign,
			Boolean deleteSign) {
		this.notice = notice;
		this.receiver = receiver;
		this.readSign = readSign;
		this.deleteSign = deleteSign;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Notice getNotice() {
		return this.notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Integer getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	public Boolean getReadSign() {
		return this.readSign;
	}

	public void setReadSign(Boolean readSign) {
		this.readSign = readSign;
	}

	public Boolean getDeleteSign() {
		return this.deleteSign;
	}

	public void setDeleteSign(Boolean deleteSign) {
		this.deleteSign = deleteSign;
	}

}