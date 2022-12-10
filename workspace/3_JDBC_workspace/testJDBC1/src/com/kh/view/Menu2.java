package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.EmployeeController;
import com.kh.model.vo.Employee;

public class Menu2 {
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		EmployeeController ec = new EmployeeController(); // 컨트롤러 객체 생성
	
		int user = 0;
		do { 			// 스캐너로 유저 입력 받아 해당 코드 실행
			System.out.println("====================");
			System.out.println("[Main Menu]");
			System.out.println("1.전체 사원 정보 조회");
			System.out.println("2.사번으로 사원 정보 조회");
			System.out.println("3.새로운 사원 저보 추가");
			System.out.println("4.사번으로 사원 정보 수정");
			System.out.println("5.사번으로 사원 정보 삭제");
			System.out.println("0.프로그램 종료");
			System.out.println("====================");
			System.out.print("메뉴 선택 : ");
			user = Integer.parseInt(sc.nextLine());
			
			switch(user) {
			case 1: ec.selectAll(); break; 
			case 2: ec.selectAll(); break;
			case 3: break;     
			case 4: break;
			case 5: break;
			case 0: System.out.println("프로그램을 종료합니다"); break;
			default: System.out.println("잘못 입력");
			
			}
			
		} while(user != 0); // 0이 아닐 때까지 돌아라 코드

	
	
	}

	public void displayError(String string) {
		System.out.println("서비스 요청 실패 : "+ string);
	}

	public void selectAll(ArrayList<Employee> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
		
		
	
	
		
}










