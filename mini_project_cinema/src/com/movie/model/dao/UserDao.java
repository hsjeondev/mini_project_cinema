package com.movie.model.dao;




import java.sql.Connection;
import java.sql.ResultSet;
import static com.movie.template.JDBCTemplate.close;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.LocalDateTime;
import com.movie.model.vo.User;

public class UserDao {
	
	public int signInMember(User u, Connection conn) {
		PreparedStatement pstmt = null;
		int result =0;
		
		try {
			String sql="INSERT INTO `user`(user_id,`user_pw`,`user_name`,`user_phone`)"
					+ "VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,u.getUserId());
			pstmt.setString(2,u.getUserPw());
			pstmt.setString(3,u.getUserName());
			pstmt.setString(4,u.getUserPhone());
			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int isDuplicateMember(String id, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			String sql="SELECT COUNT(*) FROM `user` WHERE user_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs =pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

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
