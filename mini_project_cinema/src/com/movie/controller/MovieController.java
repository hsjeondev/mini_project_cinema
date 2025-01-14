package com.movie.controller;

import com.movie.model.service.MovieService;
import com.movie.model.vo.Movie;

public class MovieController {
	
	public int insertMovieOne(String movieTitle ,int runningTime,
					String startDate, String endDate ,int moviePrice) {
		Movie movie = new Movie(movieTitle,runningTime,runningTime,startDate,endDate,moviePrice);
		int result = MovieService.insertMovieOne(movie);
		return result;
	}
}
