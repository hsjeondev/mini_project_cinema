package com.movie.model.service;

import java.sql.Connection;
import java.util.List;
import static com.movie.template.JDBCTemplate.*;
import com.movie.model.dao.ScreeningDao;
import com.movie.model.vo.Screening;

public class ScreeningService {
	private ScreeningDao screening=new ScreeningDao();
			
	public List<Screening> movieRank() {
		Connection coon = getConnection();
		List<Screening> list = screening.movieRank(coon);
		close(coon);
		return list;
	}

}