package com.movie.view;

import java.util.Scanner;

import com.movie.controller.ScreeningController;
import com.movie.controller.UserController;

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
			}
		}
	}
	
	public void signIn() {
		System.out.println("아이디 입력 : ");
		String id = sc.nextLine();
		sc.nextLine();
		System.out.println("비밀번호 입력 : ");
		String pw = sc.nextLine();
		String checkPw ="";
		while(pw.equals(checkPw)) {
			System.out.println("비밀번호 재확인 : ");
			checkPw = sc.nextLine();
		}
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();
		System.out.println("전화번호 입력 : ");
		int phone = sc.nextInt();
		
//		int cnt = uc.isDuplicateMember(id);
//		if(cnt > 0) {
//			System.out.println("이미 존재하는 아이디입니다.");
//		} else {
//			System.out.println("사용가능한 아이디입니다.");
//			System.out.println("회원가입 진행중~");
//			int result = uc.singInMember(id,pw,name,phone);
//			if(result >0) {
//				System.out.println("성공적으로 회원가입이 완료되었습니다.");
//			} else {
//				System.out.println("회원가입중 오류가 발생하였습니다.");
//			}
//		}
		
	
	}
  
  public void movieRank() {

//		List<Screening> list = screening.movieRank();
	}
	
}
