package com.movie.controller;

import com.movie.model.service.UserService;
import com.movie.model.vo.User;

public class UserController {
	private UserService us = new UserService();

	public User login(String id, String pw) {
		User user = us.login(id, pw);
		return user;
	}
}
