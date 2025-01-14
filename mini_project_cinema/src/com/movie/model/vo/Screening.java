package com.movie.model.vo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Screening {
	private int screeningNumber;
	private LocalDate airingDate;
	private LocalTime airingTime;
	private int movieNumber;
	private int theater;
	private int Seat;
	
	public Screening() {}

	public Screening(int screeningNumber, LocalDate airingDate, LocalTime airingTime, int movieNumber, int theater, int seat) {
		this.screeningNumber = screeningNumber;
		this.airingDate = airingDate;
		this.airingTime = airingTime;
		this.movieNumber = movieNumber;
		this.theater = theater;
		this.Seat = seat;
	}

	public int getScreeningNumber() {
		return screeningNumber;
	}

	public void setScreeningNumber(int screeningNumber) {
		this.screeningNumber = screeningNumber;
	}

	public LocalDate getAiringDate() {
		return airingDate;
	}

	public void setAiringDate(LocalDate airingDate) {
		this.airingDate = airingDate;
	}

	public LocalTime getAiringTime() {
		return airingTime;
	}

	public void setAiringTime(LocalTime airingTime) {
		this.airingTime = airingTime;
	}

	public int getMovieNumber() {
		return movieNumber;
	}

	public void setMovieNumber(int movieNumber) {
		this.movieNumber = movieNumber;
	}

	public int getTheater() {
		return theater;
	}

	public void setTheater(int theater) {
		this.theater = theater;
	}

	public int getSeat() {
		return Seat;
	}

	public void setSeat(int seat) {
		Seat = seat;
	}
	
	
	
	// 제목
	// 조회순
	
	// 영화 제목 선택하면 
	// 날짜, 상영관 확인 
	// 날짜와 상영관 선택하면 시간 선택
	
	
}
