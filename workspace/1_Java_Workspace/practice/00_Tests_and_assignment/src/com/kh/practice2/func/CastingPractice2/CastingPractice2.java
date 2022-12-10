package com.kh.practice2.func.CastingPractice2;

import java.util.Scanner;

public class CastingPractice2 {
	
	public void method1() {
		
	// 실수형으로 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	// 이 때 총점과 평균은 정수형으로 처리하세요.
	
		// 실수 입력3칸 총점,평균 정수처리
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 : ");
		float score1 = sc.nextFloat();
		System.out.print("영어 : ");
		float score2 = sc.nextFloat();
		System.out.print("수학 : ");
		double score3 = sc.nextDouble();
		
		// 방법1 : println() + 강제 형변환(int) 
		System.out.println("총점 : "+ (int)(score1+score2+score3)); // (int)
		System.out.println("평균 : "+ (int)((score1+score2+score3)/3));
		
		// 방법2 : printf()
		System.out.printf("총점 : %.0f%n",score1+score2+score3);
		System.out.printf("평균 : %.0f%n",(score1+score2+score3)/3);
		
		// 방법3 : printf() + 강제 형변환(int)
		System.out.printf("총점 : %d%n",(int)(score1+score2+score3));
		System.out.printf("평균 : %d",(int)((score1+score2+score3)/3));
	}
}
