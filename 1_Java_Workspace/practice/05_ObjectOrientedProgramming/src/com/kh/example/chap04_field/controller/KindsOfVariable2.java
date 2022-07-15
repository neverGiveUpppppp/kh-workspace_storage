package com.kh.example.chap04_field.controller;

public class KindsOfVariable2 {

	// 스태틱변수(=클래스변수) vs 인스턴스 변수
	// 비교
	
	private String str1; // 캡슐화
	private static String str2; // static 공유의 의미. 이 코드는 나만 볼 수 있음
	// 볼 수 있는건 variable2라는 이 클래스 뿐이라 공유 의미가 없음
	// static은 private하고 거의 안쓰인다. 공유할려는데 접근제한 해버리니 꼴이니
	
	public static String str;
	
	
	// static 유무의 차이 비교
	private int testNum = 10; 			// 인스턴스 변수
	private static int staticTestNum = 10;
	
	public void method() {
		testNum++;	// 인스턴스 변수. 메인메소드에서 불러올 방법x
		System.out.println(testNum);
		staticTestNum++;
		System.out.println(staticTestNum);
		
	}
	
}
