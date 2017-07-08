package com.ssss.shareInfo.model;

public class Tree {
	private Integer id;
	private Integer pId;
	private String name;
	
	public Tree(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tree [id=" + id + ", pId=" + pId + ", name=" + name + "]";
	}
	
	
}
