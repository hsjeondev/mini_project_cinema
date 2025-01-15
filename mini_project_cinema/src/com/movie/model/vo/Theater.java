package com.movie.model.vo;

public class Theater {
	private int TheaterNo;
	private int totleSeats;
	
	
	public Theater () {}

	public Theater(int totleSeats) {
		this.totleSeats = totleSeats;
	}
	
	public Theater(int theaterNo, int totleSeats) {
		super();
		TheaterNo = theaterNo;
		this.totleSeats = totleSeats;
	}


	public int getTheaterNo() {
		return TheaterNo;
	}


	public void setTheaterNo(int theaterNo) {
		TheaterNo = theaterNo;
	}


	public int getTotleSeats() {
		return totleSeats;
	}


	public void setTotleSeats(int totleSeats) {
		this.totleSeats = totleSeats;
	}


	@Override
	public String toString() {
		return "[상영관 번호 = " + TheaterNo + ", 총 좌석수 = " + totleSeats + "]";
	}
	
	
	
}
