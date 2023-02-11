package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.model.vo.MemberJSPTable;
import com.kh.controller.MemberController;


public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		MemberController mc = new MemberController();
		int select = 0;
		
		do {
			System.out.println("\n *** 회원 관리 프로그램 *** \n");
			System.out.println("1. 새회원 등록");
			System.out.println("2. 모든 회원 조회");
			System.out.println("3. 특정 조건 회원 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 번호 입력 : ");
			select = Integer.parseInt(sc.nextLine());
			
			switch(select){
			case 1: mc.insertMember(); break;
			case 2: mc.selectAll(); break;
			case 3: mc.selectMember(); break;
			case 4: mc.updateMember(); break;
			case 5: mc.deleteMember(); break;
			case 0: mc.exitProgram(); System.out.println("프로그램을 종료합니다"); break;
			default: System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}while(select != 0);
		
		
		
	}

//	public Member insertMember() {  // 자동완성 시, 반환타입이 Member로 자동적으로 채워짐. 
//		return null; 				// return의 값도 객체의 기본값인 null로 채워짐. int면 기본값인 0으로 채워짐
//	}				 				// 주의사항 : null갑이 채워져있어서 빨간줄 에러가 안뜨기 때문에 디버깅 시 간과하기 쉬우니 조심
	
	public void displaySuccess(String string) {
		System.out.println("서비스 요청 성공 : " + string);
	}

	public void displayError(String string) {
		System.out.println("서비스 요청 실패 : " + string);
	}
	
	// 메뉴1. 새회원 등록
	public MemberJSPTable insertMember() {  
		System.out.print("회원 아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("닉네임 : ");
		String nickname = sc.nextLine();
		
		System.out.print("핸드폰 번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("관심분야 : ");
		String interest = sc.nextLine();
		
		MemberJSPTable mem = new MemberJSPTable(userId,userPwd,userName,nickname,phone,email,address,interest);
		
		
		return mem;  // 위의 Member 객체 반환을 콘트럴러의 Memeber mem으로 보냄
	}			 
	// return의 값도 객체의 기본값인 null로 채워짐. int면 기본값인 0으로 채워짐
	// 주의사항 : null갑이 채워져있어서 빨간줄 에러가 안뜨기 때문에 디버깅 시 간과하기 쉬우니 조심
	// NullPointException 발생. 범위가 넓고 어떤 객체에 나는지 알려주지 않기 때문에 찾기가 어렵다	
	
	
	
	// 메뉴2. 모든 회원 조회
	public void selectAll(ArrayList<MemberJSPTable> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	// 메뉴2. 모든 회원 조회
	// 향상된 for문 : for each문
	public void displayMember(ArrayList<MemberJSPTable> list) {
		for(MemberJSPTable m : list) {
			System.out.println(m); 
		}
		
//		System.out.printf("%-10s %-10s %-5s %-5s %-20s %-15s %-4s %-20s %-15s\n", "ID", "PWD", "NAME", "NICKNAME",
//				"PHONE", "EMAIL", "ADDRESS", "INTEREST", "ENROLLDATE","MODIFYDATE","STATUS");
//
//		// for each문
//		// 인덱스로 하는게 아니라서 while문과 비슷. 
//		for (MemberJSPTable m : list) { 		// 향상된 for문 : for each문
//			System.out.printf("%-10s %-10s %-8s %-5c %-20s %-15s %-4d %-20s %-15s\n", m.getUserId(), m.getUserPwd(),
//					m.getUserName(), m.getNickname(), m.getPhone(), m.getEmail(), m.getAddress(), m.getInterest(),
//					m.getEnrollDate(),m.getModifyDate(),m.getStatus());
//		}
//		// 위의 for each문과 같은 for문 코드
//		for(int i = 0; i < list.size(); i++) {
//			System.out.printf("%-10s %-10s %-8s %-5c %- 20s %-15s %-4d %-20s %-15s\n",
//			list.get(i).getMemberId (), list.get(i).getMemberPwd (), list.get(i).getMemberName (),
//			list.get(i).getGender (), list.get(i).getEmail(), list.get(i).getPhone(),
//			list.get(i). getAge (), list.get(i).getAddress (),
//			list.get(i).getEnrollDate());
		
	}
	
	

	// 메뉴3. 특정 조건 회원 조회로그램
	public int selectMember() {
		int sel = 0;
		
		while(true) {
			System.out.println("1.아이디로 회원조회");
			System.out.println("2.닉네임으로 회원조회");
			System.out.println("0.메인 메뉴로 돌아가기");
			System.out.print("번호 선택 : ");
			sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1: case 2: case 0: return sel; 		// return을 switch문 안에서 sel을 리턴
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	// 메뉴3. 특정 조건 회원 조회  - 아이디로 조회
	public String inputUserId() {
		System.out.print("회원 아이디 : ");
		String id = sc.nextLine();
		return id;
	}
	// 메뉴3. 특정 조건 회원 조회  - 성별로 조회
	public String inputNickname() {
		System.out.println("닉네임 : ");
		String nickname = sc.nextLine();
		return nickname;
	}

	
	
	// 메뉴4. 회원 정보 수정
	public int updateMember() {
		System.out.println("\n*** ID가 확인되었습니다. ***\n");
		
		int sel = 0;
		while(true) {
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 이메일 변경");
			System.out.println("3. 전화번호 변경");
			System.out.println("4. 주소 변경");
			System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("번호 선택 : ");
			sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1: case 2: case 3: case 4: case 0: return sel;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	// 메뉴4. 회원 정보 수정 - 수정값 입력
	public String inputUpdate() {
		System.out.print("수정 값 입력 : ");
		String input = sc.nextLine();
		return input;
	}

	
	// 메뉴5. 회원 탈퇴
	public char checkDelete() {
		System.out.println("\n*** ID가 확인되었습니다. ***\n");
		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char yn = sc.nextLine().toUpperCase().charAt(0);
		return yn;
		
	}
	

	
	
	
}



















