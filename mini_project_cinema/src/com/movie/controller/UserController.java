package com.movie.controller;

import com.movie.model.service.UserService;
import com.movie.model.vo.User;


public class UserController {

//	private UserService service = new UserService();
	private UserService us = new UserService();
	
	public int signInMember(String id,String pw, String name,String phone) {
		User u = new User(id,pw,name,phone);
		int result = us.signInMember(u);
		return result;
	}
	
	public int isDuplicateMember(String id) {
		int result = us.isDuplicateMember(id);
		return result;
	}
	
	public User login(String id, String pw) {
		User user = us.login(id, pw);
		return user;
	}


	public int chargeAmount(int amount, int userNo) {
		UserService uv = new UserService();
		int result = uv.chargeAmount(amount,userNo);
		return result;
	}

	public int isDuplicateNumber(String phone) {
		int result = us.isDuplicateNumber(phone);
		return result;
	}

	public int updateUserOne(String newPw, String name, String phone, int userNo) {
		User u = new User(newPw,name,phone,userNo);
		int result = us.updateUserOne(u);
		return result;
	}


}
