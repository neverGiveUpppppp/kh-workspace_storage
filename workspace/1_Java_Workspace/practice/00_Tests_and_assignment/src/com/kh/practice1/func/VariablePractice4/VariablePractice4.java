package com.kh.practice1.func.VariablePractice4;
import java.util.Scanner;

public class VariablePractice4 {
	
	public void method1() {
		
	// 영어 문자열 값을 키보드로 입력 받아 문자에서 앞에서 세 개를 출력하세요
	// .charAt()
		
		// 방법1 : println()
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		System.out.println("첫 번째 문자 : " + str.charAt(0));
		System.out.println("두 번째 문자 : " + str.charAt(1));
		System.out.println("세 번째 문자 : " + str.charAt(2));
		System.out.println();
		
		// 방법2 : printf()
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		char ch3 = str.charAt(2);
		System.out.printf("첫 번째 문자 : %c%n",ch1 );
		System.out.printf("두 번째 문자 : %c%n",ch2 );
		System.out.printf("세 번째 문자 : %c",ch3 );
				
	}
}
