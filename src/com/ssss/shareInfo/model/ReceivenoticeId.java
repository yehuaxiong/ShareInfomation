package com.ssss.shareInfo.model;

/**
 * ReceivenoticeId entity. @author MyEclipse Persistence Tools
 */

public class ReceivenoticeId implements java.io.Serializable {

	// Fields

	private Integer noticeId;
	private Integer receiver;
	private Boolean readSign;
	private Boolean deleteSign;

	// Constructors

	/** default constructor */
	public ReceivenoticeId() {
	}

	/** full constructor */
	public ReceivenoticeId(Integer noticeId, Integer receiver,
			Boolean readSign, Boolean deleteSign) {
		this.noticeId = noticeId;
		this.receiver = receiver;
		this.readSign = readSign;
		this.deleteSign = deleteSign;
	}

	// Property accessors

	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	public Boolean getReadSign() {
		return this.readSign;
	}

	public void setReadSign(Boolean readSign) {
		this.readSign = readSign;
	}

	public Boolean getDeleteSign() {
		return this.deleteSign;
	}

	public void setDeleteSign(Boolean deleteSign) {
		this.deleteSign = deleteSign;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReceivenoticeId))
			return false;
		ReceivenoticeId castOther = (ReceivenoticeId) other;

		return ((this.getNoticeId() == castOther.getNoticeId()) || (this
				.getNoticeId() != null && castOther.getNoticeId() != null && this
				.getNoticeId().equals(castOther.getNoticeId())))
				&& ((this.getReceiver() == castOther.getReceiver()) || (this
						.getReceiver() != null
						&& castOther.getReceiver() != null && this
						.getReceiver().equals(castOther.getReceiver())))
				&& ((this.getReadSign() == castOther.getReadSign()) || (this
						.getReadSign() != null
						&& castOther.getReadSign() != null && this
						.getReadSign().equals(castOther.getReadSign())))
				&& ((this.getDeleteSign() == castOther.getDeleteSign()) || (this
						.getDeleteSign() != null
						&& castOther.getDeleteSign() != null && this
						.getDeleteSign().equals(castOther.getDeleteSign())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNoticeId() == null ? 0 : this.getNoticeId().hashCode());
		result = 37 * result
				+ (getReceiver() == null ? 0 : this.getReceiver().hashCode());
		result = 37 * result
				+ (getReadSign() == null ? 0 : this.getReadSign().hashCode());
		result = 37
				* result
				+ (getDeleteSign() == null ? 0 : this.getDeleteSign()
						.hashCode());
		return result;
	}

}