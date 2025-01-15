package com.movie.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import com.movie.controller.ReservationController;
import com.movie.controller.MovieController;
import com.movie.controller.ScreeningController;
import com.movie.controller.TheaterController;
import com.movie.controller.UserController;
import com.movie.model.vo.Reservation;
import com.movie.model.vo.Screening;
import com.movie.model.vo.Movie;
import com.movie.model.vo.User;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private ScreeningController screening = new ScreeningController();
	private UserController uc = new UserController();
	private ReservationController rc = new ReservationController();
	private MovieController mc = new MovieController();
	private TheaterController tc = new TheaterController();
	
	public void mainMenu(){
		System.out.println("이꿜스 영화관에 오신걸 환영합니다");
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 상영정보확인");
			System.out.println("0. 종료");
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1 : signIn();break;
				case 2 : login(); break;
				case 3 : movieRank();break;
				case 0 : System.out.println("이꿜스 영화관을 이용해주셔서 감사합니다.");return;
				default : System.out.println("지금 누른 메뉴는 없는 메뉴입니다.");

			}
		}
	}
	
	public void signIn() {
		System.out.println("아이디 입력 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력 : ");
		String pw = sc.nextLine();
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();
		System.out.println("전화번호 입력 : ");
		int phone = sc.nextInt();
		
	
	}

	public void managerMenu() {
		System.out.println("=== 관리자 메뉴 ===");
		System.out.println(" 관리자 메뉴에 오신걸 환영합니다~!");
		System.out.println("1. 영화 추가");
		System.out.println("2. 상영관 추가");
		System.out.println("3. 상영 정보 추가");
		System.out.println("4. 상영 정보 삭제");
		System.out.println("0. 로그아웃");
		System.out.print("메뉴 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {
			case 1 : insertMovieOne();break;
			case 2 : insertScreeningOne();break;
			case 3 : insertMovieInformation();break;
			case 4 : break;
			case 0 : System.out.println("이용해주셔서 감사합니다!");return;
			default : System.out.println("지금 누른 메뉴는 없는 메뉴입니다.");
			}
		}
	public void userMenu() {

	}

	
	/*public void userMenu() {
		System.out.println("=== 사용자 메뉴 ===");
		System.out.println("[1] 티켓 예매	[2] 마이페이지");
		System.out.print("원하시는 메뉴를 선택해주세요 : ");
		int number = sc.nextInt();
		switch(number) {
			case 1:reservation();break;
			case 2:
			default:System.out.println("다시 선택해주세요.");return;
		}
	}*/

	public void userMenu(User user) {
		System.out.println("===== 유저 메뉴 =====");
		System.out.println(user.getUserName() + "님 환영합니다!");
		
		int select = 0;
		while(true) {
			System.out.println("1. 티켓 예매");
			System.out.println("2. 마이페이지");
			System.out.println("9. 로그아웃");
			try {
				System.out.print("메뉴 번호 선택 : ");
				select = sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println("번호를 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
		
		switch(select) {
			case 2 : myPage(user); break;
			case 9 : System.out.println("다음에 또 오세요."); return;
		}
		
	}
	
	public void myPage(User user) {
		System.out.println("===== 마이페이지 =====");
		int select = 0;
		while(true) {
			System.out.println("1. 회원 정보 수정");
			System.out.println("2. 회원 탈퇴");
			System.out.println("3. 금액 충전");
			System.out.println("4. 예매 내역 조회");
			System.out.println("5. 예매 취소");
			try {
				System.out.print("메뉴 번호 선택 : ");
				select = sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println("번호를 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
		
		switch(select) {
			case 4 : checkReservation(user); break;
			case 5 : cancleReservation(user); break;
			case 9 : System.out.println("다음에 또 오세요."); return;
		}
		
	}
	
	public void checkReservation(User user) {
		List<Reservation> list = new ArrayList();
		list = rc.checkReservation(user.getUserNo());
		if(list.isEmpty()) {
			System.out.println("예매 내역이 없습니다.");
		} else {
			for(Reservation reservation : list) {
				System.out.println(reservation);
			}
		}
	}
	
	public void cancleReservation(User user) {
		
	}

	
	
	public void insertMovieOne() {
		System.out.println("*** 영화 추가 ***");
		System.out.println("새로운 영화를 추가할 정보를 입력해주세요!!");
		System.out.println("(제목, 러닝타임, 방영시작기간, 방영종료기간, 영화가격)");
		System.out.print("영화제목 : ");
		String movieTitle = sc.nextLine();
		System.out.print("러닝타임 : ");
		int runningTime = sc.nextInt();
		sc.nextLine();
		System.out.print("방영 시작기간 : ");
		String startDate = sc.nextLine();
		System.out.print("방영 종료기간 : ");
		String endDate = sc.nextLine();
		System.out.print("영화가격 : ");
		int moviePrice = sc.nextInt();
		sc.nextLine();
		int result = mc.insertMovieOne(movieTitle, runningTime, startDate, endDate, moviePrice);
		dmlResultPrint(result,"추가");
	}
	public void insertScreeningOne() {
		System.out.println("*** 상영관 추가 ***");
		System.out.println("새로운 상영관을 추가할 총 좌석수를 입력해주세요!");
		System.out.print("상영관 번호 : ");
		int theaterNo = sc.nextInt();
		sc.nextLine();
		System.out.print("총 좌석수 : ");
		int totalSeats = sc.nextInt();
		sc.nextLine();
		int result = tc.insertScreeningOne(theaterNo,totalSeats);
		dmlResultPrint(result,"추가");
	}
	// 추가옵션
	public void dmlResultPrint(int result, String menuName) {
		if(result > 0) System.out.println(menuName+"이(가) 정상 수행되었습니다.");
		else System.out.println(menuName+"중 오류가 발생하였습니다.");
	}
	
	public void login() {
		System.out.println("===== 로그인 =====");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		User user = uc.login(id, pw);
		if(user != null) {
			if("admin".equals(user.getUserId())) {
				managerMenu();
			} else {
				userMenu(user);
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
		}
	}
  //나
  public void movieRank() {
	  	System.out.println("=-=상영 정보 확인=-=");
		List<Movie> list = screening.movieRank();
		for(Movie m : list) {
			System.out.println(m.bestMovie());
		}
		System.out.print("영화를 선택하시겠습니까? (Y/N) : ");
		String yesOrNo = sc.next();
		if("Y".equals(yesOrNo)) {
			System.out.println("맞음");
		}else {
			System.out.println("안녕히 가십시오. 고맙습니다.");
			return;
		}
	}
  public void insertMovieInformation() {
	  System.out.println("=-=상영 정보 추가=-=");
	  List<Movie> list = screening.movieRank();
		for(Movie m : list) {
			System.out.println(m);
		}
  }
  
  //나
  /*public void reservation() {
	  System.out.println("=-=티켓 예매=-=");
	  List<Screening> list = screening.movieRank();
	  
  }*/
	
}
