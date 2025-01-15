package com.movie.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.movie.model.vo.Reservation;

public class ReservationDao {

	public List<Reservation> checkReservation(int userNo, Connection conn) {
		List<Reservation> list = new ArrayList();
		
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
		
		return list;
	}
}
