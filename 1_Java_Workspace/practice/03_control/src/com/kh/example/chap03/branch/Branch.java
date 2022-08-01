package com.kh.example.chap03.branch;
import java.util.Scanner;




public class Branch {

	Scanner sc = new Scanner(System.in);
	public void method01() {
		
		// 사용자에게 문자열을 입력 받아 해당 문자열의 글자 개수 출력(반복)
		// end가 입력되면 반복 종료
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
		
		// 방법1 : while(true)
//		while (true) {
//			System.out.println(str.length());
//			if(str.equals("end")) {
//				return;
//			}
//		}
		
		// 방법2 : while(!str.equals("end"))
//		while (!str.equals("end")) {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			System.out.println("글자 개수  : "+str.length());
//		}
		
		// 방법3 : do while
//		do {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			System.out.println("글자 개수  : "+str.length());
//		}while(!str.equals("end"));

		
		
//		String str = null;
//		do {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			System.out.println("글자 개수  : "+str.length());
//		} while(true);
//		
//		
//		String str = null; 
//		do {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			
//			if (!str.equals("end")) {
//				break;		// 해당 break와 가장 가까운 반복문 하나을 나간다는 의미
//			}
//			System.out.println("글자 개수  : "+str.length());
//		} while(true);
		
		
		
	}
	
	public void method02() {
		
		// 1)break
		
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			sum = i;					// 조건문이 무합반복
			
		}
		System.out.println("1투터 "+num+"까지의 합은"+sum+"입니다");
		
		

//		System.out.print("정수 하나 입력 : ");
//		int num = sc.nextInt();
//		for (int i = 1; i <= num; i++) {
//			sum = i;					// 조건문이 무합반복
//			
//		}
//		System.out.println("1투터 "+num+"까지의 합은"+sum+"입니다");
//		
//		int sum = 0;
//		for(int )
//		for(int 1==num) {
//			break;
//		}
//		System.out.println(("1투터 "+num+"까지의 합은"+sum+"입니다"););
		
	
		// 2-3시수업
		
		// 컨티뉴 : 다시 처음으로돌아서 실행 = 아래 코드는 건너뜀
		// 	for문 안의 continue : 증감식
		// 	while문 안의 continue : 조건식
		
	}
		
	
	
	public void method03() {
		
		// 2) continue
		
		// 1부터 100까지 정수들을 전부 합산
		// 이떄, 4의배수는 빼고 계산
		
		
		// 1-100까지 전부 합
//		for(i = 1; i <= 100; i++ ) {
//			sum += i;
//		}
		
		int i = 0;
		int sum = 0;
		
		// 1) continue 없이
		for(i = 1; i <= 100; i++ ) {
			if(i%4 != 0) {
				sum +=i;
			}
			sum += i;
		}
		
		// 2) continue문
		for(i = 1; i <= 100; i++ ) {
			if(i % 4 == 0 ) {// 4의배수일 떄만 true되서  건너뜀
				continue;	 // 밑에 코드는 안돌아감. 바로 i++로
			}
			sum += i;
		}
		
		
		
	}
	
	
	public void method04() {
		
		
		
	}
	
	
	public void method05() {
		
		
		
	}
	
	
	
}
