package com.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.movie.template.JDBCTemplate.close;

public class ReservationDao {
	
	public int cancleReservation(int deleteNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = " DELETE FROM reservation "
					+ " WHERE reservation_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deleteNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			result = 0;
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Map<String, Object>> checkReservation(int userNo, Connection conn) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT r.reservation_no AS reservationNo, m.movie_title AS title, t.theater_no AS theaterNo, s.screening_date AS date, s.screening_time AS time "
				+ " FROM reservation r "
				+ " JOIN user u "
				+ " ON r.user_no = u.user_no "
				+ " JOIN screening s "
				+ " ON r.screening_no = s.screening_no "
				+ " JOIN movie m "
				+ " ON s.movie_no = m.movie_no "
				+ " JOIN theater t "
				+ " ON s.theater_no = t.theater_no "
				+ " WHERE r.user_no = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				int reservationNo = rs.getInt("reservationNo");
				String title = rs.getString("title");
				int theaterNo = rs.getInt("theaterNo");
				DateTimeFormatter dateDtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
				DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("a hh시 mm분");
				String date = rs.getTimestamp("date").toLocalDateTime().format(dateDtf);
				String time = rs.getTimestamp("time").toLocalDateTime().format(timeDtf);
				map.put("reservationNo", reservationNo);
				map.put("title", title);
				map.put("theaterNo", theaterNo);
				map.put("date", date);
				map.put("time", time);
				list.add(map);
			}
		} catch(SQLException e) {
			list = null;
		} finally {
			close(rs, pstmt);
		}

		return list;
	}
}
