package com.kh.general.practice.chap02.loop;
import java.util.Scanner;

public class LoopPractice {

	Scanner sc = new Scanner(System.in);
	public void practice1() {
		
//		사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
//		단, 입력한 수는 1보다 크거나 같아야 합니다.
//		만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>=1) {
			for(int i = 1; i <= num; i++) {
				System.out.print(i+" ");
			}
		}else {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}
		
	}

	
	public void practice2(){
		 
//		위 문제와 모든 것이 동일하나, 1 미만의 숫자가 입력됐다면
//		“1 이상의 숫자를 입력해주세요”가 출력되면서 다시 사용자가 값을 입력하도록 하세요.
		 
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		
		// for문
		if(num>=1) {
			for(int i = 1; i <= num; i++) {
				System.out.print(i+" ");
			}
		}else if(num<1){
			System.out.print("1이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();	// 같은 변수 재사용할 때 데이터타입 삭제해야 에러안뜸. 
		}						// 데이터타입 선언하면 메모리공간에 새로 만들기 때문
		
		 
	}
	
	public void practice3(){
		
//		사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
//		단, 입력한 수는 1보다 크거나 같아야 합니다.
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		// for문
		for(int i = num; i >= 1; i--) {
			System.out.print(i+" ");
		}
	}
	
	public void practice4(){
//		위 문제와 모든 것이 동일하나, 1 미만의 숫자가 입력됐다면
//		“1 이상의 숫자를 입력해주세요”가 출력되면서 다시 사용자가 값을 입력하도록 하세요.

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
	
		// for문
		if(num>=1) {
			for(int i = num; i >= 1; i--) {
				System.out.print(i+" ");
			}
		} else if (num<=0) {
			System.out.print("1이상의 숫자를 입력해주세요 : ");
			num = sc.nextInt();
		}

		
	}
	
	
	public void practice5(){
		
//		1부터 사용자에게 입력 받은 수까지의 정수들의 합을 출력하세요.
		
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int i = 0;
		int sum = 0;
		
		// for문
		for(i = 1; i < num; i++ ) {
			System.out.print(i+" + ");
			sum += i;
		}
		sum += i; // 마지막 숫자 추가로 더하기 
		System.out.print(i+ " = "+ sum); // i 찍어보면 마지막 숫자인 변수 num이 들어가있음
		// ?1. num7에서 끝나는데 i찍히는건 8이고 sum에는 8안들어가있음
	}	// ?2. i가 조건식 8보다 작아야되니 8자체 발동이 안되어야 하는게 아닌지? 
	
	
	
	public void practice6(){
		
//		사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
//		만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.println();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		int min = 0;
		int max = 0;

		
		if(num1 < 0 || num2 < 0) {
			System.out.println("1이상의 숫자를 입력해주세요");
		}else {
			if (num1 > num2) {
				max = num1;
				min = num2;
			} else if (num2 > num1) {
				max = num2;
				min = num1;
			}
		}

		
		while(true) {
			int i = 0;
			System.out.print(min + " ");
			i++;
//			if(i==max) {
//				break;
//			}
		}
		
		
		
	}
	
	public void practice7(){
//		위 문제와 모든 것이 동일하나, 1 미만의 숫자가 입력됐다면
//		“1 이상의 숫자를 입력해주세요”가 출력되면서 다시 사용자가 값을 입력하도록 하세요.

		
		
	}
	
	public void practice8(){
//		사용자로부터 입력 받은 숫자의 단을 출력하세요.
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		System.out.printf("===== %d단 =====%n", num);
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d%n",num,i,num*i);
		}	
		
	}
	
	public void practice9(){
//		사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
//		단, 9를 초과하는 숫자가 들어오면 “9 이하의 숫자만 입력해주세요”를 출력하세요
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num>=1 && num<=9) {
			System.out.printf("===== %d단 =====%n", num);
			for (int i=1; i<=9; i++) {
				System.out.printf("%d * %d = %d%n",num,i,num*i);
			}
		}else if (num>9) {
			System.out.println("9 이하의 숫자만 입력해주세요");
		}
			
	}
	
	public void practice10(){
//		위 문제와 모든 것이 동일하나, 9를 초과하는 숫자가 입력됐다면
//		“9 이하의 숫자를 입력해주세요”가 출력되면서 다시 사용자가 값을 입력하도록 하세요
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num>=1 && num<=9) {
			System.out.printf("===== %d단 =====%n", num);
			for (int i=1; i<=9; i++) {
				System.out.printf("%d * %d = %d%n",num,i,num*i);
			}
		}else if (num>9) {
			System.out.print("9 이하의 숫자만 입력해주세요 : ");
			num = sc.nextInt();
			if(num>=1 && num<=9) { 			// 숫자 재입력 후 구구단 실행
				System.out.printf("===== %d단 =====%n", num);
				for (int i=1; i<=9; i++) {
					System.out.printf("%d * %d = %d%n",num,i,num*i);
				}
			}	
		}
		
	}
	
	public void practice11(){
//		사용자로부터 시작 숫자와 공차를 입력 받아
//		일정한 값으로 숫자가 커지거나 작아지는 프로그램을 구현하세요.
//		단, 출력되는 숫자는 총 10개입니다 ( 공차 : 숫자들 사이에서 일정한 숫자의 차가 존재하는 것)
		
		System.out.print("시작 숫자 : ");
		int snum = sc.nextInt();
		System.out.print("공차 : ");
		int gnum = sc.nextInt();
		
		int j = snum;				// for문 안에서 돌면서 증가할 수의 변수 
		for(int i=0; i<10; i++) {	// 총 0~9 i가 10번 반복
			System.out.print(j+" ");
			j += gnum;
		}
		
		
		
	}
	
	public void practice12(){
//		정수 두 개와 연산자를 입력 받고 입력된 연산자에 따라 알맞은 결과를 출력하세요.
//		단, 해당 프로그램은 연산자 입력에 “exit”라는 값이 들어올 때까지 무한 반복하며
//		exit가 들어오면 “프로그램을 종료합니다.”를 출력하고 종료합니다.
//		또한 연산자가 나누기이면서 두 번째 정수가 0으로 들어오면
//		“0으로 나눌 수 없습니다. 다시 입력해주세요.”를 출력하며,
//		없는 연산자가 들어올 시 “없는 연산자입니다. 다시 입력해주세요.”라고 출력하고
//		두 경우 모두 처음으로 돌아가 사용자가 다시 연산자부터 입력하도록 하세요.
		


		while(true) {
			System.out.print("연산자(+,-,*,/,%) : ");
			String operator = sc.nextLine();
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			
			
			if(operator.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
				
			}else if(operator.equals("+")) {
				System.out.printf("%d + %d = %d",num1,num2,num1+num2);
			    
			}else if(operator.equals("-")) {
				System.out.printf("%d - %d = %d",num1,num2,num1-num2);
			}else if(operator.equals("*")) {
				System.out.printf("%d * %d = %d",num1,num2,num1*num2);
			}else if(operator.equals("/")) {
				System.out.printf("%d / %d = %d",num1,num2,num1/num2);
			}else if(operator.equals("%")) {
				System.out.printf("%d %% %d = %d",num1,num2,num1%num2);
			}
				
			
		}
//		while (operator.equals("exit")) {
//			System.out.println("프로그램을 종료합니다.");
//			break;
//		}
		
		
		// switch문
	}
	
	public void practice13(){
		
		
		
	}
	
	public void practice14(){
		
		
		
	}
	
	
	
	
}
