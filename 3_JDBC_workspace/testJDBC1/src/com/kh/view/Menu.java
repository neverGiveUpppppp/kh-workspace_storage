package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.EmployeeController;
import com.kh.model.vo.Employee;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		EmployeeController ec = new EmployeeController(); // 컨트롤러 객체 생성
	
		int user = 0;
		do { 			// 스캐너로 유저 입력 받아 해당 코드 실행
			System.out.println("====================");
			System.out.println("[Main Menu]");
			System.out.println("1.전체 사원 정보 조회");
			System.out.println("2.사번으로 사원 정보 조회");
			System.out.println("3.새로운 사원 정보 추가");
			System.out.println("4.사번으로 사원 정보 수정");
			System.out.println("5.사번으로 사원 정보 삭제");
			System.out.println("0.프로그램 종료");
			System.out.println("====================");
			System.out.print("메뉴 선택 : ");
			user = Integer.parseInt(sc.nextLine());
			
			switch(user) {
			case 1: ec.selectAll(); break; 
			case 2: ec.selectEmployee(); break;
			case 3: ec.insertEmployee(); break;     
			case 4: ec.updateEmployee(); break;
			case 5: ec.deleteEmployee(); break;
			case 0: System.out.println("프로그램을 종료합니다"); break;
			default: System.out.println("잘못 입력");
			
			}
			
		} while(user != 0); // 0이 아닐 때까지 돌아라 코드
	}

	
	public void displayError(String string) {
		System.out.println("서비스 요청 실패 : "+ string);
	}
	// 메뉴 1번의 구현 : 전체 사원 정보 조회
	public void selectAll(ArrayList<Employee> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	// 메뉴 2번의 사번 받고 컨트롤러로 리턴
	public int selectEmpNo() {
		System.out.print("사번을 입력하세요 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		return empNo; // controller로 리턴
	}
	// 메뉴 2번 : 사번으로 사원 정보 조회	
	public void selectEmployee(Employee emp) {
		System.out.println(emp);
	}
	// 메뉴3번의 구현 : 새로운 사원 정보 추가
	public Employee insertEmployee() {			// 반환타입 : Employee
		System.out.println("[새로운 사원정보 추가]");
		System.out.print("사번 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		System.out.print("이름 : ");
		String empName = sc.nextLine();
		System.out.print("직책 : ");
		String job = sc.nextLine();
		System.out.print("직속 상사 사번 : ");
		int mgr = Integer.parseInt(sc.nextLine());
		System.out.print("급여 : ");
		int sal = Integer.parseInt(sc.nextLine());
		System.out.print("커미션 : ");
		int comm = Integer.parseInt(sc.nextLine());
		System.out.print("부서번호 : ");
		int deptNo = Integer.parseInt(sc.nextLine());
		
		// 위의 데이터를 하나씩 옮기면 힘드니 Employee로 묶어서 한번에 보내자
		Employee e = new Employee(empNo, empName, job, mgr, sal, comm, deptNo);
		return e;
	}
	
	public void displaySuccess(String string) {
		System.out.println("서비스 요청성공 : " + string);
	}
	
	// 메뉴4번의 구현 : 사번으로 사원 정보 수정
	public Employee updateEmployee() {		// 반환타입 변경 : void to Employee
		System.out.print("직책 : ");
		String job = sc.nextLine();
		System.out.print("급여 : ");
		int sal = Integer.parseInt(sc.nextLine());
		System.out.print("커미션 : ");
		int comm = Integer.parseInt(sc.nextLine());
		
		Employee e = new Employee(job, sal, comm);
		
		return e;
		
	}
	
	// 메뉴5번의 구현 : 사번으로 사원 정보 삭제
	public String deleteEmployee() {	// return type 변경 : void to String <- return하는 yn의 데이터타입이 string이기때문
		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		String yn = sc.nextLine();
		return yn;
		
	}
	
	
		
}










