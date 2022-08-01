package com.kh.practice.list.music.view;
import java.util.List;
import java.util.Scanner;
import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		
		int menuNum = 0;
		do {
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
			
			switch(menuNum){	
			case 1: addList();  break;
			case 2: addAtZero(); break;
			case 3: printAll(); break;
			case 4: searchMusic(); break;
			case 5: removeMusic(); break;
			case 6: setMusic(); break;
			case 7: ascTitle(); break;
			case 8: descSinger(); break;
			case 9: System.out.println("프로그램 종료"); ; break; 
			default : System.out.println("잘못입력. 다시입력하세요"); break;
			}
	
		}while(menuNum != 9);
		
	}
	
	// 마지막 위치에 곡 추가 성공을 알리는 메소드
	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 :");
		String title = sc.nextLine();
		System.out.print("가수 명 :");
		String singer = sc.nextLine();
		
		Music m = new Music(title, singer); // 뮤직에 담아서 addlist로 넘기기
		boolean result = mc.addList(m); // music m의 객체값을 controller의 addList() 보내는 것
		if(result) {
			System.out.println("추가 성공");
			
		}else {
			System.out.println("추가 실패");
		}

		
	}
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 :");
		String title = sc.nextLine();
		System.out.print("가수 명 :");
		String singer = sc.nextLine();
		
		Music m = new Music(title,singer);
		int result = mc.addAtZero(m);
		
		if(result == 1) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
		
	}
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 *****");
//		System.out.println(mc.printAll());
		List<Music> list = mc.printAll(); // printAll 반환타입 List이 리스트이므로 변수의 타입은 List
		System.out.println(list);
	}
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("곡 명 :");
		String title = sc.nextLine();
		 
		Music findMusic = mc.searchMusic(title); // 아래의 removeMusic() 같은 로직
		if(findMusic == null) { // 곡리스트에 없는 곡이 null이 됨
			System.out.println("검색한 곡이 없습니다.");
		}else {
			System.out.println("검색한 곡은 "+findMusic+"입니다.");
		}
		
		
	}
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("곡 명 :");
		String title = sc.nextLine();
		
		Music removeMusic = mc.removeMusic(title);// 위의searchMusic() 같은 로직
		if(removeMusic == null) { 
			System.out.println("삭제할 곳 없습니다");
		}else {
			System.out.println(removeMusic+"을 삭제했습니다");
		}
		
	}
	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("변경하고 싶은 곡 명 :");
		String title = sc.nextLine();
		System.out.println("변경할 곡 명");
		String newtitle = sc.nextLine();
		System.out.println("변경할 가수 명");
		String newSinger = sc.nextLine();
		
		Music m = new Music(newtitle,newSinger);
		Music setMusic = mc.setMusic(title, m);
		if(setMusic == null) {
			System.out.println("수정할 곡이 없습니다");
		}else {
			System.out.println(setMusic+"의 값이 변경되었습니다");
		}
		
		
	}
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
	}
	public void descSinger() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
	}
	
}
