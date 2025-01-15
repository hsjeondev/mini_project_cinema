package com.movie.model.dao;

import static com.movie.template.JDBCTemplate.close;

import java.sql.*;
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
	public int ChargeAmount(int amount, int userNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE user SET chargeamount = (chargeamount + ?) "
						+ "WHERE user_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			result = 0;
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
}
