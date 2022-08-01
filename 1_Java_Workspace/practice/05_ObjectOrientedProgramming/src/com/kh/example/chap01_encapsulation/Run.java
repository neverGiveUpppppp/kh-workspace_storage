package com.kh.example.chap01_encapsulation;

public class Run {
	public static void main(String[] args) {
		
		
		Account a = new Account();
//		a.deposit(100);
//		a.withdraw(0);
//		a.displayBalance();
		
//		a.deposit(100);
//		a.displayBalance();
//		
//		a.deposit(150);
//		a.displayBalance();
//		
//		a.withdraw(50);
//		a.displayBalance();
		
//		a.balance -= 200; // 돈 누가 뺴감.데이터은닉화가 안된것
		// balance 변수에 접근제어자private 추가해서 접근불가로 에러
		// error message : The field Account.balance is not visible
		a.withdraw(50);	  
		a.displayBalance();
		
	}

}
