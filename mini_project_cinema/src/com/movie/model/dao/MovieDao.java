package com.movie.model.dao;

import static com.movie.template.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.movie.model.vo.Movie;

public class MovieDao {
	
	public int insertMovieOne(Movie movie, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO movie (movie_title ,runningtime ,start_date "
					+ ",end_date ,movie_price) "
					+ "VALUES(?,?,STR_TO_DATE(?,'%Y-%m-%d'),STR_TO_DATE(?,'%Y-%m-%d'),?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getMovieTitle());
			pstmt.setInt(2, movie.getRunningTime());
			pstmt.setString(3, movie.getStartDate());
			pstmt.setString(4, movie.getEndDate());
			pstmt.setInt(5, movie.getMoviePrice());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			result = 0;
		}finally {
			close(pstmt);
		}
		return result;
	}

}
