package com.movie.model.dao;

import static com.movie.template.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.movie.model.vo.User;

public class UserDao {

	public User login(String id, String pw, Connection conn) {
		User user = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * "
					+ " FROM `user` "
					+ " WHERE user_id = ? AND user_pw = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int userNo = rs.getInt("user_no");
				String userId = rs.getString("user_id");
				String userPw = rs.getString("user_pw");
				String userName = rs.getString("user_name");
				String userPhone = rs.getString("user_phone");
				LocalDateTime regDate = rs.getTimestamp("reg_date").toLocalDateTime();
				int chargeAmount = rs.getInt("chargeamount");
				user = new User(userNo, userId, userPw, userName, userPhone, regDate, chargeAmount);
			}
		}catch(SQLException e) {
			user = null;
		} finally {
			close(rs, pstmt);
		}
		
		return user;
	}
}
