package com.kh.example.test.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child2 extends Parent{

	public Child2() {
		Parent p = new Parent();
//		super.num = 0;		// private : 해당 클래스 밖이라  접근 불가
//		super.dNum = 21.3;  // default : 패키지 달라서 접근불가
		super.bool = true;  // protected  : 패키지 다르나 상속이라  접근가능  
		super.ch = 'b';     // public 
		
	}
	
}
