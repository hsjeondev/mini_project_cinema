package com.movie.model.service;

import static com.movie.template.JDBCTemplate.*;

import java.sql.Connection;

import com.movie.model.dao.TheaterDao;
import com.movie.model.vo.Theater;

public class TheaterService {

	public int insertScreeningOne(Theater tr) {
		Connection conn = getConnection();
		TheaterDao td = new TheaterDao();
		int result = td.insertScreeningOne(tr,conn);
		close(conn);
		return result;
	}
}
