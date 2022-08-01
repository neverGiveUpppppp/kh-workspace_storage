package MVC.view;
import java.util.ArrayList;
import java.util.Scanner;

import MVC.controller.pController07;
import MVC.model.vo.pModelVo07;

public class pView07 {
// view : 화면
//	   		   사용자에게 보여지는 곳	
	private Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		
		pController07 pc = new pController07();
		int user = 0;
		
		do {
			
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
			case 1: pc.selectAll(); break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 0: System.out.println("프로그램을 종료합니다"); break;
			default: System.out.println("잘못 입력");
				
			}
		}while(user !=0 );
		
	}
	public void displayError(String disErr) {
		System.out.println("서비스 요청 실패  : " + disErr);
	}
	public void displaySuccesss(String disSuc) {
		System.out.println("서비스 요청 성공 : "+ disSuc);
	}
	
	// 메뉴1.전체 사원 정보 조회
	public void selectAll(ArrayList<pModelVo07> al) {
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}
	
	
	
	
}
