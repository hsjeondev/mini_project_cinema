package com.movie.model.vo;

public class Movie {

	private int movieNo;
	private String movieTitle;
	private int runningTime;
	private String startDate;
	private String endDate;
	private int movieViews;
	private int moviePrice;
	
	
	public Movie() {}
	public Movie(int movieNo,String movieTitle) {
		this.movieNo=movieNo;
		this.movieTitle=movieTitle;
	}
	
	public Movie(String movieTitle,int runningTime,String startDate,String endDate,int moviePrice) {
		this.movieTitle = movieTitle;
		this.runningTime = runningTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.moviePrice = moviePrice;
	}
	

	public Movie(int movieNo, String movieTitle, int runningTime, String startDate, String endDate,
			int movieViews, int moviePrice) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.runningTime = runningTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.movieViews = movieViews;
		this.moviePrice = moviePrice;
	}


	public int getMovieNo() {
		return movieNo;
	}


	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}


	public String getMovieTitle() {
		return movieTitle;
	}


	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}


	public int getRunningTime() {
		return runningTime;
	}


	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public int getMovieViews() {
		return movieViews;
	}


	public void setMovieViews(int movieViews) {
		this.movieViews = movieViews;
	}


	public int getMoviePrice() {
		return moviePrice;
	}


	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}


	@Override
	public String toString() {
		return "[영화번호 = " + movieNo + ", 영화제목 = " + movieTitle + ", 러닝타임 = " + runningTime
				+ ", 방영기간(시작) = " + startDate + ", 방영기간(끝) = " + endDate + ", 영화조회수 = " + movieViews + ", 영화가격 = "
				+ moviePrice + "]";
	}
	
	public String bestMovie() {
		return "[영화번호 =" + movieNo +", 영화 제목 = "+ movieTitle + "]";
	}
	
	
	
}

