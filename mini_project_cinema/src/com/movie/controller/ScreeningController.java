package com.movie.controller;

import java.util.List;

import com.movie.model.service.ScreeningService;
import com.movie.model.vo.Movie;
import com.movie.model.vo.Screening;

public class ScreeningController {
	private ScreeningService screening = new ScreeningService();
	
	public List<Movie> movieRank() {
		return screening.movieRank();
	}
	
	public int insertMovieInformation(int movieNumber,int theater,String startDate,String runningTime) {
		Screening sn = new Screening(movieNumber,theater,startDate,runningTime);
		int result = screening.insertMovieInformation(sn);
		return result;
	}
	public List<Screening> ticketReservation(){
		return screening.ticketReservation();
	}
	public int Purchase(int theaterNo) {
		int result = screening.Purchase(theaterNo);
		return result;
	}
}
