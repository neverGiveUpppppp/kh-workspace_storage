package com.kh.operator;

//2.다항연산자
//	1)산술연산자
//	2)비교연산자
//	3)논리연산자
//	4)복합대입연산자
//	5)삼항연산자


public class D_Comparison {
	//
	// 2)비교 연산자
	
	// >, <, >=, <=, ==, !=
	
	public void method() {
		int a = 10;
		int b = 25;
		
		boolean result1 = (a == b); // false
		boolean result2 = (a <= b);	// true
		boolean result3 = (a > b);	// false
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		// 짝수 & 홀수
		// 2로 나누어서 0이면 짝수
		// 2로 나누어서 1이면 홀수
		// 짝수 판별 구분식
		// 1) b % 2 == 0
		// 2) b % 2 != 1
		// 홀수 판별 구분식
		// 1)b % 2 == 1
		// 2)b % 2 != 0
		// 3) !(b % 2 == 0)
		
		// 조건문
		// 2로 나누었을 때 나머지가 0인가? true 짝수 false 홀수
		System.out.println("b가 짝수인가? " + (b % 2 == 0));
		System.out.println("b가 짝수인가? " + (b % 2 != 1));
		System.out.println("b가 홀수인가? " + (b % 2 == 1));
		System.out.println("b가 홀수인가? " + (b % 2 != 0));
		System.out.println("b가 홀수인가? " + !(b % 2 == 0)); // ()안이 true/false 결과이기에 결과 역전 !으로 홀수판별
		
		
	}
	
	
}
