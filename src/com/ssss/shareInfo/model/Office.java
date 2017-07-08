package com.ssss.shareInfo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Office entity. @author MyEclipse Persistence Tools
 */

public class Office implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Department department;
	private String rname;
	private Set teachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Office() {
	}

	/** minimal constructor */
	public Office(Integer rid, Department department, String rname) {
		this.rid = rid;
		this.department = department;
		this.rname = rname;
	}

	/** full constructor */
	public Office(Integer rid, Department department, String rname, Set teachers) {
		this.rid = rid;
		this.department = department;
		this.rname = rname;
		this.teachers = teachers;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

}