package com.movie.controller;

import java.util.List;

import com.movie.model.service.TheaterService;
import com.movie.model.vo.Theater;

public class TheaterController {
	
	public int insertScreeningOne(int no ,int seat) {
		Theater tr = new Theater(no,seat);
		TheaterService ts = new TheaterService();
		int result = ts.insertScreeningOne(tr);
		return result;
	}
	public List<Theater> insertMovieInformation(){
		TheaterService ts = new TheaterService();
		return ts.insertMovieInformation();
	}
}
