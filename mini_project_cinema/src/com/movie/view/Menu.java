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
			System.out.println("메뉴 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1 : signIn();break;
				case 2 : login(); break;
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
	
	public void login() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		User user = null;
		if("admin".equals(user.getUserId())) {
//			managerMenu();
		} else {
//			userMenu();
		}
	}
  
  public void movieRank() {

//		List<Screening> list = screening.movieRank();
	}
	
}
