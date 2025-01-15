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

import com.movie.model.vo.Reservation;

public class ReservationDao {

	public List<Reservation> checkReservation(int userNo, Connection conn) {
		List<Reservation> list = new ArrayList<Reservation>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT m.movie_title AS title, t.theater_no AS theaterNo, s.screening_date AS date, s.screening_time AS time "
				+ " FROM reservation r "
				+ " JOIN user u "
				+ " ON r.user_no = u.user_no "
				+ " JOIN screening s "
				+ " ON r.screening_no = s.screening_no "
				+ " JOIN movie m "
				+ " ON s.movie_no = m.movie_no "
				+ " JOIN theater t "
				+ " ON s.theater_no = t.theater_no "
				+ " WHERE u.user_no = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				String title = rs.getString("title");
				int theaterNo = rs.getInt("theaterNo");
				DateTimeFormatter dateDtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
				DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("a hh시 mm분");
				String date = rs.getTimestamp("date").toLocalDateTime().format(dateDtf);
				String time = rs.getTimestamp("time").toLocalDateTime().format(timeDtf);
				map.put("title", title);
				map.put("theaterNo", theaterNo);
				map.put("date", date);
				map.put("time", time);
				System.out.println("gd");
			}
		} catch(SQLException e) {
			list = null;
		}

		return list;
	}
}
