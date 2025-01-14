package com.movie.controller;

import java.util.List;

import com.movie.model.service.ScreeningService;
import com.movie.model.vo.Movie;

public class ScreeningController {
	private ScreeningService screening = new ScreeningService();
	
	public List<Movie> movieRank() {
		return screening.movieRank();
	}
}
