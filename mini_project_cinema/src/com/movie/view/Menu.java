package com.movie.view;

import java.util.List;

import com.movie.controller.ScreeningController;
import com.movie.model.vo.Screening;

public class Menu {
	private ScreeningController screening = new ScreeningController();
	public void movieRank() {
		System.out.println("=-=인기 순위=-= ");
//		List<Screening> list = screening.movieRank();
	}
}
