package com.kh.operator;

// 증감 연산자
// 1.단항 연산자
// 2.다항 연산자
public class B_InDecrease {

		// 1.단항연산자
	public void method1() {
		// 1)전위 증감 연산자
		int num1 = 10;
		System.out.println("전위 증감 연산자 적용 전 : " + num1);			// 10	
		System.out.println("++num1을 1회 수행 후 결과 : " + ++num1);	// 11
		System.out.println("++num1을 2회 수행 후 결과 : " + ++num1);	// 12
		System.out.println("++num1을 3회 수행 후 결과 : " + ++num1);	// 13
		System.out.println("++num1을 4회 수행 후 결과 : " + ++num1);	// 14
		System.out.println("++num1을 5회 수행 후 결과 : " + ++num1);	// 15
		System.out.println("++num1을 5회 수행 후 결과 : " + (++num1)); // ++을 ()로 묶어도 괜찮
		System.out.println("후위 증감 연산자 적용 후 : " + (++num1));	    // 15  
	
		// 2)후위 증감 연산자	
		int num2 = 10; 
		System.out.println("후위 증감 연산자 적용 전 : " + num2);			// 10
		System.out.println("num2++을 1회 수행 후 결과 : " + num2++);	// 10 출력은 10이나 실제값은 11
		System.out.println("num2++을 2회 수행 후 결과 : " + num2++);	// 11
		System.out.println("num2++을 3회 수행 후 결과 : " + num2++);	// 12
		System.out.println("num2++을 4회 수행 후 결과 : " + num2++);	// 13
		System.out.println("num2++을 5회 수행 후 결과 : " + num2++);	// 14
		System.out.println("num2++을 5회 수행 후 결과 : " + (num2++)); // ++을 ()로 묶어도 no prob
		System.out.println("후위 증감 연산자 적용 후 : " + num2++);	    // 15  
	}
	
	public void method2() {
		int num1 = 20;
		int result1 = num1++ * 3;					// 후치
		System.out.println("result1 : " + result1);	// 20*3=6 : 대입연산자로 대입되고 변수값 출력되고 후에 +1되기에 출력에 +1 미반영
		System.out.println("num1 : " + num1);		// 21 : 위 계산 후 +1된 상태가 반영되서 출력값21
		
		int num2 = 20;
		int result2 = ++num2 * 3;					// 전치
		System.out.println("result2 : " + result2);	// 20+1=21*3=63
		System.out.println("num2 : " + num2);		// 21 : 20+1된게 반영되서 21
		
	}
	public void method3() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++);// 10
		// a=11 b=20 c=30
		System.out.println((++a) + (b++));	// 32
		// 					12 		20
		// a=12 b=21 c=30
		System.out.println((a++) + (--b) + (--c));// 61
		//					12		20		29
		// a=13	b=20 c=29
		
		System.out.println(a);	// 13
		System.out.println(b);	// 20
		System.out.println(c);	// 29
		
	}
}
