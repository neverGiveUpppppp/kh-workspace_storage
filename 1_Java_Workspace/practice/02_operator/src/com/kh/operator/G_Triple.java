package com.kh.operator;
import java.util.Scanner;

//2.다항연산자

//1)산술연산자
//2)비교연산자
//3)논리연산자
//4)복합대입연산자
//5)삼항연산자





public class G_Triple {

	public void method1() {
		// 5)삼항 연산자
		
		
		// ex)
		
//		int b = 2;
//		a > b ? a++ : b--;
		
		
		// 문제 연습1
		// 입력한 정수가 양수인지 아닌지 판별
		// 양수면 "양수다", 양수가 아니면 "양수가 아니다"
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		String plus = "양수다";
		String notPlus = "양수가 아니다";
		System.out.println(num>0 ? plus : notPlus);
		// 다른 방법1
//		String str = num > 0 ? "양수다" : "양수가 아니다";
//		System.out.println(str);
		// 다른 방법2
//		System.out.println(num > 0 ? "양수다" : "양수가 아니다" ); 
		
		
		// 문제 연습2
		// 양수일 때는 "양수다", 0일 때는 "0이다", 음수일 때는 "음수다"
		
		System.out.print("정수 하나 입력 : ");
		String plus2 = "양수다";
		String zero2 = "0";
		String notPlus2 = "양수가 아니다";
		System.out.println(num > 0 ? "양수다" : num == 0 ? "0이다 " : "음수다");
		
		// 다른 방법
//		String str2 = num > 0 ? "양수다" : (num == 0 ? "0이다" : "음수다");
//		System.out.println(str2);
//		System.out.println(num > 0 ? "양수다" : (num == 0 ? "0이다" : "음수다"));
		
		// 틀린건 아니나 쓸 데 없는 코드 붙은 코드
//		System.out.println(num > 0 ? "양수다" : (num == 0 ? "0이다" : (num < 0 ? "음수다" : "음수가 아니다")));

	}		
	public void method2() {
	
		// 문제 연습3
		
		// 사용자에게 성별을 입력받고(M/F)
		// M이면 "남자입니다", F면 "여자입니다", 둘 다 아니면 "잘못 입력하셨습니다" 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("성별 입력(M/F) : ");
		// 방법1
//		char ch = sc.nextLine().charAt(0);
//		System.out.println(ch == 'M' ? "남자" : ch == 'F' ? "여자" : "잘못 입력");
		
		// 방법2
		// 변수 도입
//		char ch = sc.nextLine().charAt(0);
//		char m = 'M';		
//		char f = 'F';
//		System.out.println(ch == m ? "남자" : ch == f ? "여자" : "잘못 입력");   // 문자열+숫자라면 ()필수이나
//		System.out.println(ch == m ? "남자" : (ch == f ? "여자" : "잘못 입력")); // 가독성을 위한 ()추가
		
		// 방법3
		// 변수선언과 동시에 코드 대입
		char gender = sc.nextLine().charAt(0);
		String result = gender == 'M' ? "남자입니다" : (gender == 'F' ? "여자입니다" : "잘못 입력했습니다");
		System.out.println(result);
	}
		
}
