package com.kh.practice1.func.VariablePractice2;
import java.util.Scanner;

public class VariablePractice2 {
		
	public void method1() {
		
	// 키보드로 정수 두 개를 입력 받아 두 수의 합, 차, 곱, 나누기한 몫을 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		// 방법1 : println()
		System.out.println("더하기 결과 : " + (num1+num2));
		System.out.println("빼기 결과 : " + (num1-num2));
		System.out.println("곱하기 결과 : " + (num1*num2));
		System.out.println("나누기 결과 : " + (num1/num2));
		
		// 방법2 : printf()
		System.out.printf("더하기 결과 : %d%n",(num1+num2));
		System.out.printf("빼기 결과 : %d%n",(num1-num2));
		System.out.printf("곱하기 결과 : %d%n",(num1*num2));
		System.out.printf("나누기 결과 : %d",(num1/num2));
		
	}
}
