package com.kh.example.chap02_class.defaulatClass.run;
import com.kh.example.chap02_class.defaulatClass.controller;


public class Run {

	public static void main(String[] args) {

		DefaultClassTest dct = new DefaultClassTest();
		dct.test();
		// public 안넣으니 메인메소드에서 error : cannot be resolved to a type
		// 메인 메소드에서 import가 안됨

		// 에러 메세지
		// Unresolved compilation problems: 
		// DefaultClassTest cannot be resolved to a type
			
		// 에러 원인
		// 접근제어자 default의 접근 가능 범위인 같은 패키지에서 벗어나서 
		// 다른 클래스에서 호출했기 때문

		// 에러 해결방법
		// 같은 패키지 클래스 내에 생성해여 run할 것
	}

}
