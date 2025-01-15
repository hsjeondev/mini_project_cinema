package com.movie.model.dao;

import static com.movie.template.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie.model.vo.Movie;
import com.movie.model.vo.Screening;
public class ScreeningDao {
	
	public List<Movie> movieRank(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movie> list = new ArrayList<Movie>();
		try {
			String sql = "SELECT m.movie_title, "
					+ "m.movie_no, "
					+ "    RANK() OVER (ORDER BY m.movie_views DESC) AS rank "
					+ "FROM screening sc "
					+ "RIGHT JOIN movie m "
					+ "ON sc.movie_no=m.movie_no ;";
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
}
