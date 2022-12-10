package com.kh.practice.file.view;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;
import com.kh.practice.file.dao.FileDAO;

public class FileMenu extends FileDAO{

	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		
		int menuNum;
		do {
			System.out.println("***** My Note *****");
			System.out.print("1. 노트 새로 만들기");
			System.out.print("2. 노트 열기");
			System.out.print("3. 노트 열어서 수정하기");
			System.out.print("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			menuNum =sc.nextInt();
		}while(menuNum == 9); {
			System.out.println("프로그램을 종료합니다");
		}
		
		
	}
	// 파일 명과 저장할 값을 받음
	public void fileSave() {
		String exit;
		char answer;
		do {
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			exit = sc.nextLine();
		}while(exit.equals("ex끝it"));{
			System.out.println("저장할 파일명을 입력해주세요(ex. myFile.txt");
			if(super.checkName(null)) // dao 파일 상속해서 super. 사용
				do {
					System.out.println("“이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n)");
					answer = sc.nextLine().charAt(0);
					if(answer == 'Y' || answer == 'y') {
						fileSave()
						//  FileController(fc)에 fileSave() 메소드로 파일 명과 StringBuilder 넘김
					}else if (answer == 'N' || answer == 'n') {
						System.out.println("저장할 파일명을 입력해주세요~");
					}else {
						// 만일 저장할 파일 명이 존재하지 않는 파일 명이었다면
						// 파일 명과 내용을 fc에 fileSave 메소드로 넘김
					}
				}while(answer == 'Y' || answer == 'y'); 
				
		}
		
		
	}
	// 파일 명을 받아 저장된 데이터 출력
	public void fileOpen() {
		System.out.println("열 파일 명 : ");
		
		
	}
	// 파일명과 저장할 값을 받음
	public void fileEdit() {
		
	}
	
}
