package com.movie.model.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

	public List<Reservation> checkReservation(int userNo, Connection conn) {
		List<Reservation> list = new ArrayList<Reservation>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "";
			pstmt = conn.prepareStatement(null);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return list;
	}
}
