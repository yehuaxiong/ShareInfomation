package com.ssss.shareInfo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer did;
	private String dname;
	private Integer pid;
	private Set specialties = new HashSet(0);
	private Set offices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Integer did, String dname, Integer pid) {
		this.did = did;
		this.dname = dname;
		this.pid = pid;
	}

	/** full constructor */
	public Department(Integer did, String dname, Integer pid, Set specialties) {
		this.did = did;
		this.dname = dname;
		this.pid = pid;
		this.specialties = specialties;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Set getSpecialties() {
		return this.specialties;
	}

	public void setSpecialties(Set specialties) {
		this.specialties = specialties;
	}

	public Set getOffices() {
		return offices;
	}

	public void setOffices(Set offices) {
		this.offices = offices;
	}

}