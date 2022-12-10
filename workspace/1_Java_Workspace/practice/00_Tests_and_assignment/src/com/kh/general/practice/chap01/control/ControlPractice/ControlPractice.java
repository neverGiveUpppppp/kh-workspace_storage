package com.kh.general.practice.chap01.control.ControlPractice;
import java.util.Scanner;
public class ControlPractice {
	
	Scanner sc = new Scanner(System.in);
	public void practice1(){
	// 아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 “OO메뉴입니다“를,
	// 종료 번호를 누르면 “프로그램이 종료됩니다.”를 출력하세요	
		
		// 딕셔너리
		String input = "입력";
		String modify = "수정";
		String lookUP = "조회";
		String del = "삭제";
		String terminate = "종료";
		
		System.out.println("1."+input);
		System.out.println("2."+modify);
		System.out.println("3."+lookUP);
		System.out.println("4."+del);
		System.out.println("7."+terminate);
		System.out.print("메뉴 번호를 입력하세요 : ");
		int menu = sc.nextInt();
		
		if (menu == 1) {
			System.out.printf("%s 메뉴입니다.",input);
		}else if (menu == 2) {
			System.out.printf("%s 메뉴입니다.",modify);
		}else if (menu == 3) {
			System.out.printf("%s 메뉴입니다.",lookUP);
		}else if (menu == 4) {
			System.out.printf("%s 메뉴입니다.",del);
		}else if (menu == 7) {
			System.out.println("프로그램이 종료됩니다");
		}
		
	}
	
	public void practice2(){
		
	// 키보드로 정수를 입력 받고, 입력한 정수가 양수이면서 짝수일 때만 “짝수다”를 출력하고
	// 짝수가 아니면 “홀수다“를 출력하세요.
	// 양수가 아니면 “양수만 입력해주세요.”를 출력하세요.
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		if(num > 0 && num%2 == 0) {
			System.out.println("짝수다");
		}else if(num <= 0) {
			System.out.println("양수만 입력해주세요");
		}else {
			System.out.println("홀수다");
		}
	}
	
	public void practice3(){
	// 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
	// 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
	// (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
	// 합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고
	// 불합격인 경우에는 “불합격입니다.”를 출력하세요	
		
		System.out.print("국어점수 : ");
		int korean = sc.nextInt();
		System.out.print("영어점수 : ");
		int english = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		float avg = sum/3;
		
		if (korean>=40 && english>=40 && math>=40 && avg>=60) {
			System.out.println("국어 : " + korean);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + english);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		}else {
			
//			System.out.println("국어점수 : " + korean);
//			System.out.println("수학점수 : " + math);
//			System.out.println("영어점수 : " + english);
			System.out.println("불합격입니다.");
		}
		
	}
	
	public void practice4(){
	// 수업 자료(7page)에서 if문으로 되어있는 봄, 여름, 가을, 겨울 예제를 
	// switch문으로 바꿔서 출력하세요.	
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int num = sc.nextInt();
		String season = "";
		
		switch (num) {
			case 1 : season = "겨울"; break; 
			case 2 : season = "겨울"; break;
			case 3 : season = "봄"; break;
			case 4 : season = "봄"; break;
			case 5 : season = "봄"; break;
			case 6 : season = "여름"; break;
			case 7 : season = "여름"; break;
			case 8 : season = "여름"; break;
			case 9 : season = "가을"; break;
			case 10 : season = "가을"; break;
			case 11 : season = "가을"; break;
			case 12 : season = "겨울"; break;
			default : season = "잘못 입력된 달";
		}
		System.out.printf("%d월은 %s입니다.",num,season);
		
		// 다른 코드
//		System.out.print("1~12 사이의 정수 입력 : ");
//		int num = sc.nextInt();
//		
//		switch (num) {
//			case 1 : System.out.printf("%d월은 겨울입니다.",num); break; 
//			case 2 : System.out.printf("%d월은 겨울입니다.",num); break;
//			case 3 : System.out.printf("%d월은 봄입니다.",num); break;
//			case 4 : System.out.printf("%d월은 봄입니다.",num); break;
//			case 5 : System.out.printf("%d월은 봄입니다.",num); break;
//			case 6 : System.out.printf("%d월은 여름입니다.",num); break;
//			case 7 : System.out.printf("%d월은 여름입니다.",num); break;
//			case 8 : System.out.printf("%d월은 여름입니다.",num); break;
//			case 9 : System.out.printf("%d월은 가을입니다.",num); break;
//			case 10 : System.out.printf("%d월은 가을입니다.",num); break;
//			case 11 : System.out.printf("%d월은 가을입니다.",num); break;
//			case 12 : System.out.printf("%d월은 겨울입니다.",num); break;
//			default : System.out.printf("%d월은 잘못 입력된 달입니다.",num);
//		}	
	}
	
	public void practice5(){
	// 아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
	// 로그인 성공 시 “로그인 성공”, 
	// 아이디가 틀렸을 시 “아이디가 틀렸습니다.“,
	// 비밀번호가 틀렸을 시 “비밀번호가 틀렸습니다.”를 출력하세요.
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		

		
		// == : 기본형사용, 주소값 비교
		// .equals() : 참조형사용, 값 자체 비교
		if(id.equals("myId") && pw.equals("myPassword12")) {
			System.out.println("로그인 성공");
		} else if(id.equals("myId")) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.println("아이디가 틀렸습니다.");
		}

		
		// 다른 방법 : 중첩if문
//		if(id.equals("myId")) {
//			if(pw.equals("myPassword12")) {
//				System.out.println("로그인 성공");
//			} else {
//				System.out.println("비밀번호가 틀렸습니다.");
//			}
//		} else {
//			System.out.println("아이디가 틀렸습니다.");
//		}
		// 변수화
//		String rightId = "myId";
//		String rightPw = "myPassword12";
// 		if(id == rightId && pw == rightPw ) {
//			System.out.println("로그인 성공");
//		} else if(id == rightId) {
//			System.out.println("비밀번호가 틀렸습니다.");
//		} else {
//			System.out.println("아이디가 틀렸습니다.");
//		}
		
	}
	
	public void practice6(){
	// 사용자에게 관리자, 회원, 비회원 중 하나를 입력 받아 각 등급이 행할 수 있는 권한을 출력하세요.
	// 단, 관리자는 회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
	// 회원은 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
	// 비회원은 게시글 조회만 가능합니다.	
		
		
		// == : 기본형사용, 주소값 비교
		// .equals() : 참조형사용, 값 자체 비교
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String auth = sc.nextLine();
		
		String manager = "관리자";
		String member = "회원";
		String nonMemer = "비회원";
		
		if (auth.equals(manager)) {
			System.out.println("회원관리, 게시글관리 게시글 작성, 댓글 작성 게시글 조회");
		} else if (auth.equals(member)) {
			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
		} else if (auth.equals(nonMemer)){
			System.out.println("게시글 조회");
		}
		
		
	}
	
	public void practice7(){
		// 키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라
		// 저체중/정상체중/과체중/비만을 출력하세요.
		// BMI = 몸무게 / (키(m) * 키(m))
		// BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
		// BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
		// BMI가 30이상일 경우 고도 비만
		
		System.out.print("키(cm)를 입력해주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해주세요 : ");
		double weight = sc.nextDouble();
		
		double BMI = weight/(height*height);
		
		String lowWei = "저체중";
		String rightWei = "정상체중";
		String overWei = "과체중";
		String ooverWei = "비만";
		String beyondWei = "고도비만";
		
		System.out.printf("BMI 지수 : %.14f%n",BMI);
		if (BMI < 18.5) {
			System.out.println(lowWei);
		}else if (BMI < 23) {
			System.out.println(rightWei);
		}else if (BMI < 25) {
			System.out.println(overWei);
		}else if (BMI < 30) {
			System.out.println(ooverWei);
		}else {
			System.out.println(beyondWei);
		}
		
	}
	
	public void practice8(){
		// 키보드로 두 개의 정수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
		// (단, 두 개의 정수 모두 양수일 때만 작동하며 없는 연산 기호를 입력 했을 시
		// “잘못 입력하셨습니다. 프로그램을 종료합니다.” 출력)
		
		System.out.print("피연산자1 입력 : ");
		int operand1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int operand2 = sc.nextInt();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		String operator = sc.next();
		
		int plus = operand1 + operand2;
		int minus = operand1 - operand2;
		int multiply = operand1 * operand2;
		double divide = (double)operand1 / (double)operand2;    // 인트 인트 나누기하면 값이 잘못나온다
		double remainder = (double)operand1 % (double)operand2;	// 정수는 실수로 바꿔주고 나누기 진행한다
		
		
		if(operand1>0 && operand2>0 
				&& operator.equals("+") || operator.equals("-") || operator.equals("*")|| operator.equals("/") || operator.equals("%")) {
			if(operator.equals("+"))	 {
				System.out.printf("%d + % d = %d",operand1,operand2,plus);
			} else if (operator.equals("-")) {
				System.out.printf("%d - % d = %d",operand1,operand2,minus);
			} else if  (operator.equals("*")) {
				System.out.printf("%d * % d = %d",operand1,operand2,multiply);
			} else if  (operator.equals("/")) {
				System.out.printf("%d / % d = %.6f",operand1,operand2,divide);
			} else if  (operator.equals("%")) {
				System.out.printf("%d %% %d = %f",operand1,operand2,remainder);
			}				// %의 출력은 %% 입력	
			
				
		}
			
		}
//		double arithmetic = operand1 operator operand2
		
//		System.out.printf("%d %d % d = %f",operand1,operator,operand2);
		
	
//	switch(operator) {
//	case "+" : {
//		int plus = operand1 + operand2;
//	}
////		System.out.printf("%d + % d = %f",operand1,operand2,plus);
//		break;
//	case "-" : int minus = operand1 - operand2;
//		break;
//	case "*" : int multiply = operand1 * operand2;
//		break;
//	case "/" : int divide = operand1 / operand2;
//		break;
//	case "%" : int remainder = operand1 % operand2;
//	}
	
	public void practice9(){
		
		// 중간고사, 기말고사, 과제점수, 출석회수를 입력하고 Pass 또는 Fail을 출력하세요.
		// 평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
		// 이 때, 출석 비율은 출석 회수의 총 강의 회수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
		// 70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.

		System.out.print("중간 고사 점수 : ");
		int midterm = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int finals = sc.nextInt();
		System.out.print("과제 점수 : ");
		int score = sc.nextInt();
		System.out.print("출석 회수 : ");
		int attendance = sc.nextInt();
		
		double mid_proportion = midterm*0.2;	// 20%를 치환하면 *0.2
		double finals_proportion = finals*0.3;
		double score_proportion = score*0.3;
		double attendance_proportion = (100/20)*attendance*0.2;
		double sum = mid_proportion+finals_proportion+score_proportion+attendance_proportion;
		
//		100/20*attendance <= 0.7 ?
		
		System.out.println("================= 결과 =================");

		
		if(sum>=70) {
			System.out.printf("중간 고사 점수(20) : %.1f%n",mid_proportion);
			System.out.printf("기말 고사 점수(30) : %.1f%n",finals_proportion);
			System.out.printf("과제 점수            (30) : %.1f%n",score_proportion);
			System.out.printf("출석 점수            (20) : %.1f%n",attendance_proportion);
			System.out.printf("총점 : %.1f%n",sum);
			System.out.println("PASS");
		}else if (attendance*(100/20) <= 70 ) { // 비율 계산의 0.7이 아닌 출　　
			System.out.printf("Fail [출석 회수 부족 (%d/20)]",attendance);
		}else if (sum<70) {
			System.out.printf("중간 고사 점수(20) : %.1f%n",mid_proportion);
			System.out.printf("기말 고사 점수(30) : %.1f%n",finals_proportion);
			System.out.printf("과제 점수            (30) : %.1f%n",score_proportion);
			System.out.printf("출석 점수            (20) : %.1f%n",attendance_proportion);
			System.out.printf("총점 : %.1f%n",sum);
			System.out.println("Fail [점수 미달]");
		}
//		System.out.printf("중간 고사 점수(20) : %.1f%n",mid_proportion);
//		System.out.printf("기말 고사 점수(30) : %.1f%n",finals_proportion);
//		System.out.printf("과제 점수            (30) : %.1f%n",score_proportion);
//		System.out.printf("출석 점수            (20) : %.1f%n",attendance_proportion);
//		System.out.printf("총점 : %.1f%n",sum);
	}
	
	
	public void practice10(){
		// 앞에 구현한 실습문제를 선택하여 실행할 수 있는 메뉴화면을 구현하세요
		
		
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		
		
		System.out.print("선택  : ");
		int menu = sc.nextInt();
		practice4();
		
	}
}
