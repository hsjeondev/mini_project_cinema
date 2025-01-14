package com.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static com.movie.template.JDBCTemplate.*;
import com.movie.model.vo.Theater;

public class TheaterDao {
	
	public int insertScreeningOne(Theater tr, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "";
			
		}catch(Exception e) {
			result = 0;
		}finally {
			close(pstmt);
		}
		return result;
	}
}
