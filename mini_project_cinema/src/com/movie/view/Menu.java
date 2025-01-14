package com.movie.view;

import java.util.Scanner;

import com.movie.controller.ScreeningController;
import com.movie.controller.UserController;
import com.movie.model.vo.User;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private ScreeningController screening = new ScreeningController();
	private UserController uc = new UserController();
	
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
				case 3 : break;
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
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 0 : System.out.println("이용해주셔서 감사합니다!");return;
			default : System.out.println("지금 누른 메뉴는 없는 메뉴입니다.");
			}
		}
	public void userMenu() {

	}
	public void userMenu(String userName) {
		System.out.println("=== 유저 메뉴 ===");
		System.out.println(userName + "님 환영합니다!");
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
				userMenu(user.getUserName());
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
		}
	}
  
  public void movieRank() {

//		List<Screening> list = screening.movieRank();
	}
	
}
