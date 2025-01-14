package com.movie.model.service;

import java.sql.Connection;

import com.movie.model.dao.MovieDao;
import com.movie.model.vo.Movie;

public class MovieService {
	
	public int insertMovieOne(Movie movie) {
		Connection conn = getConnection();
		int result = MovieDao.insertMovieOne(movie,conn);
		close(conn);
		return result;
	}


}
