package com.kh.example.chap01.condition;
import java.util.Scanner;


// 1.조건문
// 1)if문
// 2)switch

public class A_If {
	public void method1() {
		
		// 1)if문
		
		// 키보드로 입력한 숫자가 양수인지 음수인지 출력
		// 양수면 "입력하신 숫자는 양수입니다"
		// 음수면 "입력하신 숫자는 음수입니다"
		
		// a)단일 if문 버젼
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("입력하신 숫자는 양수입니다");
		}
		if(num < 0) {
			System.out.println("입력하신 숫자는 음수입니다");
		}
//		if(num >= 0) {	// 위 아래 if 둘 다 0을 포함하는데 결과값은?
//			System.out.println("입력하신 숫자는 양수입니다");
//		}
//		if(num <= 0) {	// 양수 음수 둘 다 출력
//			System.out.println("입력하신 숫자는 음수입니다");
//		}
		
		if(num > 0) {
			System.out.println("입력하신 숫자는 양수입니다");
		}
		if(num == 0 ) {
			System.out.println("입력하신 숫자는 0입니다");
		}
		if(num < 0) {
			System.out.println("입력하신 숫자는 음수입니다");
		}
		
		// b)if~else문 버젼
		if(num > 0) {
			System.out.println("입력하신 숫자는 양수입니다");
		}else { // false : num <= 0
			if(num == 0) {
				System.out.println("입력하신 숫자는 0입니다");
			}else {
				
				System.out.println("입력하신 숫자는 음수입니다");
			}
		}
		
		// c) if~else if~else문 버젼
		if(num > 0) { 
			System.out.println("입력하신 숫자는 양수입니다");
		} else if (num == 0) {
			System.out.println("입력하신 숫자는 0입니다");
		} else if (num < 0){
			System.out.println("입력하신 숫자는 음수입니다");
			
		}
		
		
	}
	public void method2() {
		
		// 입력한 숫자가 짝수인지 홀수인지 출력
		
		// 단일 if문 버젼
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수");
		}
		if(num % 2 == 1) {
			System.out.println("홀수");
		}
			
		
		// if~else문 버젼
//		if (num % 2 == 0) {
//			System.out.println("짝수");
//		}else {
//			System.out.println("홀수");
//		}
		
		
	}
	public void method3() {
		// 사용자에게 이름과 성별(M/F)을 입력받고 아래 형식과 같이 출력
		// 이름님은 남/여학생입니다
		// 이름 : 강건강
		// 성별(M/F) : M
		// 강건강님은 남학생입니다
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력 : ");
		String name = sc.nextLine();
		System.out.print("성별 입력(M/F) : ");
		char gender = sc.nextLine().charAt(0);	// 메소드 체인
		
		// 방법1
//		if (gender == 'M' || gender == 'm') {	// or 논리연산자 :||
//			System.out.printf(name +"님은 남학생입니다.");
//		} else if (gender == 'F' || gender == 'f') {
//			System.out.println(name + "님은 여학생입니다.");
//		} else {
//			System.out.println("잘못 입력");
//		}
		
		// 방법2
		String student = null;
		System.out.println(student.charAt(0)); // error. 아래두면 에러안남
//		에러 이유 : 변수에 아무값도 없는데 .chatAt(0) 값을 가지고 오라고 하니까 에러발생
		if (gender == 'M' || gender == 'm') {	// or 논리연산자 :||
			student = "남학생";
		} else if (gender == 'F' || gender == 'f') {
			student = "여학생";     // student변수 앞에 String 붙이면 에러
		} else {                  // else가 없으면 error
			student = "없는 성별";   // if, else if외에 모든 경우의수가 else에 담기기에 
		}                         // 이게 없으면 null값이 유지될 수 있기에 에러발생하는 것
		
		System.out.println(student.charAt(0)); // if문에서 student변수에 값을 받았기에 null 에러안남
		System.out.printf("%s님은 %s입니다.", name, student);
		
		student = "남학생";
		student = "여학생";
		student = "아학생";
		
//		String student 선언만 했을 때의 효과
//		String student 변수 위치 차이점
		
		// 많이하는 실수
		// 위에서 같은 이름의 변수 student가 반복 사용됬는데 왜 오류가 안나나
		// 같은 영역(중괄호기준)에서 같은 이름을 쓰면 에러나고 영역이 다르면 duplicate local variable 에러안뜸
		// 
//		string 차이 왜?
//		string student
	}
	public void method4() {
		// 사용자에게 이름을 입력받아 본인인지 확인하기
		// 본인 이름이 맞다면 "본인입니다" 출력 , 본인 이름이 아니라면 "본인이 아닙니다" 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
//		if(name == "본인") {					// error : ==는 기본자료형에서만 사용가능
//			System.out.println("본인입니다");
//		} else {
//			System.out.println("본인이 아닙니다");
//		}
		
		// 문자열 비교 :equals()
		//
		// 문자열 비교 할 때만 equals()사용
		if(name.equals("박신우")) {			// == vs .equals()
			System.out.println("본인입니다");
		} else {
			System.out.println("본인이 아닙니다");
		}
		
		// equals() 안쓰고 푼 코드
//		Scanner sc = new Scanner(System.in);
//		System.out.println("본인의 이름을 입력해주세요");
//		String name = sc.nextLine();
//		System.out.println(name);
//		System.out.println("본인의 이름이 맞습니까? 본인이면 Y, 본인이 아니면 N");
//		char ch = sc.nextLine().charAt(0);
//		
//		if(ch == 'Y') {
//			System.out.println("본인입니다.");
//		} else {
//			System.out.println("본인이 아닙니다.");
//		}

		
		// 변수 선언 & 변수선언+초기화 ->에러포인트2
		// null 참조형 데이터타입
//		int a;
//		System.out.println(a);
//		int a1 = null;			// error : Type mismatch: cannot convert from null to int
//		String a2 = null;		// 기본형(primitive)인 int형에 참조형(non-primitive)인 null값을 넣으려해서 에러
//		System.out.println(a1);
//		System.out.println(a2);
	}
}






