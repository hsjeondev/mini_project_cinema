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

}
