package com.movie.model.dao;

import static com.movie.template.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movie.model.vo.Movie;
import com.movie.model.vo.Screening;
import com.movie.model.vo.Theater;
public class ScreeningDao {
	
	public List<Movie> movieRank(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList<Movie>();
		try {
			String sql = "SELECT * "
					+ "FROM movie";
//					+ "FROM screening sc "
//					+ "JOIN movie m "
//					+ "ON sc.movie_no=m.movie_no "
//					+ "ORDER BY m.movie_views DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Movie mo = new Movie();
				mo.setMovieNo(rs.getInt("movie_no"));
				mo.setMovieTitle(rs.getString("movie_title"));
				mo.setRunningTime(rs.getInt("runningtime"));
				mo.setStartDate(rs.getString("start_date"));
				mo.setEndDate(rs.getString("end_date"));
				mo.setMovieViews(rs.getInt("movie_views"));
				mo.setMoviePrice(rs.getInt("movie_price"));
				list.add(mo);
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
	
	public int insertMovieInformation(Connection conn,Screening sn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO screening (movie_no,theater_no,screening_date,screening_time) "
					+ "VALUES(?,?,STR_TO_DATE(?,'%Y-%m-%d'),STR_TO_DATE(?,'%H:%i:%s'))	";  
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sn.getMovieNumber());
			pstmt.setInt(2, sn.getTheater());
			pstmt.setString(3, sn.getAiringDate());
			pstmt.setString(4, sn.getAiringTime());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			result = 0;
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/*public List<Screening> ticketReservation(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Screening> list = new ArrayList<Screening>();
		try {
			String sql = "SELECT * "
					+ "FROM screening";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Screening scr = new Screening();
				scr.setScreeningNumber(rs.getInt("screening_no"));
				scr.setAiringDate(rs.getString("screening_date"));
				scr.setAiringTime(rs.getString("screening_time"));
				scr.setMovieNumber(rs.getInt("movie_no"));
				scr.setTheater(rs.getInt("theater_no"));
				scr.setSeat(rs.getInt("remain_seats"));
				list.add(scr);
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
	}*/
	
	public List<Screening> ticketReservation(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Screening> list = new ArrayList<Screening>();
		try {
			String sql = "SELECT s.theater_no, m.movie_title ,m.movie_price ,t.totle_seats "
					+ "FROM screening s "
					+ "JOIN movie m "
					+ "ON m.movie_no=s.movie_no "
					+ "JOIN theater t "
					+ "on s.theater_no=t.theater_no "
					+ "";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			/*while(rs.next()) {
				Screening scr = new Screening();
				scr.setScreeningNumber(rs.getInt("screening_no"));
				scr.setAiringDate(rs.getString("screening_date"));
				scr.setAiringTime(rs.getString("screening_time"));
				scr.setMovieNumber(rs.getInt("movie_no"));
				scr.setTheater(rs.getInt("theater_no"));
				scr.setSeat(rs.getInt("remain_seats"));
				list.add(scr);
			}*/
			
			while(rs.next()) {
				Screening s = new Screening();
				Movie m = new Movie();
				Theater t = new Theater();
				s.setMovieNumber(rs.getInt("theater_no"));
				s.setMovieName(rs.getString("movie_title"));
				s.setMoviePrice(rs.getInt("movie_price"));
				s.setSeat(rs.getInt("totle_seats"));
				list.add(s);
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
	
	public int Purchase(Connection conn,int theaterNo) {
		return 0;
}
}
	

