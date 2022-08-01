package com.kh.example.test.model.vo;


public class Child2 extends Parent{  // 상속 받음

	private String str;
	
	
	public Child2() { // 상속 받았기에 인스턴스 객체생성 불필요
		// this는 자기 자신을 가리키는 참조변수
		// 내 부모 객체를 가리키는 참조변수 : super
//		super.num = 0;      // private : 범위가 같은 클래스 내에서만이라 접근 불가
		super.dNum = 0.0;   // default
		super.bool = false; // protected
		super.ch = 'a';		// public
		
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	
	
	
	
}
