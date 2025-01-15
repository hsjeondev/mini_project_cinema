package com.movie.model.service;

import static com.movie.template.JDBCTemplate.*;

import java.sql.Connection;

import com.movie.model.dao.UserDao;
import com.movie.model.vo.User;

public class UserService {
	private UserDao ud = new UserDao();
	
	public int signInMember(User u) {
		Connection conn = getConnection();
		int result = ud.signInMember(u, conn);
		close(conn);
		return result;
	}
	
	public int isDuplicateMember(String id) {
		Connection conn = getConnection();
		int cnt = ud.isDuplicateMember(id,conn);
		close(conn);
		return cnt;
	}
	
	public User login(String id, String pw) {
		Connection conn = getConnection();
		User user = ud.login(id, pw, conn);
		close(conn);
		
		return user;
	}

}
