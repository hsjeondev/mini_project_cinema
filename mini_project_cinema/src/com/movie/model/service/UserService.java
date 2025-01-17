package com.movie.model.service;

import static com.movie.template.JDBCTemplate.close;
import static com.movie.template.JDBCTemplate.getConnection;

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

	public int chargeAmount(int amount, int userNo) {
		Connection conn = getConnection();
		UserDao ud = new UserDao();
		int result = ud.chargeAmount(amount,userNo,conn);
		close(conn);
		return result;
	}

	public int isDuplicateNumber(String phone) {
		Connection conn = getConnection();
		int result = ud.isDuplicateNumber(phone,conn);
		close(conn);
		return result;
	}

	public int updateUserOne(User u) {
		Connection conn = getConnection();
		int result = ud.updateUserOne(u,conn);
		close(conn);
		return result;
	}

	public int deleteMember(User user) {
		Connection conn = getConnection();
		int result = ud.deleteMember(user,conn);
		close(conn);
		return result;
	}

}
