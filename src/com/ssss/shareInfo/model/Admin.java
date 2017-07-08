package com.ssss.shareInfo.model;

import javax.persistence.Entity;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

@Entity
public class Admin{

	private Integer id;
	private String name;
	private String password;
	private String phone;
	private String email;

	public Admin() {
	}

	public Admin(Integer id) {
		this.id = id;
	}

	public Admin(Integer id, String name, String password, String phone,
			String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
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

}