package com.kh.example.person.run;
import com.kh.example.person.controller.PersonController;


// 객체 배열

public class Run {

	public static void main(String[] args) {
		
		PersonController pc = new PersonController();
		pc.method1(); // 결과값 : 기본값인 null 출력
		pc.method2();
		
	}
}
		