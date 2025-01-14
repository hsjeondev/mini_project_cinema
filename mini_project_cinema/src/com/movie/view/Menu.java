package com.movie.view;

import java.util.List;
import java.util.Scanner;

import com.movie.controller.ScreeningController;
import com.movie.controller.UserController;
import com.movie.model.vo.Movie;
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
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1 : signIn();break;
				case 2 : login(); break;
				case 3 : movieRank();break;
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

	public void userMenu(String userName) {
		System.out.println("=== 유저 메뉴 ===");
		System.out.println(userName + "님 환영합니다!");
	}

	
	
	public void insertMovieOne() {
		System.out.println("*** 영화 추가 ***");
		System.out.println("새로운 영화를 추가할 정보를 입력해주세요!!");
		System.out.println("(제목, 러닝타임, 방영시작기간, 방영종료기간, 영화가격)");
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
  //나
  public void movieRank() {
	  	System.out.println("=-=상영 정보 확인=-=");
		List<Movie> list = screening.movieRank();
		System.out.print("영화를 선택하시겠습니까? (Y/N) : ");
		String yesOrNo = sc.next();
		if("Y".equals(yesOrNo)) {
			System.out.println("맞음");
		}else {
			System.out.println("안녕히 가십시오. 고맙습니다.");
			return;
		}
	}
  //나
  /*public void reservation() {
	  System.out.println("=-=티켓 예매=-=");
	  List<Screening> list = screening.movieRank();
	  
  }*/
	
}
