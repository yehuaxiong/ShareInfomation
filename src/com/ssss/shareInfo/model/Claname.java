package com.ssss.shareInfo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Claname entity. @author MyEclipse Persistence Tools
 */

public class Claname implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Specialty specialty;
	private String cname;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Claname() {
	}

	/** minimal constructor */
	public Claname(Integer cid, Specialty specialty, String cname) {
		this.cid = cid;
		this.specialty = specialty;
		this.cname = cname;
	}

	/** full constructor */
	public Claname(Integer cid, Specialty specialty, String cname, Set students) {
		this.cid = cid;
		this.specialty = specialty;
		this.cname = cname;
		this.students = students;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Specialty getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}