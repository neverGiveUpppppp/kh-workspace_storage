package com.kh.example.chap04_field.controller;

public class KindsOfVariable1 { // ←클래스영역의 시작

	// 멤버변수와 지역변수 구분
	
	
	// 전역변수 = 멤버변수 = 멤버필드 = 필드 : 클래스영역에 작성하는 변수
	// 클래스 영역에 있는게 클래스변수가 아님
	private int globalNum;
	
	
					// ↓ 매개변수
	public void method1(int num) { // 메소드 영역의 시작
		
		//지역변수 : 메소드 영역에서 잣하는 변수
		int local_num;
//		System.out.println(local_num);
		// 지역변수는 선언만 하고 다른 연산으로 사용할 때는 반드시 초기화를 해야함
		
		System.out.println(num);
		System.out.println(globalNum); // 자기영역 안에 포함이라 생성가능
		
		}
		
	public void method2() {
		
		System.out.println(globalNum); // 
//		System.out.println(localNum); 
//		System.out.println(Num); 
		
		
		
		
	
	}	// 메소드 영역의 끝
	
}		// 클래스 영역의 끝

