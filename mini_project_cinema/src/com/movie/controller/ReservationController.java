package com.movie.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.movie.model.service.ReservationService;
import com.movie.model.vo.Reservation;

public class ReservationController {
	private ReservationService rs = new ReservationService();

	public List<Map<String, Object>> checkReservation(int userNo) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = rs.checkReservation(userNo);
		return list;
	}
	
	public int cancleReservation(int deleteNo) {
		int result = rs.cancleReservation(deleteNo);
		return 0;
	}
}
