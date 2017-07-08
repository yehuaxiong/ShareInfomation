package com.ssss.shareInfo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Specialty entity. @author MyEclipse Persistence Tools
 */

public class Specialty implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Department department;
	private String sname;
	private Set clanames = new HashSet(0);

	// Constructors

	/** default constructor */
	public Specialty() {
	}

	/** minimal constructor */
	public Specialty(Integer sid, Department department, String sname) {
		this.sid = sid;
		this.department = department;
		this.sname = sname;
	}

	/** full constructor */
	public Specialty(Integer sid, Department department, String sname,
			Set clanames) {
		this.sid = sid;
		this.department = department;
		this.sname = sname;
		this.clanames = clanames;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set getClanames() {
		return this.clanames;
	}

	public void setClanames(Set clanames) {
		this.clanames = clanames;
	}

}