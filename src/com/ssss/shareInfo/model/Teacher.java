package com.ssss.shareInfo.model;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private Office office;
	private String name;
	private String sex;
	private String password;
	private String phone;
	private String email;
	private String title;
	private String politicalStatus;
	private Boolean deletedSign;
	private String image;
	private String department;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Teacher(Integer id, Office office, String name, String sex,
			String password, String phone, String email, String title,
			String politicalStatus, Boolean deletedSign, String image,
			String department) {
		this.id = id;
		this.office = office;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.title = title;
		this.politicalStatus = politicalStatus;
		this.deletedSign = deletedSign;
		this.image = image;
		this.department = department;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}