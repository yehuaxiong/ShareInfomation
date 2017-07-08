package com.ssss.shareInfo.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sid;
	private String title;
	private String content;
	private Timestamp time;
	private String sname;
	private Boolean deleteSign;
	private Set sendnotices = new HashSet(0);
	private Set receivenotices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** full constructor */
	public Notice(Integer sid, String title, String content, Timestamp time,
			String sname, Boolean deleteSign, Set sendnotices,
			Set receivenotices) {
		this.sid = sid;
		this.title = title;
		this.content = content;
		this.time = time;
		this.sname = sname;
		this.deleteSign = deleteSign;
		this.sendnotices = sendnotices;
		this.receivenotices = receivenotices;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Boolean getDeleteSign() {
		return this.deleteSign;
	}

	public void setDeleteSign(Boolean deleteSign) {
		this.deleteSign = deleteSign;
	}

	public Set getSendnotices() {
		return this.sendnotices;
	}

	public void setSendnotices(Set sendnotices) {
		this.sendnotices = sendnotices;
	}

	public Set getReceivenotices() {
		return this.receivenotices;
	}

	public void setReceivenotices(Set receivenotices) {
		this.receivenotices = receivenotices;
	}

}