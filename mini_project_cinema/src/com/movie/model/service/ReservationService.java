package com.movie.model.service;

import static com.movie.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.movie.model.dao.ReservationDao;
import com.movie.model.vo.Reservation;

public class ReservationService {
	private ReservationDao rd = new ReservationDao();

	public List<Reservation> checkReservation(int userNo) {
		Connection conn = getConnection();
		List<Reservation> list = rd.checkReservation(userNo, conn);
		return list;
	}
}
