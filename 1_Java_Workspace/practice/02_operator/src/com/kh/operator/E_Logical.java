package com.kh.operator;
import java.util.Scanner;

//2.다항연산자

//1)산술연산자
//2)비교연산자
//3)논리연산자
//4)복합대입연산자
//5)삼항연산자

public class E_Logical{
	public void method1() {
		
		// 3) 논리연산자
		
		// 입력한 정수 값이 1~100 사이의 숫자인지 확인
		// 1보다 크거나 같고 100보다 작거나 같다 => and연산
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		
		System.out.println(num + " 숫자가 1~100사이 숫자인가? "
							+ (num >= 1 && num <= 100)); // 문자열이 있기에 and연산자 계산을 ()로 묶어야함
	}
	public void method2() {
		// 입력한 문자 값이 대문자인지 확인
		// hint : 아스키코드
		// 65-90까지가 대문자
		Scanner sc = new Scanner(System.in);
		System.out.println("문자 하나 입력 : ");
		char ch = sc.nextLine().charAt(0);	// next**()중에 char값 받는 메소드는 없는듯
		// .charAt() : 인자, 가져올 문자 인덱스넘버
		System.out.println("영어 대문자가 맞습니까? " + (ch >= 'A' && ch <= 'Z')+"\n");
		
		System.out.println("계속 하시려면 Y 또는 y를 입력해주세요 : ");
		char yn = sc.nextLine().charAt(0);	// 메소드 체인이라고 부름
//		String strYN = sc.nextLine(); 위와 같은 코드. 두줄 to 한줄
//		char yn  = strYN.charAt(0);

		System.out.println("계속 하겠다고 하셨습니까? " + (yn == 'Y' || yn == 'y'));
	}
}
	

