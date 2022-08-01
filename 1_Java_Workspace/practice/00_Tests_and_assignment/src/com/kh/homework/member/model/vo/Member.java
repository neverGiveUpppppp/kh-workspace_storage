package com.kh.homework.member.model.vo;

public class Member {
	
	private String id;
	private String name;
	private String password;
	private String email;
	private char gender;
	private int age;
	
	// 기본 생성자
	public Member() {}
	// 6개 매개변수 생성자
	public Member(String id, String name, String password, 
			String email,char gender, int age) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	
	// setter
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
	// getter
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String email() {
		return email;
	}
	public char gender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	
	//inform()
	// 멤버 클래스의 모든 필드 값들을 합쳐 반환
	public String inform() {
		return id+" "+name+" "+password+" "+email+" "+gender+" "+age;
	}

}
