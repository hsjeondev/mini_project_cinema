package com.movie.model.vo;

import java.time.LocalDateTime;

public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private LocalDateTime regDate;
	private int chargeamount;
	
	public User() {}
	
	public User(int chargeamount, int userNo) {
		this.chargeamount = chargeamount;
		this.userNo = userNo;

	public User(String userPw, String userName, String userPhone, int UserNo) {
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userNo = UserNo;
	}
	
	public User(String userId, String userPw, String userName, String userPhone) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	public User(int userNo, String userId, String userPw, String userName, String userPhone, LocalDateTime regDate,
			int chargeamount) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.regDate = regDate;
		this.chargeamount = chargeamount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public int getChargeamount() {
		return chargeamount;
	}

	public void setChargeamount(int chargeamount) {
		this.chargeamount = chargeamount;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", regDate=" + regDate + ", chargeamount=" + chargeamount + "]";
	}

}
