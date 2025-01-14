package com.movie.model.service;

import java.sql.Connection;

import com.movie.model.dao.MovieDao;
import com.movie.model.vo.Movie;
import static com.movie.template.JDBCTemplate.*;

public class MovieService {
	
	public int insertMovieOne(Movie movie) {
		Connection conn = getConnection();
		MovieDao md = new MovieDao();
		int result = md.insertMovieOne(movie,conn);
		close(conn);
		return result;
	}


}
