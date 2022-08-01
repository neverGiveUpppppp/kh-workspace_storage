package com.kh.practice.func.OperatorPractice;
import java.util.Scanner;


public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1(){
	 // 키보드로 입력 받은 하나의 정수가 양수이면 “양수다“, 양수가 아니면 “양수가 아니다“를 출력하세요.
		System.out.print("정수 : ");
		int number = sc.nextInt();
		// 삼항연산자
		System.out.println(number > 0 ? "양수다" : "양수가 아니다"); 
		 
	}
	 
	public void practice2(){
	// 키보드로 입력 받은 하나의 정수가 양수이면 “양수다“, 
	// 양수가 아닌 경우 중에서 0이면 “0이다“, 0이 아니면 “음수다”를 출력하세요	 
		System.out.print("정수 : ");
		int number = sc.nextInt();
		
		// 이중 삼항연산자
		System.out.println(number > 0 ? "양수다" : number == 0 ? "0이다" : "양수가 아니다"); 
		
		
	}
	 
	public void practice3(){
	// 키보드로 입력 받은 하나의 정수가 짝수이면 “짝수다“, 짝수가 아니면 “홀수다“를 출력하세
		System.out.print("정수 : ");
		int number = sc.nextInt();
		// 삼항연산자
		System.out.println((number % 2 == 0) ? "짝수다" : "홀수다");
		
	}
	 
	public void practice4(){
	// 모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고
	// 1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요 
	//	 인원수 사탕개수 1인1개 남은 사탕개수
		System.out.print("인원 수 : ");
		int numb1= sc.nextInt();
		System.out.print("사탕 개수 : ");
		int numb2= sc.nextInt();
		
		// println() + 강제 형변환
		System.out.println("1인당 사탕 개수 : " + (int)(numb2/numb1));
		System.out.println("남는 사탕 개수 : " + (numb2-(numb1*3)));
		// printf() + 강제 형변환
		System.out.printf("1인당 사탕 개수 : %d%n",(int)(numb2/numb1));
		System.out.printf("남는 사탕 개수 : %d",(numb2-(numb1*3)));
		
		
	}
	 
	public void practice5(){
	// 키보드로 입력 받은 값들을 변수에 기록하고 저장된 변수 값을 화면에 출력하여 확인하세요.
	// 이 때 성별이 ‘M’이면 남학생, ‘M’이 아니면 여학생으로 출력 처리 하세요.	
	// 변수기록
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		System.out.print("반(숫자만) : ");
		int classes = sc.nextInt();
		System.out.print("번호(숫자만) : ");
		int stunum = sc.nextInt();
		System.out.print("성별(M/F) : ");
		char ch = sc.next().charAt(0);
		String gender = (ch == 'M' ? "남학생" :"여학생");
		System.out.print("성적(소수점 아래 둘쨰자리까지) : ");
		float score = sc.nextFloat();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다",grade,classes,stunum,name,gender,score);
		
	}
	public void practice6(){
	// 나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	// 성인(19세 초과)인지 출력하세요	 
		System.out.print("나이 : ");
		int age = sc.nextInt();
		// 이중 삼항연산자
		System.out.println(age<=13 ? "어린이" : age<=19 ? "청소년" : "성인");
		
	}
	
	public void practice7(){
	// 국어, 영어, 수학에 대한 점수를 키보드를 이용해 정수로 입력 받고, 
	// 세 과목에 대한 합계(국어+영어+수학)와 평균(합계/3.0)을 구하세요.
	// 세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데
	// 세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, 아니라면 불합격을 출력하세요.
		System.out.print("국어 : ");
		int korean = sc.nextInt();
		System.out.print("영어 : ");
		int english = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		int sum = (korean+english+math);
		float avg = ((korean+english+math)/3);
		
		// 합계 평균 // 합격처리 // && 
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println(
				korean>=40 && english>=40 && math>=40 && avg>=60 ? "합격" : "불합격"
				);
	}
	 
	public void practice8(){
	
	// 주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요
		
		System.out.print("주민번호를 입력하세요(- 포함) : ");
		char identityNum = sc.nextLine().charAt(7);	// 0번부터 시작
		System.out.println(identityNum == '1' || identityNum == '3' ? "남자" : identityNum ==  '2'||identityNum == '4' ? "여자" : "잘못입력");
		
		
	}
	 
	public void practice9(){
	// 키보드로 정수 두 개를 입력 받아 각각 변수(num1, num2)에 저장하세요.
	// 그리고 또 다른 정수를 입력 받아 그 수가 num1 이하거나 num2 초과이면 true를 출력하고
	// 아니면 false를 출력하세요. (단, num1은 num2보다 작아야 함)
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int inputNum = sc.nextInt();
		
		System.out.println(inputNum <= num1 || inputNum > num2 ? "true" : "false");
		 
	}
	 
	public void practice10(){
	// 3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요. 	 
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		System.out.println(num1 == num2 && num1 == num3 ? "true" : "false");
		
		
	}
	 
	public void practice11(){
	// A, B, C 사원의 연봉을 입력 받고 각 사원의 연봉과 인센티브를 포함한 연봉을 계산하여 출력하고
	// 인센티브 포함 급여가 3000만원 이상이면 “3000 이상”, 미만이면 “3000 미만”을 출력하세요.
	// (A 사원의 인센티브는 0.4, B 사원의 인센티브는 없으며, C 사원의 인센티브는 0.15)	 
		 
	// 이고잉님 세금 코딩 적용시켜서 나중에 해보자
		System.out.print("A사원의 연봉 : ");
		int salary1 = sc.nextInt();
		System.out.print("B사원의 연봉 : ");
		int salary2 = sc.nextInt();
		System.out.print("C사원의 연봉 : ");
		int salary3 = sc.nextInt();
		float plusIncen1 = salary1+(salary1*0.4f);
		float plusIncen2 = salary2+(salary2*0);
//		float plusIncen3 = salary3+(salary3*0.15f); // float는 소수점이 자동으로 절삭?
//													// 결과값이2989.9999999999995되어야함
		double plusIncen3 = salary3+(salary3*0.15); 
		
		System.out.println(plusIncen3);			  // float는 정확성 때문에 자동반올림 값에러?doulbe로 바꿔도 안됨 
		System.out.printf("%.13f %n",plusIncen3); // 소수점 안맞음
		
		System.out.println();
		System.out.println("A사원의 연봉/연봉+a : " +salary1+"/"+plusIncen1);
		System.out.println(plusIncen1 >= 3000 ? "3000이상" : "3000미만");
		System.out.println("B사원의 연봉/연봉+a : " +salary1+"/"+plusIncen2);
		System.out.println(plusIncen2 >= 3000 ? "3000이상" : "3000미만");
		System.out.println("C사원의 연봉/연봉+a : " +salary1+"/"+plusIncen3);
		System.out.println(plusIncen3 >= 3000 ? "3000이상" : "3000미만");
		
		
	}
	 
}



