package com.kh.operator;

// 2.다항연산자
//	1)산술연산자
//	2)비교연산자
//	3)논리연산자
//	4)복합대입연산자
//	5)삼항연산자


public class C_Arithmetic {
	// 1) 산술 연산자
	// Arithmetic : 산수
	public void method1() {
	int num1 = 10;
	int num2 = 3;
	System.out.println("num1 + num2 = " + (num1 + num2));
	System.out.println("num1 - num2 = " + (num1 - num2));
	System.out.println("num1 * num2 = " + (num1 * num2));
	// 나누기(/)는 나눗셈에 대한 몫 계산
	System.out.println("num1 / num2 = " + (num1 / num2));
//	System.out.println("num1 / num2 = " + (num1 / num0)); error 0을 나눌 수 없으므로 에러
	// %(모듈러)는 나눗셈에서 발생하는 나머지 계산	
	System.out.println("num1 % num2 = " + (num1 % num2));
	}
	
	public void method2() {
		double a = 35;	// 자동 형변환됨
		double b = 10;
		
		// int형 리터럴을 double에 담았기에 실수형으로 저장되서 소수점까지 출력
		System.out.println("a = " + a); // 35.0
		System.out.println("b = " + b); // 10.0
		
		double add = a + b;	// 45.0
		double sub = a - b;	// 25.0
		double mul = a * b;	// 350.0
		double div = a / b;	// 3.5	// 변수를 int로 바꾸면 3.0나옴
		double mod = a % b;	// 5.0
		
		System.out.println("a + b : " + (add));		
		System.out.println("a - b : " + (sub));		
		System.out.println("a * b : " + (mul));		
		System.out.println("a / b : " + (div));
		System.out.println("a % b : " + (mod));
		
	}
	public void method3() {
		int a = 5;
		int b = 10;
		
		int c = (++a) + b;		// (5+1)+10= 16 // c=16 a=6 b=10
		int d = c / a;			// 16/6=2		// d=2  a=6 b=10 c=16
		int e = c % a;			// 16%6=4		// e=4
		int f = e++;			// 4			// f=5  a=6 b=10 c=16 d=2 e=5 
		int g = (--b) + (d--);	//(10-1)+(2)=11 // g=11 a=6 b=9  c=16 d=1 e=5 
		int h = 2;				//				// h=2 
		int i = a++ + b / (--c / f) * (g-- -d) % (++e + h);
		// = 6+9 / ((15)/4) * (11-1) % (6+2) // 전치 c-1 e+1 후치 a-1 g-1
		// = 6 + 9 / 3 * 10 % 8
		// = 6 + 3     * 10 % 8
		// = 6 + 30 % 8
		// = 6 + 6 = 12
		// 곱하기 나누기 모듈러 먼저 계산하고 사칙연산
		// a=7 g=10
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		System.out.println("e : " + e);
		System.out.println("f : " + f);
		System.out.println("g : " + g);
		System.out.println("h : " + h);
		System.out.println("i : " + i);
		
		
	}
}
