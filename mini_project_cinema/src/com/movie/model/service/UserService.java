package com.movie.model.service;

import static com.movie.template.JDBCTemplate.close;
import static com.movie.template.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.movie.model.dao.UserDao;
import com.movie.model.vo.User;

public class UserService {
	private UserDao ud = new UserDao();
	
	public User login(String id, String pw) {
		Connection conn = getConnection();
		User user = ud.login(id, pw, conn);
		close(conn);
		
		return user;
	}
	public int ChargeAmount(int amount, int userNo) {
		Connection conn = getConnection();
		UserDao ud = new UserDao();
		int result = ud.ChargeAmount(amount,userNo,conn);
		close(conn);
		return result;
	}
}
