

import java.util.Scanner;
public class oneday_Pratice_Scanner {

	public static void main(String[] args) {
		
		
		int num1 = 0;
		int num2 = 0;
				
		Scanner sc = new Scanner(System.in); //  System.in : 입력한 값을 바이트 단위로 읽는 것을 의미
		
		System.out.print("첫째 정수 : ");
		num1 = sc.nextInt();
		System.out.print("둘째 정수 : ");
		num2 = sc.nextInt();
		
		System.out.println("첫번째 정수 : " + num1);
		System.out.println("두번째 정수 : " + num2);
		System.out.print("두 수의 합 : ");
		System.out.println(num1+num2);
//		
//		int numm = sc.nextInt();
//		
//		sc.close();  // leak이 일어 날 수 있으므로 닫아주자
		
//		// 빈공간 sc입력후 ctrl+space치면 자동 스캐너 자동임포트 및 스니펫 작동
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = 0;
//		float num2 = 1.0f;
//		String str1 = "str1";
//		String str2 = "str2";
//		
//		
//		System.out.print("입력1(정수만) : ");
//		num1 = sc.nextInt();				  // int입력만
//		System.out.print("입력2(공백전) : ");
//		str1 = sc.next();                     // 공백 전까지 입력받음
//		System.out.print("입력3(한줄전체) : ");
//		str2 = sc.nextLine();                 // 한 줄 전체 입력받음
//		num2 = sc.nextFloat();				  // float타입만 입력받음
		
//		System.out.println("입력1(정수만) : "+num1);
//		System.out.println("입력2(문자열만) : "+str1);
//		System.out.println("입력3(문자열만) : "+str2);
	}
		
}
