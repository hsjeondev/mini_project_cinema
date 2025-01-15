package com.movie.controller;

import java.util.ArrayList;
import java.util.List;

import com.movie.model.service.ReservationService;
import com.movie.model.vo.Reservation;

public class ReservationController {
	private ReservationService rs = new ReservationService();

	public List<Reservation> checkReservation(int userNo) {
		List<Reservation> list = new ArrayList<Reservation>();
		list = rs.checkReservation(userNo);
		return list;
	}
}
