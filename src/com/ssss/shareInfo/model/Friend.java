package com.ssss.shareInfo.model;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */

public class Friend implements java.io.Serializable {

	// Fields

	private FriendId id;
	private String friendName;
	private String friendPname;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** minimal constructor */
	public Friend(FriendId id) {
		this.id = id;
	}

	/** full constructor */
	public Friend(FriendId id, String friendName, String friendPname) {
		this.id = id;
		this.friendName = friendName;
		this.friendPname = friendPname;
	}

	// Property accessors

	public FriendId getId() {
		return this.id;
	}

	public void setId(FriendId id) {
		this.id = id;
	}

	public String getFriendName() {
		return this.friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFriendPname() {
		return this.friendPname;
	}

	public void setFriendPname(String friendPname) {
		this.friendPname = friendPname;
	}

}