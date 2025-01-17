package com.movie.model.service;

import static com.movie.template.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.movie.model.dao.TheaterDao;
import com.movie.model.vo.Movie;
import com.movie.model.vo.Theater;

public class TheaterService {

	public int insertScreeningOne(Theater tr) {
		Connection conn = getConnection();
		TheaterDao td = new TheaterDao();
		int result = td.insertScreeningOne(tr,conn);
		close(conn);
		return result;
	}
	
	public List<Theater> insertMovieInformation(){
		Connection conn = getConnection();
		TheaterDao td = new TheaterDao();
		List<Theater> list = td.insertMovieInformation(conn);
		close(conn);
		return list;
	}
}
