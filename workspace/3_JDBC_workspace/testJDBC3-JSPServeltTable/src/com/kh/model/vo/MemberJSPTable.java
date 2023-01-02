package com.kh.model.vo;

import java.sql.Date;

public class MemberJSPTable {

	private String userId;
	private String userPwd;
	private String userName;
	private String nickname;
	private String phone;
	private String email;
	private String address;
	private String interest;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	public MemberJSPTable() {}
	
	public MemberJSPTable(String userId, String userPwd, String userName, String nickname, String phone, String email,
			String address, String interest, Date enrollDate, Date modifyDate, String status) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	
	public MemberJSPTable(String userId, String userPwd, String userName, String nickname, String phone,
			String email, String address, String interest,Date enrollDate) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
		this.enrollDate = enrollDate;
	}
	
	public MemberJSPTable(String userId, String userPwd, String userName, String nickname, String phone,
			String email, String address, String interest) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	@Override
	public String toString() {
		return userId+" / "+userPwd+" / "+userName+" / "+nickname+" / "+phone+" / "+email+" / "+address+" / "+interest+" / "+enrollDate+" / "+
				modifyDate+" / "+status;
	}
}












