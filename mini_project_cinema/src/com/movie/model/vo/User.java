package com.movie.model.vo;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private int userPhone;
	
	public User() {}

	public User(String userId, String userPw, String userName, int userPhone) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
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

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "User [아이디=" + userId 
				+ ", 비밀번호=" + userPw 
				+ ", 이름=" + userName 
				+ ", 전화번호=" + userPhone + "]";
	}
	
	
	
	
	
}
