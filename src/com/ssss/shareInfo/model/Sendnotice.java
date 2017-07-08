package com.ssss.shareInfo.model;

/**
 * Sendnotice entity. @author MyEclipse Persistence Tools
 */

public class Sendnotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Notice notice;
	private Integer sender;
	private Integer readedNumber;
	private Boolean deleteSign;

	// Constructors

	/** default constructor */
	public Sendnotice() {
	}

	/** full constructor */
	public Sendnotice(Notice notice, Integer sender, Integer readedNumber,
			Boolean deleteSign) {
		this.notice = notice;
		this.sender = sender;
		this.readedNumber = readedNumber;
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

	public Integer getSender() {
		return this.sender;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}

	public Integer getReadedNumber() {
		return this.readedNumber;
	}

	public void setReadedNumber(Integer readedNumber) {
		this.readedNumber = readedNumber;
	}

	public Boolean getDeleteSign() {
		return this.deleteSign;
	}

	public void setDeleteSign(Boolean deleteSign) {
		this.deleteSign = deleteSign;
	}

}