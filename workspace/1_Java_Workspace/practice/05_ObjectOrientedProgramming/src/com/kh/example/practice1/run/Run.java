package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {
	public static void main(String[] args) {

		Member m = new Member(); // 데이터 타입 멤버의 객체
		// 메소드명으로 알 수 있는 것
		// changeName()을 이용해 이름 변경 후 --> changeName()가 이름을 변경해주는 것
		// printName()을 이용해 이름 출력 --> printName()은 이름을 출력하는 것
		m.changeName("강건강");
		m.printName();
	
	
	}

}
