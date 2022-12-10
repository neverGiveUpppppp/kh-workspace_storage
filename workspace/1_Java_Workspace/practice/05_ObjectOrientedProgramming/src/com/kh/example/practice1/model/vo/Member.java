package com.kh.example.practice1.model.vo;
public class Member {

	private String memberId;
	private String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	
	public Member() { // 생성자
		
	}
	
	
	public void changeName(String name) {
	// 이름이 저장될 곳은 위에 private String memberName;
	// 변경할 이름의 정보를 가지고 있는 곳은 
	// public void changeName(String name)의 '(String name)'
	// 변경 후 이름의 정보를 저정보관할 곳은 private String memberName;
		memberName = name;
		
		
	}
	public void printName() {
		System.out.println(memberName); // println이 외부패키지 임포트한 것
	}									// java.lang패키지의 System클래스
	
}
