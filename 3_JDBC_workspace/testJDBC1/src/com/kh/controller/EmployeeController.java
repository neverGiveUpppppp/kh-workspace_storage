package com.kh.controller;
import java.util.ArrayList;

import com.kh.model.dao.EmployeeDAO;
import com.kh.model.vo.Employee;
import com.kh.view.Menu;



public class EmployeeController {
	
//	controller : Model과 View를 연결해주는 다리역할
//				 넘겨받은 데이터를 가공시키는 역할
//			 	어떤 뷰에 출력할지를 결정
	
	private EmployeeDAO empDAO = new EmployeeDAO();
	private Menu menu = new Menu(); // kh.view.menu 임포트
	
	
	// 메뉴1.전체 사원 정보 조회
	public void selectAll() {
		ArrayList<Employee> list = empDAO.selectAll(); // list에 아무 값이 안들어 올 경우를 대비해
		//컨트롤러에서 뷰를 어떻게 갈지 정해줘야한다
		
		// DAO에서 받아온 list의 값이 비어있을 때 = 사원이 없을 때
		if(list.isEmpty()) {
			menu.displayError("조회 결과가 없습니다.");
		}else {
		// list가 비어있지 않을 때 = 사원 존재할 때
			menu.selectAll(list); // DAO에서 받아온 list의 값이 존재하니 받아온 데이터를 넘겨줌
		} 
	}

	
	// 메뉴2.사번으로 사원 정보 조회
	public void selectEmployee() { // 리턴해서 받을려면 int 추가
		//사번 입력 view
		int empNo = menu.selectEmpNo(); 	// view selectEmpNo()
		Employee emp = empDAO.selectEmployee(empNo);		// 사번 받아왔으니 조회할 수 있도록 DAO에 전달
		
		if(emp != null) {
			menu.selectEmployee(emp);
		}else {
			menu.displayError("해당 사번의 검색결과가 없습니다");
		}
	}

	// 메뉴3.새로운 사원 정보 추가
	public void insertEmployee() {
		Employee e = menu.insertEmployee(); // view에서 새 사원정보를 받아올 것임
		int result = empDAO.insertEmployee(e); 			// DAO로 전달
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 추가되었습니다");
		}else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}
	
	// 메뉴4.사번으로 사원 정보 삭제
	public void updateEmployee() {
		int empNo = menu.selectEmpNo(); // 2번 사원으로 사번정보 조회했던 메소드 재사용 // 메뉴4번 누르면 사번 입력하게끔 나오게된다
		// 
		Employee emp = menu.updateEmployee();
		emp.setEmpNo(empNo); 		// 뷰에서 받은 job,sal,comm 데이터 + 사번 정보 같이 합침
									// 어디를 수정할지와 어떤 값으로 수정할껀지 2가지가 들어가있음
		int result = empDAO.updateEmployee(emp);
		// empDAO.updateEmployee(emp,empNo);
		// emp만 보내면 어떤값을 수정하는지만 들어가있고 누구를 수정하는지는 안들어가있음
		// 위의 매개변수로 empNo까지 추가해서 보내도 상관없는데, emp 안에 empNo가 속해있을 수 있으니 set를 통해서 넣어주고 emp만 보내겠다는 소리
		
		// 
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 수정 되었습니다");
		}else {
			menu.displayError("데이터 수정 과정 중 오류 발생"); // 데이터 수정 성공 여부를 view에서 쓴 메소드 displayError() 동작하도록 설정
		}
	}

	// 메뉴5.사번으로 사원 정보 삭제
	public void deleteEmployee() {
		int empNo = menu.selectEmpNo();			// 누구를 삭제할지 알아야하기에 사번 받아오자
		String check = menu.deleteEmployee(); 	// 진짜 삭제할껀지 물어봐야하니 문구 출력용 메소드 생성하고 추가하자
		
		if(check.equalsIgnoreCase("Y")) { 		// 대소문자 구분 무시 메소드
			int result = empDAO.deleteEmployee(empNo);
			if(result > 0) {
				menu.displaySuccess(result + "개의 행이 삭제 되었습니다");
			}else {
				menu.displayError("데이터 삭제 과정 중 오류 발생"); 
			}
			
		}else if (check.equalsIgnoreCase("N")) {
			menu.displaySuccess("사원 정보 삭제 취소");
		}else {
			menu.displayError("잘못 입력. y 또는 n을 입력해주세요");
		}
	}	
		// 방법2
	public void deleteEmployee2() {
		int empNo = menu.selectEmpNo();			// 누구를 삭제할지 알아야하기에 사번 받아오자
		int result = empDAO.deleteEmployee(empNo);
		String check = menu.deleteEmployee(); 	// 진짜 삭제할껀지 물어봐야하니 문구 출력용 메소드 생성하고 추가하자
		
		if(check.equalsIgnoreCase("Y")) { 		// 대소문자 구분 무시 메소드
			result = empDAO.deleteEmployee(empNo);
		}else if (check.equalsIgnoreCase("N")) {
			menu.displaySuccess("사원 정보 삭제 취소");
		}else {
			menu.displayError("잘못 입력. y 또는 n을 입력해주세요");
		}
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 삭제 되었습니다");
		}else {
			menu.displayError("데이터 삭제 과정 중 오류 발생"); 
		}
	
	}
	
	
	
}






















