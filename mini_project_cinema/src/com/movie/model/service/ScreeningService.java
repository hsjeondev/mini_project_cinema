package com.movie.model.service;

import static com.movie.template.JDBCTemplate.close;
import static com.movie.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.movie.model.dao.ScreeningDao;
import com.movie.model.dao.TheaterDao;
import com.movie.model.vo.Movie;
import com.movie.model.vo.Screening;

public class ScreeningService {
	private ScreeningDao screening=new ScreeningDao();
			
	public List<Movie> movieRank() {
		Connection coon = getConnection();
		List<Movie> list = screening.movieRank(coon);
		close(coon);
		return list;
	}
	
	public int insertMovieInformation(Screening sn) {
		Connection conn = getConnection();
		int result = screening.insertMovieInformation(conn,sn);
		close(conn);
		return result;
	}
	public List<Screening> ticketReservation(){
		Connection coon = getConnection();
		List<Screening> list = screening.ticketReservation(coon);
		close(coon);
		return list;
	}
	public int Purchase(int theaterNo) {
		Connection conn = getConnection();
		int result = screening.Purchase(conn,theaterNo);
		close(conn);
		return result;
	}
}