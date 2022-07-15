package com.kh.example.array;
import java.util.Scanner;

public class A_Array {

	
	Scanner sc = new Scanner(System.in);
	public void method01() {
		
		// 10, 20, 30, ...,90 변수에 값 저장 : num1,num2
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		int num6 = 60;
		int num7 = 70;
		int num8 = 80;
		int num9 = 90;
		
		
		int sum1 = 0;
		sum1 += num1;
		sum1 += num2;
		sum1 += num3;
		sum1 += num4;
		sum1 += num5; 
		sum1 += num6;
		sum1 += num7;
		sum1 += num8;
		sum1 += num9;
		sum1 = num1+num2+num3+num4+num5+num6+num7+num8+num9;

		
		// 배열array 선언
		// num1 ~ num9까지 묶을 것 = 배열 : 모두 같은 자료형(int)이어서 배열로 묶을 수 있다
		// int값이 9개 들어갈 수 있는 배열 arr 생성
		
		
		int[] arr = new int[9];
		System.out.println(arr);	// 결과값 : (주소값) [I@2a139a55
									// 주소값이 이렇게 생기지 않음. C는 주소를 볼 수 있으나 자바는 숨겨둠.
									// 실제적인 주소값은 아니나 자바가 노출시키고 싶지않아서 저런식으로 출력한 것
		// 실제 값을 보고싶다면?
		// array의 인덱스 번호를 찍으면 개별적으로 볼 수 있다
		System.out.println(arr[0]); // 결과값 : 0
		System.out.println(arr[1]); // 결과값 : 0
		System.out.println(arr[2]); // 결과값 : 0
		System.out.println(arr[3]); // 결과값 : 0
		System.out.println(arr[4]); 
		System.out.println(arr[5]); 
		System.out.println(arr[6]); 
		System.out.println(arr[7]); 
		System.out.println(arr[8]); 
//		System.out.println(arr[9]); // 10번째 없는 배열을 불러서 에러
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////	

		
		// 배열 값 초기화
		// 1. 인덱스 이용
		// 2. 중괄호 {} 이용
		// 3. for문 이용
		
		
		
		// 배열 값 초기화
		// 1. 인덱스 이용
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 60;
		arr[6] = 70;
		arr[7] = 80;
		arr[8] = 90;
		
		System.out.println();
		
		
		
		// 2.중괄호()를 이용
		// 선언과 동시에 초기화 가능
		
		int[] arr2 = {1,2,3,4};			  		  // 선언 & 초기화
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		String[] arr3 = {"apple","b","g"}; 		 // 문자열 배열 초기화
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		int[] arr4 = new int[] {11,22,33,44,55}; // 중괄호 앞 new int[] 생략가능
		for(int i=0; i<arr4.length; i++) {
			System.out.println(arr4[i]);
		}
		
		
		// 3.for문 이용
		
		for(int i=0; i< arr.length; i++) {
			arr[i] = (i + 1) * 10;
			System.out.println(arr[0]);
		}
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
			
		
		
		
		
	}
	
	public void method02() {
		
		// 배열 생성시 주의사항
		
		// 배열 선언
		// Stack 영역에 공간 생성
		int[] iArr;	   // 배열 선언
		char chArr[];  // 대괄호 []는 데이터타입, 변수명 뒤 둘다 가능
		// char chArr[];면 두번쨰 변수사용시에 chArr = new char[10];로. 
		// chArr[]이 있다고해서 변수명 호출 때도 []붙이는건 아님
		
		
//		System.out.println(iArr); // stack 공간만 만든거기에 실제 데이터 저장된게 아니기에 호출하면 에러. 
								  // heap영역에 주소값이 없어서 에러? 스택에만 있고
		
		
		
		// 배열 할당
		// heap 영역에 공간 생성
		iArr = new int[5];
		chArr = new char[10]; // 배열의 선언과 할당 분리 가능
		
		int[] iArr2 = new int[5];
		char[] chArr2 = new char[10];
		

		
		
		//사용자에게 입력 받은 정수로 배열 길이를 지정한 double 배열 dArr생성
		
		System.out.print("새로 할당할 배열의 길이 입력 : ");
		int size = sc.nextInt();
		
		double[] dArr = new double[size];
		System.out.println("dArr의 길이 : "+dArr.length);
		System.out.println("dArr의 주소값 : "+ dArr); // [D@74a14482
		
		dArr = new double[5];
		System.out.println("변경 후 dArr의 길이 : " + dArr.length);// 배열 길이 변경 가능
		System.out.println("변경 후 dArr의 주소값 : " + dArr);		 // but 길이 변경 후 주소값 달라짐 [D@1540e19d
		System.out.println();								 // 
		// 주소값하면 new 연산자가 떠올라야. 
		// dArr[30]에서 new연산자가 쓰이면서 새로운 공간생성과 함께 주소값 생성하기에 주소값이 달라짐
		//
		// 배열은 크기 변경 불가
		//
		// 새로운 배열을 만들고 바꿔치기하는 것일 뿐
		// 그래서 주소값이 바뀌는 것(0x100→0x200)
		//기존 배열 유지x
		// new연산자에 의해 heap영역에 새로운 배열의 공간이 생성되고 
		// 그에 따라 stack에 있는 변수명 dArr의 참조 변수값(주소값)도 0x100→0x200 바뀜
		
		
		
		// 배열 삭제
		dArr = null;
		// null을 넣으면 0x100→0x200 바뀐주소가 null로 바뀌면서 
		// 0x200과 연결이 끊어지면서 0x200의 데이터는사리지고 사실상 삭제 효과가 나타난다
		
		
	}
	
	public void method03() {
		
		
		
	}
	
	
	
}
