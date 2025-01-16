package com.movie.model.service;

import static com.movie.template.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.movie.model.dao.ReservationDao;
import com.movie.model.vo.Reservation;

public class ReservationService {
	private ReservationDao rd = new ReservationDao();

	public List<Map<String, Object>> checkReservation(int userNo) {
		Connection conn = getConnection();
		List<Map<String, Object>> list = rd.checkReservation(userNo, conn);
		close(conn);
		return list;
	}
	
	public int cancleReservation(int deleteNo) {
		Connection conn = getConnection();
		int result = rd.cancleReservation(deleteNo, conn);
		return result;
	}
}
