package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
	
	public void method01() {

		// 1부터 5까지 출력
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
	}
	
	public void method01_1() {
		// 자기 소개 다섯번 하기 : 내 이름은 박신우야
		for(int i=0; i<5; i++) {
			System.out.println("내 이름은 Robert야");
		}
		for(int i=1; i<=5; i++) {
			System.out.println("내 이름은 Robert야 (" + i+" times)");
		}
		
	}
	
	public void method02() {
		// 5부터 1까지 출력
		
		for(int i=5; i>=1; i--) {
			System.out.println(i);
		}
		for(int i=5; i<=1; i--) { // i가 1보다 작은 0,-1로 되기에 시작수가 i는 5라 바로 false라서
			System.out.println(i);// 미작동
		}
	}
	public void method02_1() {
		// 8부터 3까지 출력\
		for(int i=8; i>=3; i--) {
			System.out.println(i);
		}
		
	}
	public void method02_2() {
		// 8부터 3까지 출력\
		for(int i=0; i>=6; i++) {
			System.out.println(i);
		}
		
	}
	public void method03() {
		// 1에서 10사이의 홀수만 출력 : 1 3 5 7 9
		// 방법1 : if문 추가
		for(int i=1; i<=10; i++) {	// 인덱스넘버는 계속 1증가 유지하고 
			if(i%2!=0) {			// 조건식을 if문을 하위로 추가
				System.out.println(i);
			}
		}
		// 방법2 :복합 대입 연산자
		for(int i=1; i<=10; i+=2) {	 
			System.out.println(i);
		}
		
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
		int min = 0; // 입력값 둘 중 비교해서 작은 값
		int max = 0; // 입력값 둘 중 비교해서 큰 값
		
		if(start>end) {
			max = start; // 변수 max에 데이터값 int 쓰지말 것
			min = end;   // 변수 min에 데이터값 int 쓰지말 것
		}else {
			max = end;
			min = start;
		}
		for(int i = min; i <= max; i++) {
			System.out.println(i);
		}
		
		
	}

	public void method04_1() {
		
		// 정수를 하나 입력받아 그 수가 1~9 사이의 수 일 때만 해당 수의 구구단 출력
		// 조건이 맞지 않으면 "1~9사이의 양수를 입력하여야 합니다" 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9 사이의 양수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num >=1 && num <=9) {
			for(int i=1; i<10; i++) {  // for문 i발동 조건식이 좀 햇갈리니 연습하자
				System.out.printf("%d x %d = %d%n",num,i,num*i);  // %d   결과값 왼쪽정렬   // printf 정렬법
				System.out.printf("%d x %d = %2d%n",num,i,num*i); // %2d  결과값 오른쪽정렬
				System.out.printf("%d x %d = %-2d%n",num,i,num*i);// %-2d 결과값 왼쪽정렬
			}	
		}else {
			System.out.println("1~9사이의 양수를 입력하여야 합니다");
		}
			
	}
	
	public void method05() {
	// 1부터 10 사이의 임의의 난수를 정해 1부터 난수까지의 정수 합계 (난수 임의의 숫자)
		
	// 랜덤으로 숫자선택 : Math클래스의 random() 클래스 사용
	// Math.random() : 임의의 0~1의 더블값을 반환	
		
//		System.out.println(Math.random());
	// (0단계) 0 <= Math.random() >= 1 : 0~0.999999999까지 반환
	// (1단계) 0 <= (Math.random() *10) < 10 : 0~9.99999
	// (2단계) Math.random() * 10 + 1 < 11 : 1~10.99999	
	// (3단계) (int)(Math.random() * 10 + 1) < 11 : 1~10 // 정수로 강제 형변환. 
														// 랜덤인수 발생이라 데이터손실 no problem
	// 2단계와 3단계는 순서가 바뀌어도 동일한 결과를 얻을 수 있음
		
//		int random = (int)Math.ceil((Math.random() * 10)); // 다른방법
		int random = (int)(Math.random() * 10 + 1);
		int sum = 0; // 변수 초기화
		for(int i=1; i<=random; i++) {
			sum = sum + i;
//			sum += i; 위와 같은 코드
		}
		System.out.println("1부터 "+random+"까지의 정수합계 : "+sum);
		
		// 사용 : for문 + Math.random() 
//		1+2+3+4+5 난수5
//		random-1 until radom == 0 stop
	}	
		
	public void method05_1() {		
		// 1부터 50까지의 임의의 난수를 뽑아 홀수인지 짝수인지 판별
		
		// 0~1
		// 1~10
		// 1~50 for문 최대치 +@
		// random 수의 범위 늘리기
		int random = (int)(Math.random() * 50 + 1); // 변수 선언
		
//		// 디버깅용 for문
//		for(int i=1; i<=random; i++) {
//			System.out.println("i="+i+" random="+random+"\n");
//		}
	
		if(random%2 == 0) {
			System.out.println(random+"은 짝수");
		}else {
			System.out.println(random+"은 홀수");
			
		}
	}	
	public void method05_2() {	
		// 2부터 20까지의 임의의 난수를 뽑아 해당 숫자에 대한 구구단 출력
		
		// brainstorming
		// * 10 + 1 : 1~10.99999	
		// * 10 + 2 : 2~11.9999
		// * 20 + 1 : 1~20.99999	
		// * 20 + 2 : 2~21.9999
		// 난수 자체를 2~20까지 뽑기
		// 범위 밖의 숫자1이 나오면 삭제하고 2~20까지만 구구단 출력
//		int random = (int)(Math.random() * 20 + 1);
//		if(random>1 && random<21) {
//			
//		}
//		for(int i=1; i<10; i++) {
//			System.out.printf("%d x %d = %d%n",random,i,random*i);
//		}
//		
		
		// 풀이
		// 0 <= Math.random() < 1
		// 0 <= Math.random() * 19 < 19
		// 2 <= Math.random() * 19 + 2 < 21
		// 2 <= (int)(Math.random() * 19 + 2) < 21 : 2~20
	
		int random = (int)(Math.random() * 19 + 2);
		for(int i=1; i<=9; i++) {
			System.out.printf("%2d x %d = %3d%n",random,i,random*i); // prinf 우측정렬
		}
		// 다른방법
		// (int)(Math.random() * 10) * 2 + 2 
	}
	
	public void method06() {		
	// 2단부터 9단까지 출력
		
	// (0단계) 0 <= Math.random() >= 1 : 0~0.999999999까지 반환
	// (1단계) 0 <= (Math.random() *10) < 10 : 0~9.99999
	// (2단계) Math.random() * 10 + 1 < 11 : 1~10.99999	
	// (3단계) (int)(Math.random() * 10 + 1) < 11 : 1~10 // 정수로 강제 형변환. 		
		
//		for(int i=1; i<10; i++) {
//			int random = (int)(Math.random() * 9 + 1);
//			System.out.println(random);
//		}
		
		
		// 풀이
		// 크게 도는 부분 : 단 -> 외부for문
		// 작게 도는 부분 : 곱하는 -> 내부for문
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%d x %d = %2d%n",i,j,i*j);
			}
			System.out.println();// 단과 단 사이에 줄바꿈 넣고 싶다면 추가
		} 
	}
	
	public void method07() {	
	// 아날로그 시계 0시 0분 ~ 23시 59분
		
		for(int i=0; i<=23; i++) {		// 시간
			for(int j=0; j<=59; j++) {	// 분
				System.out.printf("%d시 %d분%n",i,j);
			}
			System.out.println();
		}

		
		//	풀이
		for(int i=0; i<24; i++) {
			for(int j=0; j<60; j++) {
				System.out.printf("%2d시 %2d분%n",i,j);
			}
			System.out.println();
		}
		
		for(int i=0; i<24; i++) {
			for(int j=0; j<60; j++) {
				System.out.printf("%2d시 %2d분%n",i,j); // 초를 만들고 싶으면 for문
			}										  // 한번더 들여쓰기
			System.out.println();
		}
		
		
	}
	
	public void method08() {	
		// 한 줄에 별표(*)가 5번 출력되는데 사용자가 입력한 수만큼 줄 출력
		/*
			출력할 줄 수 : 3
			*****
			*****
			*****
		*/
		
		// 장문용 주석 코드 : /* 
//					   */
					
				 	
		
		//풀이
		// 1차 for문 : 전체 줄수 
		// 2차 for문 : 안에 별의 개수
		
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 줄 수 : ");
		int row = sc.nextInt();
		
		
		for(int i=0; i<row; i++) {		// 전체 줄수 관련 포문
			for(int j=0; j<5; j++) {	// 가로 별 개수 관련 포문
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
		
		
	public void method09() {		
		// 별표(*) 찍기
		// 줄수 칸수 모두 사용자 입력으로
		// 단, 줄수와 칸수가 일치하는 위치에는 줄 번호에 대한 정수 출력
		/*
		  줄 수 : 6			줄 수 : 5
		  칸 수 : 6			칸 수 : 5
		  1*****		1****
		  *2****		*2***
		  **3***		**3**
		  ***4**		***4*
		  ****5*		****5
		  *****6		
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();
		
		// 풀이
		// 조건 : 가로세로 열행의 숫자가 같은 곳은 숫자 출력
		// 
		for(int i=0; i<row; i++) {		// 전체 줄수 관련 포문
			for(int j=0; j<col; j++) {	// 가로(별 개수) 관련 포문
				if(i==j) {
					System.out.print(i+1);
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
}



