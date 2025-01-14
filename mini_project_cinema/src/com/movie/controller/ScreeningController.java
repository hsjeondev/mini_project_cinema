package com.movie.controller;

import java.util.List;

import com.movie.model.service.ScreeningService;
import com.movie.model.vo.Screening;

public class ScreeningController {
	private ScreeningService screening = new ScreeningService();
	
	public List<Screening> movieRank() {
		return screening.movieRank();
	}
}
