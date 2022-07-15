package com.kh.variable;

//	형변환(Casting)
public class C_Cast {
	
	// 형변환에서 제외가 되는 기본 자료형 : boolean
	
	// 형변환의 종류
	// 1.자동 형변환
	// 2.강제 형변환
	
	// 1.자동 형변환
	public void cast1() {
	// 	 1)정수끼리 자동 형변환
		byte bNum = 3;
		int iNum = bNum; // 자동 형변환
	//	 2)정수와 실수끼리의 자동 형변환
		long lNum = 100;// long으로 int로 자동 형변환
		byte b1 = 10;	// 4byte 정수 10 // byte 크기가 안맞는데, no error? byte저장 가능범위 : -128~127
//		byte b2 = 10L;  // 8byte 정수 10 // 1byte인 b2에 8byte짜리를 넣을려해서 error
						// byte의 저장 가능 범위(-128~127)를 넘어섰기에 에러
						// 리터럴. 값 유동적일 수 있음. int가 4byte이긴 하지만 리터럴이기 때문에 
						// 내가 받을 수 있는 범위 안에 들어오느냐를 먼저 확인해 볼 수 있음. 변수가 아니기에 각 데이터별 범위 안에만 있으면 허용가능
						// 각 데이터타입이 받을 수 있는 범위(변수 저장가능범위)부터 체크 데이터 타입 체크
	//   3)정수와 문자끼리의 자동 형변환
		int num = 'A';
		char ch = 97;
		System.out.println("num : " + num);
		System.out.println("ch : " + ch);
		
//		char ch2 = num; // error :Type mismatch: cannot convert from int to char
		char ch2 = (char)num; // 강제 형변환 
		// 위에서 int num = 'A'는 잘run되고 결과값65를 얻었는데 왜 안될까?
		// 'A'는 리터럴이고 num은 변수. 리터럴이기에 변수저장 가능범위가 맞으면 형변환이 가능했던 것
		
		int num1 = -10;
		char ch3 = (char)num1;
		System.out.println("ch3 : " + ch3); // 아스키코드 변환 ?가 아닌 어떤 문자로 매치될지 진짜 몰라서 나오는 ?
	
	}
		
		
	// 2.강제 형변환
	public void cast2() {
		int iNum = 10;
		long lNum = 100L;
		
//		int result = iNum + lNum;	// 작은게 큰거를 따라감. int가 long으로 자동변환 되는데 담기는 그릇이 int라 error
		// iNum이 long으로 자동 형변환이 되어 계산 결과가 long타입이 되는데 그 값을 int에 넣으려하기 때문
		
		
		// 방법1. 수행 결과를 int로 강제 형변환
		int result1 = (int)(iNum + lNum);	// 계산순서 1. (iNum + lNum) 2. (int) 형변환
		
		// 방법2. long형 값을 int로 강제 형변환
		int result2 = iNum + (int)lNum;
		
		// 방법3. 결과값을 long형의 자료형으로 받기
		long result3 = iNum + lNum;
		
		
		
	}
	
	
	
	int a = 12;
	double d = 3.3;
	int result = a + (int)d; // 강제 형변환
	
	int i = (int)d; 
	
}
