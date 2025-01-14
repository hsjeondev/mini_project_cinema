package com.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie.model.vo.Screening;

public class ScreeningDao {
	
	public List<Screening> movieRank(Connection coon){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Screening> list = new ArrayList<Screening>();
		
		return list;
	}
}
