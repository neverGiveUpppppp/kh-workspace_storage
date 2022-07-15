
package com.kh.variable;

public class D_PrintMethod {
	public void printlnMethod() {
		
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		System.out.println(str1);
		System.out.println(str2);
		
	
	}
	public void printMethod() {
		String str1 = "안녕하세여";
		String str2 = "반갑습니다";
		System.out.print(str1);
		System.out.print(str2);
		System.out.println();
	}
	public void printfMethod() {
		String str1 = "안녕하세여";
		String str2 = "반갑습니다";
		// %s : 문자열 	%d : 정수 	%c : 문자
		// %b : 논리값	%f : 실수		
		
		// 안녕하세요, 강건강입니다. 반갑습니다.
		System.out.printf("%s, 강건강입니다. %s.\n",str1,str2);
		// 반갑습니다, 친하게 지내요.
		System.out.printf("%s, 친하게 지내요.%n", str2);
		System.out.printf("%s, %s.\n",str2, "친하게 지내요");
								// args1 	args2
		// homework
		// 안녕하세요, 저는 20살 박신우 강사입니다. 만나서 반갑습니다.
		int age = 20;
		String name = "박신우";
		String job = "강사";
		System.out.printf("안녕하세요, 저는 %d살 %s %s입니다. 만나서 반갑습니다.%n",age,name,job);
		System.out.printf("%s, 저는 %d살 %s %s입니다. 만나서 %s.%n",str1,age,name,job,str2);
		System.out.print(str1+", 저는 "+age+"살 "+name+" "+job+"입니다 만나서"+str2+".\n");
		
	}	
	public void stringExample() {
		
		String str1 = "행복하세요";
		String str2 = "건강하세요";
		int num1 = 10;
		int num2 = 20;
		
		
		String str3 = str1 + str2;    	// 결과값 : 행복하세요건강하세요
		System.out.println(str3);	  	// 변수 저장 후 변수를 출력
		System.out.println(str1+str2);	// 변수 저장 없이 출력 후 휘발
		
		int num3 = num1 + num2; 	  	// 결과값 : 30
		System.out.println(num3);
		System.out.println(num1 + num2);
		
		System.out.println(str1 + num1);// 결과값 : 행복하세요10
		System.out.println(num2 + str2);// 결과값 : 20건강하세요
		
		// 문자열+문자열=문자열
		// 문자열+숫자 = 문자열
		// 숫자+문자열 = 문자열
		System.out.println(str1 + num1 + num2);  // 결과값 : 행복하세요1020
		System.out.println(num1 + str1 + num2);  // 결과값 : 10행복하세요20
		System.out.println(num1 + num2 + str1);  // 결과값 : 30행복하세요
		
		System.out.println(str1 + (num1 + num2));// 결과값 : 행복하세요30
		
	}
		
		
		
	
}