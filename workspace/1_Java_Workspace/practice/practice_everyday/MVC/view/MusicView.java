package MVC.view;

import java.util.List;
import java.util.Scanner;

import MVC.controller.MusicController;
import MVC.model.vo.Music;

public class MusicView {
	
	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	
	public void mainMenu() {
		
		int menuNum = 0;
		do {
			
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색 ");
			System.out.println("5. 특정 곡 삭제 ");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.println("메뉴 번호 선택 : ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: addList();  break;
			case 2: addAtZero(); break;
			case 3: printAll(); break;
			case 4: searchMusic(); break;
			case 5: removeMusic(); break;
			case 6: setMusic(); break;
			case 7: ascTitle(); break;
			case 8: descSinger(); break; 
			case 9:System.out.println("프로그램 종료"); ; break; 
			default: System.out.println("잘못입력. 재입력하세요"); 
			}
			
		}while(menuNum!=9);
		
		
		
		
	}
	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String singers = sc.nextLine();
		
		Music m = new Music(title,singers);
		boolean bln = mc.addList(m);
		if(bln) {
			System.out.print("추가 성공");
		}else if(!bln) {
			System.out.print("추가 실패");
		}else {
			System.out.println("잘못입력");
		}
	}

	
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String singers = sc.nextLine();
		Music m = new Music(title,singers);
		int num = mc.addAtZero(m);
		
		if(num == 1) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
		
		
	}
	
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
//		List<Music> list = mc.printAll(); // printAll 반환타입 List이 리스트이므로 변수의 타입은 List
//		System.out.println(list);
	}
	
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		
		Music m = mc.searchMusic(title); // 아래의 removeMusic() 같은 로직
		if(m != null) {
			System.out.println("검색한 곡은 "+title+"입니다");
		}else if(m == null) {
			System.out.println("검색한 곡이 없습니다");
		}
	}
	
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		
		Music m = mc.removeMusic(title); // 위의searchMusic() 같은 로직
		if(m == null) {
			System.out.println("삭제할 곡이 없습니다");
		}else {
			System.out.println(title+"곡을 삭제했습니다");
		}
		
	}
	
	public void setMusic() {
		
		
	}
	public void ascTitle() {
		
		
		
	}
	public void descSinger() {
		
		
	}
	

}
