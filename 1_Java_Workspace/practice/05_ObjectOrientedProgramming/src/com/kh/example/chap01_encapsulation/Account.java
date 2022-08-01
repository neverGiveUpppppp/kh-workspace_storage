package com.kh.example.chap01_encapsulation;

public class Account {
	
	
//	String name = "강건강";
//	String phone = "010-1111-2222";
//	String pwd = "1q2w3e";
//	int bankCode = 2020;
//	int balance = 0;
	// private 추가
	
	private String name = "강건강";
	private String phone = "010-1111-2222";
	private String pwd = "1q2w3e";
	private int bankCode = 2020;
	private int balance = 0;
	
	
	// 입금 메소드
	public void deposit(int money) {
		
		if(money > 0) {
			balance += money;
			System.out.println(name + "님의 계좌에 " + money + "원이 입금되었습니다");
		}else {
			System.out.println("잘못된 금액이 입력되었습니다.");
		}
			
	}
	
	// 출금 메소드
	public void withdraw(int money) {
		if(money <= balance) {
			balance = money;
			System.out.println(name + "님의 계좌에서 " + money +"원이 출금되었습니다");
		}else {
			System.out.println("잔액이 부족합니다. 잔액을 확인하세요.");
		}
	}
	
	// 잔액 조회 메소드
	public void displayBalance() {
		System.out.println(name + "님의 계좌에 잔액은 " + balance + "원입니다.");
	}
	
}
