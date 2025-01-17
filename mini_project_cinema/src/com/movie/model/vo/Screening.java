package com.movie.model.vo;

public class Screening {
	private int screeningNumber;
	private String airingDate;
	private String airingTime;
	private int movieNumber;
	private int theater;
	private int seat;
	
	private String movieName;
	private int moviePrice;
	
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public int getMoviePrice() {
		return moviePrice;
	}
	
	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}
	
	public Screening() {}
	
	public Screening(int movieNumber,String movieName,int moviePrice,int seat) {
		this.movieNumber=movieNumber;
		this.movieName=movieName;
		this.moviePrice=moviePrice;
		this.seat=seat;
	}
	
	public Screening(int movieNumber,int theater,String airingDate,String airingTime) {
		this.movieNumber = movieNumber;
		this.theater = theater;
		this.airingDate = airingDate;
		this.airingTime = airingTime;
	}
	
	
	public Screening(int screeningNumber, String airingDate, String airingTime, int movieNumber, int theater,
			int seat) {
		this.screeningNumber = screeningNumber;
		this.airingDate = airingDate;
		this.airingTime = airingTime;
		this.movieNumber = movieNumber;
		this.theater = theater;
		this.seat = seat;
	}

	public int getScreeningNumber() {
		return screeningNumber;
	}

	public void setScreeningNumber(int screeningNumber) {
		this.screeningNumber = screeningNumber;
	}

	public String getAiringDate() {
		return airingDate;
	}

	public void setAiringDate(String airingDate) {
		this.airingDate = airingDate;
	}

	public String getAiringTime() {
		return airingTime;
	}

	public void setAiringTime(String airingTime) {
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
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "[ 방영 날짜 " + airingDate + ", 영화 시간="
				+ airingTime + ", 영화 번호=" + movieNumber + ", 상영관 번호=" + theater + ", 남은 좌석 수=" + seat + "]";
	}
	
	public String date() {
		return "[ 방영 날짜 " + airingDate + ", 상영관 번호="
				+ theater+"]";
	}
	
	public String allfull() {
		return "[상영관 번호="+movieNumber+", 영화제목 ="+movieName+", 가격 "+moviePrice+", 좌석 "+seat+" ]";
	}
	
}
