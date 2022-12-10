package com.kh.example.chap01.condition;
import java.util.Scanner;

// 1.반복문
//  1)if
//  2)switch

public class B_Switch {
	public void method1( ) {
		
		// 2)switch
		
		// 정수 두개와 연산기호 문자 1개를 받아서 연산기호 문자에 해당하는 계산을 수행하고 출력
		// ex)
		// 첫번쨰 값 : 1
		// 첫번쨰 값 : 2
		// 연산자(+,-,*,/) : *
		/// 1 * 2 = 2
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 값 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 값 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자(+,-,*,/) : ");
		char op = sc.next().charAt(0);
		
		int result = 0;		// 연산 결과를 담아놓을 변수
		
		
		// ▶if문
//		if (op == '+') {		// char가 기본형이라 == 사용가능
//			result = num1 + num2;
//		}else if (op == '-') {
//			result = num1 - num2;
//		}else if (op == '*') {
//			result = num1 * num2;
//		}else if (op == '/') {
//			result = num1 / num2;
//		}
		
		
		// ▶switch
		
//		switch(op) { 				// () 안 조건식 : 정수,문자,문자열만 가능
//		case '+':					// op가 문자라서 ''로 
//			result = num1 + num2;	// break가 없어서 +말고도 아랫줄 전부 연산. 결과값 3
//		case '-':
//			result = num1 - num2;	// '+'에서 얻어져서 result에 들어간 값3이 '-'에서 얻은 값으로 덮어씌워짐
//		case '*':
//			result = num1 * num2;
//		case '/':
//			result = num1 / num2;	// 마지막 '/'의 연산된 값(1/2=0)이 result로 들어가게 되면서 출력값이 0
//		}
		
		// break 추가 -> 연산오류 해결
		switch(op) { 				// () 안 조건식 : 정수,문자,문자열만 가능
		case '+':					// op가 문자라서 ''로 
			result = num1 + num2;	// break가 없어서 +말고도 아랫줄 전부 연산. 결과값 3
			break;
		case '-':
			result = num1 - num2;	// '+'에서 얻어져서 result에 들어간 값3이 '-'에서 얻은 값으로 덮어씌워짐
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;	// 마지막 '/'의 연산된 값(1/2=0)이 result로 들어가게 되면서 출력값이 0
			break;					// 마지막 break는 안써도 됨
		}
		
		System.out.println(num1 + " " + op + " "+ num2 + " = " + result);
		
	}
	
	public void method2() {
		
		// 입력한 숫자가 짝수인지 홀수 인지 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();

//		switch(num % 2) {
			
		int mod = num % 2;
		switch(mod) {
		case 1:System.out.println("짝수"); break; // case번호 거꾸로 가도 no prob
		case 0:System.out.println("홀수"); break;
		
		}
	}
	public void method3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12까지 중 하나를 입력하세요 : ");
		int num = sc.nextInt();
		
		// 받아온 num을 가지고 해당 달에 마지막 날 출력
		// 1~12까지 중 하나를 입력하세요 : 2
		// 입력하신 달은 28일까지입니다.
		
//		switch(num) {
//		case 1: System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 2: System.out.println("입력하신 달은 28일까지입니다"); break;
//		case 3: System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 4: System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 5: System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 6: System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 7: System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 8: System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 9: System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 10: System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 11: System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 12: System.out.println("입력하신 달은 31일까지입니다");
		
		switch(num) {
		case 1 : case 3 : case 5 : case 7: case 8 : case 10 : case 12 :
			System.out.println("입력하신 달은 31일까지입니다"); 
			break;
		case 2 :
			System.out.println("입력하신 달은 28일까지입니다"); 
			break;
		case 4 :	// break 할 필요가 없어서 코드 뺀 것
		case 6 :
		case 9 :
		case 11 :
			System.out.println("입력하신 달은 30일까지입니다"); 
			break;
			
			
//		case 1: 
//			System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 2: 
//			System.out.println("입력하신 달은 28일까지입니다"); break;
//		case 3: 
//			System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 4: 
//			System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 5: 
//			System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 6: 
//			System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 7: 
//			System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 8: 
//			System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 9: 
//			System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 10: 
//			System.out.println("입력하신 달은 31일까지입니다"); break;
//		case 11: 
//			System.out.println("입력하신 달은 30일까지입니다"); break;
//		case 12: 
//			System.out.println("입력하신 달은 31일까지입니다");
			
//		case 1: 
//			System.out.println("입력하신 달은 31일까지입니다"); 
//			break;
//		case 2: 
//			System.out.println("입력하신 달은 28일까지입니다"); 
//			break;
//		case 3: 
//			System.out.println("입력하신 달은 31일까지입니다"); 
//			break;
//		case 4: 
//			System.out.println("입력하신 달은 30일까지입니다"); 
//			break;
//		case 5: 
//			System.out.println("입력하신 달은 31일까지입니다"); 
//			break;
//		case 6: 
//			System.out.println("입력하신 달은 30일까지입니다"); 
//			break;
//		case 7: 
//			System.out.println("입력하신 달은 31일까지입니다"); 
//			break;
//		case 8: 
//			System.out.println("입력하신 달은 31일까지입니다"); 
//			break;
//		case 9: 
//			System.out.println("입력하신 달은 30일까지입니다"); 
//			break;
//		case 10: 
//			System.out.println("입력하신 달은 31일까지입니다"); 
//			break;
//		case 11: 
//			System.out.println("입력하신 달은 30일까지입니다"); 
//			break;
//		case 12: 
//			System.out.println("입력하신 달은 31일까지입니다");
		
		}
	}
	public void method4() {
		
		// 메뉴 자판기
		// 번호지정하면 실행되는 로직
		Scanner sc = new Scanner(System.in);
		System.out.println("===메뉴===");
		System.out.println("1.간단 계산기");
		System.out.println("2.짝/홀수 판단");
		System.out.println("3.n월의 마지막 날");
		System.out.print("메뉴 번호 : ");
		int menuNum = sc. nextInt();
		
		switch(menuNum) {
		case 1:
			System.out.println("간단 계산기입니다");
			method1(); // 불러올 수 있는 이유 : 같은 클래스 안에 있ㄱ 
			break;
		case 2:
			System.out.println("짝홀수 판단입니다.");
			method2();
			break;
		case 3:
			method3();
			System.out.println("n월의 마지막 날입니다.");
		// 1-3외의 다른 수가 입력된다면?
		// 아무런 반응x -> default로 해결
		default:
			System.out.println("잘못된 메뉴 번호입니다");
		}
		
		
	}
}



