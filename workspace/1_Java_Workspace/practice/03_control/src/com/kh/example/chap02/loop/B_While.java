package com.kh.example.chap02.loop;
import java.util.Scanner;

public class B_While {
	
	// 2) while문
	
	// for문과 같은 문제 & for문을 while문으로 변환
	public void method01() {

		// 1부터 5까지 출력
		
		// while문
		int i = 1;
		while(i<6) {
			System.out.println(i);
			i++;
		}
		
		
		// do ~ while문
		int j = 1;
		do{
			System.out.println(i);
			j++;
		}while(j <= 5 ); 
		
	}
	
	
	
	public void method01_1() {
		// 자기 소개 다섯번 하기 : 내 이름은 박신우야
		int i = 0;
		while(i<5) {
			System.out.println("내 이름은 박신우야 "+(i+1)+"회");
			i++;
		}
		
	}
	
	public void method02() {
		// 5부터 1까지 출력
		
		int i = 5;
		while(i>0) {
			System.out.println(i);
			i--;
		}
	}
	public void method02_1() {
		// 8부터 3까지 출력
		
//		int i = 8;
//		while(i>2) {
//			System.out.println(i);
//			i--;
//		}
		
//		for(int i=8; i>=3; i--) {
//			System.out.println(i);
//		}
		
		
		// do while
		int j = 8;
		do {
			System.out.println(j);
			j--;
		}while(j >= 3);
		
	}
	public void method02_2() {

	}
	public void method03() {
		// 1에서 10사이의 홀수만 출력 : 1 3 5 7 9
		
		// 방법1 : if문 추가
//		int i = 1;
//		while(i<11) {
//			if(i%2==1) {
//				System.out.println(i);
//				
//			}
//			i++;
//		}
		
		// 방법2 :복합 대입 연산자
//		int i = 1; 
//		while(i<11) {
//			System.out.println(i);
//			i += 2;
//		}
		
		// do while
		int j = 1;
		do {
			System.out.println(j);
			j += 2;
		}while(j<10);
	}
	
	public void method04() {
		// 정수 두 개를 입력 받아 그 사이 숫자 입력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 두개를 입력하세요.");
		System.out.println("단, 첫 번째 숫자를 두 번째 숫자보다 작게 입력해주세요.");
		System.out.print("첫 번째 숫자 : ");
		int start = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int end = sc.nextInt();
		// start=3 // end=6
		// 3 4 5 6 출력되도록
		
//		int i = 0;
//		while(i<end) {
//			System.out.println(start);
//			i++;
//			start++;
//		}
		
		// 풀이
		int max = 0;
		int min = 0;
		
		if(start>end) {
			max = start;
			min = end;
		} else {
			max = end;
			min = start;
		}
		while(min<=max) {
			System.out.println(min);
			min++;
		}
		
//		// 방법1 : 변수도입
//		for(int i = start; i <= end; i++) {	
//				System.out.println(i);
//			
//		}
//		// 방법2 :for의 초기값 생략 ★★★
//		for(; start<=end; start++) { // ★★★ 초기값 생략 + 변수 조건식화 + 변수증감연산 ★★★  
//			System.out.println(start); // 초기값 생략하면 반드시 어딘가에서 채워줘야한다
//		}
		
		// 위 for문들의 문제점
		// 입력 받은 두값의 조건인 숫자1보다 숫자2를 작게 입력 안했을 경우, 프로그램 작동x
		
		// 해결방법
		// 방법1 : 범위 밖에서 잘못 입력했을 시, 다시 입력하게
		// 방법2 : 잘못 입력해도 작동하게끔 코드짜기 or 잘못 입력할 수 없게 코드짜기
		

		// start end를 비교해서 변수 초기화해둔 min max에 넣을 것
//		int min = 0; // 입력값 둘 중 비교해서 작은 값
//		int max = 0; // 입력값 둘 중 비교해서 큰 값
//		
//		if(start>end) {
//			max = start; // 변수 max에 데이터값 int 쓰지말 것
//			min = end;   // 변수 min에 데이터값 int 쓰지말 것
//		}else {
//			max = end;
//			min = start;
//		}
//		for(int i = min; i <= max; i++) {
//			System.out.println(i);
//		}
		
		
	}
	
	public void method04_0() {

	// 문자열을 입력받아 인덱스 별로 문자 출력
	// 문자열 입력 : test
	// 0 : t
	// 1 : e
	// 2 : s
	// 3 : t
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
		// 1)for문
		
		for(int i=1; i<=str.length(); i++) {
			System.out.println(i + " : " + str.charAt(i));
		}
		// for문 반복문이 2에서 끝나고 인덱스3번 값이 안오니까 .charAt()에서 없는 값을 추출할려하다보니 error
		// 해결방법 : 손 써보기
		/*
		 	ex. str = "dog"
		 			   012 (index)
		 						3
		 	  i			i<=str.length()		실행문(163)
		 	i = 1			true			1 : o	(i++)
		 	    2			true			2 : g	(i++)
		 	    3			true			3 : str.chatAt(3) 없음(범위 벗어남)
		 */
		
		
			
		// 2)while문
//		int i = 0; 
//		while(i < 4) {
//			System.out.println(i + " : " + str.charAt(i));
//			i++;
//		}
		// 4글자보다 글자수가 부족하면 없는 값을 호출할려해서 error
		// 해결책 : .length()
		// .length()는 java.lang.String 클래스의 메소드이므로 사용가능
		int ii = 0; 
		while(ii < str.length()) {
			System.out.println(ii + " : " + str.charAt(ii));
			ii++;
		}
		int i = 0;
		while(i<str.length()) {
			System.out.println();
		}
		
		// 3) do while문
		
		int j = 0;
		do {
			System.out.println(j + " : " + str.charAt(j));
			j++;
			
		}while(j<str.length());
		
		
	}
	public void method05() {
		// 2단부터 9단까지 출력
		/*
		 	2*1=2	3*1=3	크게 도는 부분 : 구구단수
		 	2*2=4	3*2=6	-> 밖 for
		 	2*3=6	3*3=9	작게 도는 부분 : 곱하는
		 	2*4=8	3*4=12	-> 안 for
		 	...		...
		 	2*9=18	3*9=27
		 
		 */
		
		
//		int i = 2;
//		while(i<10) { 
//			int j = 1;	
//			System.out.printf("--- %d단 ---%n",i);
//			while(j<10) {
//				System.out.printf("%d x %d = %d%n",i,j,i*j);
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		// 풀이
		int dan = 2;
		while(dan <= 9) {
			int i = 1;
			while(i <= 9) {
				System.out.println(dan + " * " + i + " = " + ( dan * i));
				i++;
			}
			dan++;
		}
		
		// 문제점 찾기
//		int dan = 2;
//		int i = 1;
//		while (dan <= 9)  {
//			System.out.println(dan + " * " + i + " = " + ( dan * i));
//			i++; // 문제점 : i가 1차 while 위에 있기에 구구단 뒷자리 숫자가 초기화 되고 다시 1-9까지 돌아줘야하는데
//		}		 //		   int i가 밖에 있어서 초기화 안되고 10으로 유지되는 것
//		dan++;
	}
	
	public void method06() {
		// 시계 : 0시0분 ~ 23시 59분
		
//		int i = 0;
//		while(i<24) {
//			int j = 1;  // 0시 0분에서 0분이 없어서 틀림. j를 초기값 0으로 수정해야한다
//			while(j<60) {
//				System.out.printf("%2d시 %2d분%n",i,j);
//				j++;
//			}
//			i++;
//		}
		

	// 풀이
		int hour = 0;
		while(hour < 24) {
			int min = 0;
			while (min < 60) {
				System.out.println(hour + "시" + min + "분");
				min++;
			}
			hour++;
		}
	}
	
	public void method07() {
		// 메뉴 만들기
		
		// switch문
		
		// while(menuNum != 9) 조건으로 만들어보기
		
		
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		while(menuNum != 9) {
			System.out.println();
			System.out.println("1. 1부터 5까지");
			System.out.println("2. 5부터 1까지");
			System.out.println("3. m부터 n까지");
			System.out.println("4. 인덱스별 문자");
			System.out.println("5. 구구단");
			System.out.println("6. 아날로그 시계");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			menuNum = sc.nextInt(); // 변수명에 데이터타입 또 붙이면 메모리공간을 또 만들므로 같은 변수명 다시 쓸거면 데이터타입 지우고쓰기 
			System.out.println();
			
			
			
			switch(menuNum) {
			case 1 : method01(); break;
			case 2 : method02(); break;
			case 3 : method03(); break;
			case 4 : method04(); break;
			case 5 : method05(); break;
			case 6 : method06(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못된 메뉴번호입니다.");
			}
			
			
		}
		
	}
	
	public void method08() {
		// 메뉴 만들기
		
		// switch문
		
		// while(true) 조건으로 만들어보기
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println("1. 1부터 5까지");
			System.out.println("2. 5부터 1까지");
			System.out.println("3. m부터 n까지");
			System.out.println("4. 인덱스별 문자");
			System.out.println("5. 구구단");
			System.out.println("6. 아날로그 시계");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt(); // 변수명에 데이터타입 또 붙이면 메모리공간을 또 만들므로 같은 변수명 다시 쓸거면 데이터타입 지우고쓰기 
			System.out.println();
			
			
			switch(menuNum) {
			case 1 : method01(); break;
			case 2 : method02(); break;
			case 3 : method03(); break;
			case 4 : method04(); break;
			case 5 : method05(); break;
			case 6 : method06(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); return; // 결과값 반환 and 메소드 끝내는 역할
			default : System.out.println("잘못된 메뉴번호입니다.");
			}
			// return 
			// 나(메소드-메인메소드)를 호출한 쪽으로 돌아가는 역할
			// 위의 리턴은 값 없이 돌아감
			
		}
		
	}
	
	public void method09() {
		
		// 메뉴 만들기
		
		// switch문
		
		// do while 조건으로 만들어보기
		
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		do {
			System.out.println();
			System.out.println("1. 1부터 5까지");
			System.out.println("2. 5부터 1까지");
			System.out.println("3. m부터 n까지");
			System.out.println("4. 인덱스별 문자");
			System.out.println("5. 구구단");
			System.out.println("6. 아날로그 시계");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			menuNum = sc.nextInt(); // 변수명에 데이터타입 또 붙이면 메모리공간을 또 만들므로 같은 변수명 다시 쓸거면 데이터타입 지우고쓰기 
			System.out.println();
			
			switch(menuNum) {
			case 1 : method01(); break;
			case 2 : method02(); break;
			case 3 : method03(); break;
			case 4 : method04(); break;
			case 5 : method05(); break;
			case 6 : method06(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못된 메뉴번호입니다.");
			}
		} while(menuNum != 9);
	}	
		
	public void method10() {
		// 메뉴 만들기
		// switch문
		
		// do while(true) 조건으로 만들어보기
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("1. 1부터 5까지");
			System.out.println("2. 5부터 1까지");
			System.out.println("3. m부터 n까지");
			System.out.println("4. 인덱스별 문자");
			System.out.println("5. 구구단");
			System.out.println("6. 아날로그 시계");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt(); // 변수명에 데이터타입 또 붙이면 메모리공간을 또 만들므로 같은 변수명 다시 쓸거면 데이터타입 지우고쓰기 
			System.out.println();
			
			
			switch(menuNum) {
			case 1 : method01(); break;
			case 2 : method02(); break;
			case 3 : method03(); break;
			case 4 : method04(); break;
			case 5 : method05(); break;
			case 6 : method06(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); return; // 결과값 반환 and 메소드 끝내는 역할
			default : System.out.println("잘못된 메뉴번호입니다.");
			}
			// return 
			// 나(메소드-메인메소드)를 호출한 쪽으로 돌아가는 역할
			// 위의 리턴은 값 없이 돌아감
			
		} while(true);
	}	
		
		
		
	public void method11_1() {
		// 1) while(true) 조건
		
		// 키보드로 문자열을 입력 받아 출력 반복 실행
		// exit가 입력되면 반복종료
		
		
		Scanner sc = new Scanner(System.in);
		String strE = "exit";
		
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			if (str.equals(strE)) {
				return;
			}
		}
	}
		
	
	public void method11_2() {
		// 2) while(!str.equals("exit")) 조건
		
		Scanner sc = new Scanner(System.in);
//		String str = null;	변수에  null을 넣게되면 .equals()에서 없는 값을 끌어와야하기 error
		String str = "";
		
		while(!str.equals("exit")) {	// !변수명.equals() : 같지않다
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("str : "+str);
				
		}
	}
		

	public void method11_3() {
		// 3) do while
		
		Scanner sc = new Scanner(System.in);
		String str = null; // 2)번에서는 오류난 nulldl 3)번에서는 왜 안났을까?
//		String str = "";   //  .equals에서 값을 가져오려하기 전에 str에 스캐너로 값을 받았기 때문
	
		do {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("str : "+str);
		} while(!str.equals("exit"));
				
				
				
		
	}
	
	
	
}
				
//		while(menuNum != 9) {
//			System.out.println();
//			System.out.println("1. 1부터 5까지");
//			System.out.println("2. 5부터 1까지");
//			System.out.println("3. m부터 n까지");
//			System.out.println("4. 인덱스별 문자");
//			System.out.println("5. 구구단");
//			System.out.println("6. 아날로그 시계");
//			System.out.println("9. 종료");
//			System.out.print("메뉴 번호 : ");
//			menuNum = sc.nextInt(); // 변수명에 데이터타입 또 붙이면 메모리공간을 또 만들므로 같은 변수명 다시 쓸거면 데이터타입 지우고쓰기 
//			System.out.println();
//			
//			
//			
//			switch(menuNum) {
//			case 1 : method01(); break;
//			case 2 : method02(); break;
//			case 3 : method03(); break;
//			case 4 : method04(); break;
//			case 5 : method05(); break;
//			case 6 : method06(); break;
//			case 9 : System.out.println("프로그램을 종료합니다."); break;
//			default : System.out.println("잘못된 메뉴번호입니다.");
//			}
		
	
//////////////////////////////////////////////////////////////////////////////////
////////							아래는 for문 문제들						//////////
//////////////////////////////////////////////////////////////////////////////////
	
//	public void method04_1() {
//		
//		// 정수를 하나 입력받아 그 수가 1~9 사이의 수 일 때만 해당 수의 구구단 출력
//		// 조건이 맞지 않으면 "1~9사이의 양수를 입력하여야 합니다" 출력
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("1~9 사이의 양수 하나를 입력하세요 : ");
//		int num = sc.nextInt();
//		
//		if(num >=1 && num <=9) {
//			for(int i=1; i<10; i++) {  // for문 i발동 조건식이 좀 햇갈리니 연습하자
//				System.out.printf("%d x %d = %d%n",num,i,num*i);  // %d   결과값 왼쪽정렬   // printf 정렬법
//				System.out.printf("%d x %d = %2d%n",num,i,num*i); // %2d  결과값 오른쪽정렬
//				System.out.printf("%d x %d = %-2d%n",num,i,num*i);// %-2d 결과값 왼쪽정렬
//			}	
//		}else {
//			System.out.println("1~9사이의 양수를 입력하여야 합니다");
//		}
//			
//	}
//	
//	public void method05() {
//	// 1부터 10 사이의 임의의 난수를 정해 1부터 난수까지의 정수 합계 (난수 임의의 숫자)
//		
//	// 랜덤으로 숫자선택 : Math클래스의 random() 클래스 사용
//	// Math.random() : 임의의 0~1의 더블값을 반환	
//		
////		System.out.println(Math.random());
//	// (0단계) 0 <= Math.random() >= 1 : 0~0.999999999까지 반환
//	// (1단계) 0 <= (Math.random() *10) < 10 : 0~9.99999
//	// (2단계) Math.random() * 10 + 1 < 11 : 1~10.99999	
//	// (3단계) (int)(Math.random() * 10 + 1) < 11 : 1~10 // 정수로 강제 형변환. 
//														// 랜덤인수 발생이라 데이터손실 no problem
//	// 2단계와 3단계는 순서가 바뀌어도 동일한 결과를 얻을 수 있음
//		
////		int random = (int)Math.ceil((Math.random() * 10)); // 다른방법
//		int random = (int)(Math.random() * 10 + 1);
//		int sum = 0; // 변수 초기화
//		for(int i=1; i<=random; i++) {
//			sum = sum + i;
////			sum += i; 위와 같은 코드
//		}
//		System.out.println("1부터 "+random+"까지의 정수합계 : "+sum);
//		
//		// 사용 : for문 + Math.random() 
////		1+2+3+4+5 난수5
////		random-1 until radom == 0 stop
//	}	
//		
//	public void method05_1() {		
//		// 1부터 50까지의 임의의 난수를 뽑아 홀수인지 짝수인지 판별
//		
//		// 0~1
//		// 1~10
//		// 1~50 for문 최대치 +@
//		// random 수의 범위 늘리기
//		int random = (int)(Math.random() * 50 + 1); // 변수 선언
//		
////		// 디버깅용 for문
////		for(int i=1; i<=random; i++) {
////			System.out.println("i="+i+" random="+random+"\n");
////		}
//	
//		if(random%2 == 0) {
//			System.out.println(random+"은 짝수");
//		}else {
//			System.out.println(random+"은 홀수");
//			
//		}
//	}	
//	public void method05_2() {	
//		// 2부터 20까지의 임의의 난수를 뽑아 해당 숫자에 대한 구구단 출력
//		
//		// brainstorming
//		// * 10 + 1 : 1~10.99999	
//		// * 10 + 2 : 2~11.9999
//		// * 20 + 1 : 1~20.99999	
//		// * 20 + 2 : 2~21.9999
//		// 난수 자체를 2~20까지 뽑기
//		// 범위 밖의 숫자1이 나오면 삭제하고 2~20까지만 구구단 출력
////		int random = (int)(Math.random() * 20 + 1);
////		if(random>1 && random<21) {
////			
////		}
////		for(int i=1; i<10; i++) {
////			System.out.printf("%d x %d = %d%n",random,i,random*i);
////		}
////		
//		
//		// 풀이
//		// 0 <= Math.random() < 1
//		// 0 <= Math.random() * 19 < 19
//		// 2 <= Math.random() * 19 + 2 < 21
//		// 2 <= (int)(Math.random() * 19 + 2) < 21 : 2~20
//	
//		int random = (int)(Math.random() * 19 + 2);
//		for(int i=1; i<=9; i++) {
//			System.out.printf("%2d x %d = %3d%n",random,i,random*i); // prinf 우측정렬
//		}
//		// 다른방법
//		// (int)(Math.random() * 10) * 2 + 2 
//	}
//	
//	public void method06() {		
//	// 2단부터 9단까지 출력
//		
//	// (0단계) 0 <= Math.random() >= 1 : 0~0.999999999까지 반환
//	// (1단계) 0 <= (Math.random() *10) < 10 : 0~9.99999
//	// (2단계) Math.random() * 10 + 1 < 11 : 1~10.99999	
//	// (3단계) (int)(Math.random() * 10 + 1) < 11 : 1~10 // 정수로 강제 형변환. 		
//		
////		for(int i=1; i<10; i++) {
////			int random = (int)(Math.random() * 9 + 1);
////			System.out.println(random);
////		}
//		
//		
//		// 풀이
//		// 크게 도는 부분 : 단 -> 외부for문
//		// 작게 도는 부분 : 곱하는 -> 내부for문
//		for(int i=2; i<=9; i++) {
//			for(int j=1; j<=9; j++) {
//				System.out.printf("%d x %d = %2d%n",i,j,i*j);
//			}
//			System.out.println();// 단과 단 사이에 줄바꿈 넣고 싶다면 추가
//		} 
//	}
//	
//	public void method07() {	
//	// 아날로그 시계 0시 0분 ~ 23시 59분
//		
//		for(int i=0; i<=23; i++) {		// 시간
//			for(int j=0; j<=59; j++) {	// 분
//				System.out.printf("%d시 %d분%n",i,j);
//			}
//			System.out.println();
//		}
//
//		
//		//	풀이
//		for(int i=0; i<24; i++) {
//			for(int j=0; j<60; j++) {
//				System.out.printf("%2d시 %2d분%n",i,j);
//			}
//			System.out.println();
//		}
//		
//		for(int i=0; i<24; i++) {
//			for(int j=0; j<60; j++) {
//				System.out.printf("%2d시 %2d분%n",i,j); // 초를 만들고 싶으면 for문
//			}										  // 한번더 들여쓰기
//			System.out.println();
//		}
//		
//		
//	}
//	
//	public void method08() {	
//		// 한 줄에 별표(*)가 5번 출력되는데 사용자가 입력한 수만큼 줄 출력
//		/*
//			출력할 줄 수 : 3
//			*****
//			*****
//			*****
//		*/
//		
//		// 장문용 주석 코드 : /* 
////					   */
//					
//				 	
//		
//		//풀이
//		// 1차 for문 : 전체 줄수 
//		// 2차 for문 : 안에 별의 개수
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("출력할 줄 수 : ");
//		int row = sc.nextInt();
//		
//		
//		for(int i=0; i<row; i++) {		// 전체 줄수 관련 포문
//			for(int j=0; j<5; j++) {	// 가로 별 개수 관련 포문
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		
//	}
//		
//		
//	public void method09() {		
//		// 별표(*) 찍기
//		// 줄수 칸수 모두 사용자 입력으로
//		// 단, 줄수와 칸수가 일치하는 위치에는 줄 번호에 대한 정수 출력
//		/*
//		  줄 수 : 6			줄 수 : 5
//		  칸 수 : 6			칸 수 : 5
//		  1*****		1****
//		  *2****		*2***
//		  **3***		**3**
//		  ***4**		***4*
//		  ****5*		****5
//		  *****6		
//		 */
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("줄 수 : ");
//		int row = sc.nextInt();
//		System.out.print("칸 수 : ");
//		int col = sc.nextInt();
//		
//		// 풀이
//		// 조건 : 가로세로 열행의 숫자가 같은 곳은 숫자 출력
//		// 
//		for(int i=0; i<row; i++) {		// 전체 줄수 관련 포문
//			for(int j=0; j<col; j++) {	// 가로(별 개수) 관련 포문
//				if(i==j) {
//					System.out.print(i+1);
//				}else {
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
//	}
	
	
	
	
	
	
//	public void method01() {
//		
//		
//	}
//	
//	public void method02() {
//		
//		
//	}
//	
//	public void method03() {
//		
//		
//	}
//	
//	public void method04() {
//		
//		
//	}
//	
//	public void method05() {
//		
//		
//	}

