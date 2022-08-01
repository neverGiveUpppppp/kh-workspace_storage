package com.kh.example.chap04_field.run;
import com.kh.example.chap04_field.controller.KindsOfVariable2;

public class Run {
	public static void main(String[] args) {

		
		KindsOfVariable2 kov2 = new KindsOfVariable2();
		kov2.str = "hello"; // message
		// The static field KindsOfVariable2.str should be accessed in a static way
		// static 변수를 불러와서 사용하는데 인스턴스 변수를 불러오는 식으로 불러오고 있기에
		// 스태틱변수(=클래스변수)는 클래스명.변수명="0";으로 불러오면 됨
		
		
		// static way
		// 스태틱 변수(=클래스변수) 불러와서 쓰는 사용법
		KindsOfVariable2.str = "world"; // 클래스명.변수명; 
		
		Math.random();
		Integer.parseInt();
		
		double  pi = Math.PI;
		int max = Integer.MAX_VALUE;
		
		KindsOfVariable2 kov3 = new KindsOfVariable2(); // 객체 생성
		int a = kov3.testNum; // 접근 불가
		int a = KindsOfVariable2.staticTestNum;
		// 스태틱 영역에 올라는 가지만 private라 접근 불가
		// 에러메시지 : The field KindsOfVariable2.staticTestNum is not visible
	
		kov2.method(); // 11 11
		kov2.method(); // 12 12
		
		KindsOfVariable2 kov4 = new KindsOfVariable2(); // 객체 생성
		kov4.method(); // 11 13 // why 13? 
		// testNum은 인스턴스변수로서 객체가 사라지면 변수들도 다 사라지기때문이고 
		// staticTestNum은 클래스 변수로서 프로그램 시작부터 계속 생성 및 유지되어서 
		// 다른 인스턴스에서 호출한다해도 원본이 계속 죽지 않고 살아있기에 추가로 +1씩 되어서 13인 것
		
	}

}
