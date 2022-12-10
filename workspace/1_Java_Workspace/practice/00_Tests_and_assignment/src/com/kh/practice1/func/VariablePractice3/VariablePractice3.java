package com.kh.practice1.func.VariablePractice3;

import java.util.Scanner;

public class VariablePractice3 {
	
	public void method1() {
	// 키보드로 가로, 세로 값을 실수형으로 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 : ");
		float width = sc.nextFloat();
		System.out.print("세로 : ");
		double length = sc.nextDouble();
		
		// 방법1 : println()
		System.out.println("면적 : " + (width * length));
		System.out.println("둘레 : " + ((width + length)*2));
		
		// 방법2 : printf()
		System.out.printf("면적 : %.2f%n",width*length);
		System.out.printf("둘레 : %.1f" ,(width + length)*2);
		// 실수 소수라고 해서 %f를 쓰면 소수점 명령어랑 겹쳐서 안먹히니 %f빼고 %.1f로
	}
}
