package com.movie.model.vo;

import java.sql.Date;
import java.sql.Time;

public class Screening {
	private int screeningNumber;
	private Date airingDate;
	private Time airingTime;
	private int movieNumber;
	private int theater;
	private int Seat;
	
	public Screening() {
		
	}

	public Screening(int screeningNumber, Date airingDate, Time airingTime, int movieNumber, int theater, int seat) {
		this.screeningNumber = screeningNumber;
		this.airingDate = airingDate;
		this.airingTime = airingTime;
		this.movieNumber = movieNumber;
		this.theater = theater;
		this.Seat = seat;
	}
	
	
	// 제목
	// 조회순
	
	// 영화 제목 선택하면 
	// 날짜, 상영관 확인 
	// 날짜와 상영관 선택하면 시간 선택
	
	
}
