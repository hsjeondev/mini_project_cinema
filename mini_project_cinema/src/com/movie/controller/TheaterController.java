package com.movie.controller;

import com.movie.model.service.TheaterService;
import com.movie.model.vo.Theater;

public class TheaterController {
	
	public int insertScreeningOne(int seat) {
		Theater tr = new Theater(seat);
		TheaterService ts = new TheaterService();
		int result = ts.insertScreeningOne(tr);
		return result;
	}
}
