package com.kh.practice1.func.VariablePractice1;
import java.util.Scanner;

public class VariablePractice1 {
	
	public void method1() {
	
	// 이름, 성별, 나이, 키를 사용자에게 입력 받아 각각의 값을 변수에 담고 출력하세요.
	Scanner sc = new Scanner(System.in);
	System.out.print("이름을 입력하세요 : ");
	String name = sc.nextLine();
	System.out.print("성별을 입력하세요(남/여) : ");
	char gender = sc.nextLine().charAt(0);
	System.out.print("나이을 입력하세요 : ");
	int age = sc.nextInt();
	System.out.print("키를 입력하세요 : ");
	float height = sc.nextFloat();
	// 방법1 : println()
	System.out.println("키 "+height+"cm인 "+age+"살 "+gender+"자 "+name+"님 반갑습니다^^");
	// 방법2 : prinf() 
	System.out.printf("키 %.1fcm인 %d살 %c자 %s님 반갑습니다^^",height,age,gender,name); // 소수점 출력은 %.1f : %f와 같이사용x
	
	
	
	}
}
