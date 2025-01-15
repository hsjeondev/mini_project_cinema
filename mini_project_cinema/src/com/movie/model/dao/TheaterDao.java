package com.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.movie.template.JDBCTemplate.*;

import com.movie.model.vo.Movie;
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
	
	public List<Theater> insertMovieInformation(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Theater> list = new ArrayList<Theater>();
		try {
			String sql = "SELECT * "
					+ "FROM theater ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Theater th = new Theater();
				th.setTheaterNo(rs.getInt("theater_no"));
				th.setTotleSeats(rs.getInt("totle_seats"));
				list.add(th);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
