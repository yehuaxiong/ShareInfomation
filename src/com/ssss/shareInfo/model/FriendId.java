package com.ssss.shareInfo.model;

/**
 * FriendId entity. @author MyEclipse Persistence Tools
 */

public class FriendId implements java.io.Serializable {

	// Fields

	private Integer myId;
	private Integer friendId;

	// Constructors

	/** default constructor */
	public FriendId() {
	}

	/** full constructor */
	public FriendId(Integer myId, Integer friendId) {
		this.myId = myId;
		this.friendId = friendId;
	}

	// Property accessors

	public Integer getMyId() {
		return this.myId;
	}

	public void setMyId(Integer myId) {
		this.myId = myId;
	}

	public Integer getFriendId() {
		return this.friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FriendId))
			return false;
		FriendId castOther = (FriendId) other;

		return ((this.getMyId() == castOther.getMyId()) || (this.getMyId() != null
				&& castOther.getMyId() != null && this.getMyId().equals(
				castOther.getMyId())))
				&& ((this.getFriendId() == castOther.getFriendId()) || (this
						.getFriendId() != null
						&& castOther.getFriendId() != null && this
						.getFriendId().equals(castOther.getFriendId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMyId() == null ? 0 : this.getMyId().hashCode());
		result = 37 * result
				+ (getFriendId() == null ? 0 : this.getFriendId().hashCode());
		return result;
	}

}