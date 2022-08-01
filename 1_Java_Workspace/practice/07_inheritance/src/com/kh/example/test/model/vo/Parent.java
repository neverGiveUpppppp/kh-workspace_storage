package com.kh.example.test.model.vo;

public class Parent {

	private int num;
	double dNum;
	protected boolean bool; // protected : 상속상태이면 패키지 넘어 가능
	public char ch;
	
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	
	
}
