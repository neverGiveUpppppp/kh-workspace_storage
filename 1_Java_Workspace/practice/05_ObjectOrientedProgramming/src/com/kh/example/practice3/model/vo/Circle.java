package com.kh.example.practice3.model.vo;

public class Circle {
	// 공식
	// 원의 둘레 : 반지름 x 2 x 3.14
	// 원의 넓이 : 반지름 x 반지름 x 3.14
	
	
	// PI 대문자는 상수를 의미 ⇒ final추가
	// 상수는 관용적으로 전부 대문자로 쓰고 단어가 이어지는 경우에는 _로 이어붙인다
	// 변수 PI와 radius에 밑줄이 있으므로 static 추가
	public static final double PI = 3.14;
	private static int radius = 1;
	
	public void incrementRadius() {
		radius++;
		System.out.println();
	}
	
	public void getAreaOfCircle() { // 넓이
		System.out.println("println 넓이 : " + (radius*radius*PI));
		System.out.printf("printf 넓이 = %f%n",radius*radius*PI);
	}
	
	public void getSizeOfCircle() { // 둘레
		System.out.println("println 둘레 : " + (radius*2*PI));
		System.out.printf("printf 둘레 = %f%n",radius*2*PI);
		
	}
	
}
