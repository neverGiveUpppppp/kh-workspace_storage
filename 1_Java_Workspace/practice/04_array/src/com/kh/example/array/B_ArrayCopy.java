package com.kh.example.array;
import java.util.Arrays;
import java.util.Scanner;


// 1.얕은 카피(shallow copy)
// 2.깊은 카피(deep copy)


public class B_ArrayCopy {
	Scanner sc = new Scanner(System.in);
	public void method01() {
		
		
		// 1.얕은 카피(shallow copy) 
		
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = originArr;
		
		System.out.println(originArr);  // 결과값 : [I@74a14482
		System.out.println(copyArr);	// 결과값 : [I@74a14482
		System.out.println();
		
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");
		}
		System.out.println();
		System.out.println();
		
		// 원본 배열값 변경
		originArr[0] = 99;
		
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" ");
		}
		System.out.println();
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");
		}
		System.out.println();
		// 변경된 값이 똑같이 반영
		
		
	}
	
	
	public void method02() {
		
		// 2.깊은 카피(deep copy) 
		// 	  1) for문 이용
		
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = new int[5];
		
		System.out.println(originArr); // 결과값 : [I@677327b6
		System.out.println(copyArr);   // 결과값 : [I@14ae5a5 
		
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" "); // 1 2 3 4 5 
		}
		System.out.println();
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" "); // 0 0 0 0 0 
		}
		System.out.println();
		System.out.println();
		
		// deep copy 실행
		for(int i=0; i<originArr.length; i++) {
			copyArr[i] = originArr[i]; 
		}
		// 카피한 배열 프린트문으로 출력
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" "); // 1 2 3 4 5 
		}
		System.out.println();
		
		
		//
		
		
		originArr[0] = 99;
		
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" "); // 99 2 3 4 5 
		}
		System.out.println();
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");  // 1 2 3 4 5 
		}
		System.out.println();
		System.out.println();
		
	}
	
	public void method03() {
		
		
		// 2.깊은 카피(deep copy) 
		// 	  2)System.arraycopy()

		
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = new int[10];
		
//		System.arraycopy()
//		System.arraycopy(src, srcPos, dest, destPos, length);
		// src : 원본 배열
		// srcPos : 원본포지션. 원본배열에서 복사를 시작할 위치
		// dest : 복사 배열
		// destpos: 복사 배열에서 붙여놓기를 시작할 위치
		// length : 얼만큼 복사를 해올지에 대한 복사 길이
		
		
		// 원본 배열의 0(index)번째부터 원본배열 길이만큼 복사한 것을 복사 배열 3번쨰서부터 붙여넣기
		// System.arraycopy(src, srcPos, dest, destPos, length);
		
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
		// 인덱스 3번째부터 넣기에 앞의 셋은 000이고 오리진arr5개값 뺴고 나머지도 0으로 채워짐
		
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");
		}
		
		// 코드 뜯어보는 방법
		// ctrl 누른 상태에서 밑줄이 생기는곳
		// 변수명 밑줄 생기면 클릭. 내가 쓴거 어디있는지 찾아주는 기능
		// system.class창이 새로뜬다
		// 원래는 클래스파일 뜯어볼 수 없지만 수정 불가한 형태로 이 코드들을 볼 수 있음
		
		
	}
	
	public void method04() {
		
		// 3) Arrays.copyof()
		
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = new int[10];
		
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");
		}
		System.out.println();
		
		
		// Arrays.copyof()
		// Arrays.copyOf(original, newLength)
		// original : 원본
		// newLength : 얼마만큼 복사할지
		
		Arrays.copyOf(originArr, originArr.length);
		
		// Arrays.copyOf 위에 마우스 포인터 올리고 나오는 '노란색 설명'
		// int[] java.util.Arrays.copyOf(int[] original, int newLength)
		// java util.Arrays
		// 맨 앞에 값 int[]의 의미: 반환값 데이터타입이 무엇인지 알려줌. 즉 int[] 인트 배열을 반환함
		
		
		copyArr = Arrays.copyOf(originArr, originArr.length); //copyArr에 담음 
		
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" "); // 1 2 3 4 5 
		}
		System.out.println();
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");   // 1 2 3 4 5
		}
		System.out.println();
		
		// 원본 배열값 변경
		originArr[0] = 99;
		for(int i=0; i<originArr.length; i++) {
			System.out.print(originArr[i]+" "); // 99 2 3 4 5 
		}
		System.out.println();
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");   // 1 2 3 4 5
		}
		System.out.println();
		
		// ctrl 누르고 copyof() 위로가서 class파일  코드 뜯어보자
		
		// 메소드 전달값 - 연산 - 반환값
		// 곧 클래스와 메소드, 변수의 작동원리와 인자 & 매개변수의 원리,흐름,메커니즘을 이해할 것
		// 이것이 활용,확장,응용 될 것
		// ★★★ 메소드 안에서의 흐름 : 받아오고 연산하고 내보내고 ★★★
		
		
	}
	
	
}

