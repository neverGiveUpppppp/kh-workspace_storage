package com.kh.practice2.func.CastingPractice1;
import java.util.Scanner;

public class CastingPractice1 {
	public void method1() {
		
	// 문제1
	// 키보드로 문자 하나를 입력 받아 그 문자의 유니코드를 출력하세요
	// 자동 형변환, 아스키코드 	
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 : ");
		int num = sc.nextLine().charAt(0);
		System.out.println("A unicode : " + num);
		
		System.out.println();
		
		System.out.print("문자 : ");
		int num2 = sc.nextLine().charAt(0);
		System.out.println("a unicode : " + num2);
		
		
	}
	public void method2() {
	// 변수 선언 후 대입(변수 관리 용이)
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 : ");
		int num;
		String str = sc.nextLine();
		num = str.charAt(0);
		System.out.println("A unicode : " + num);
		
		System.out.println();
		
		int num2;
		System.out.print("문자 : ");
		String str2 = sc.nextLine();
		num2 = str2.charAt(0);
		System.out.println("a unicode : " + num2);
		
		
		
	}
}
