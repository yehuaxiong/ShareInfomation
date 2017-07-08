package com.ssss.shareInfo.model;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class TeacherShow implements java.io.Serializable {

	// Fields

	private Integer id;
	private String office;
	private String department;
	private String name;
	private String sex;
	private String password;
	private String phone;
	private String email;
	private String title;
	private String politicalStatus;
	private Boolean deletedSign;
	private String image;

	// Constructors

	/** default constructor */
	public TeacherShow() {
	}

	/** minimal constructor */
	public TeacherShow(Integer id) {
		this.id = id;
	}

	

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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