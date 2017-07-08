package com.ssss.shareInfo.model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private Claname claname;
	private String name;
	private String sex;
	private String password;
	private String phone;
	private String job;
	private String email;
	private String politicalStatus;
	private Boolean deletedSign;
	private String image;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Student(Integer id, Claname claname, String name, String sex,
			String password, String phone, String job, String email,
			String politicalStatus, Boolean deletedSign, String image) {
		this.id = id;
		this.claname = claname;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.phone = phone;
		this.job = job;
		this.email = email;
		this.politicalStatus = politicalStatus;
		this.deletedSign = deletedSign;
		this.image = image;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Claname getClaname() {
		return this.claname;
	}

	public void setClaname(Claname claname) {
		this.claname = claname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public Boolean getDeletedSign() {
		return this.deletedSign;
	}

	public void setDeletedSign(Boolean deletedSign) {
		this.deletedSign = deletedSign;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}