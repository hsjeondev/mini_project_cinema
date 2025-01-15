package com.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static com.movie.template.JDBCTemplate.*;
import com.movie.model.vo.Theater;

public class TheaterDao {
	
	public int insertScreeningOne(Theater tr, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO theater (theater_no,totle_seats) "
					+ "VALUES(?,?)";  
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tr.getTheaterNo());
			pstmt.setInt(2, tr.getTotleSeats());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			result = 0;
		}finally {
			close(pstmt);
		}
		return result;
	}
}
