package com.kh.example;
import java.util.Arrays;

public class Array_review2 {
	public static void main(String[] args) {
		
		// 배열
		// 같은 자료형의  여러  데이터 값을 저장할 수 있는 공간
		
		// 배열 선언
		int[] arr;
		
		// 배열 할당
		int[] arr2 = new int[3];
		int arr3[] = new int[3];
		
		// 배열 초기화
		// 1)인덱스
		// 2)중괄호 {}
		// 3)for문 이용
		
		// 1)인덱스
		arr2[0] = 1;
		arr2[1] = 2;
		arr2[2] = 3;
		
		// 2)중괄호 {}
//		int arr3[] = {1,2,3}; // error
		int[] arr4 = {4,5,6};
//		arr4 = {1,2,3}; // error
		char[] arr5 = {'A','B'};
		
		// 3)for문
		// 초기화할 값에 ‘규칙’이 존재할 경우 사용가능
//		char[] Arr = new char[3]; // for문 인덱스 이용한거라 int만 가능
		int[] Arr2 = new int[3];
		for(int i=0; i<Arr2.length; i++) {
			System.out.print(Arr2[i]+" "); // 0 0 0
		} // 배열값을 안 넣어놔서 int의 기본값인 0 출력됨
		System.out.println();
		
		int[] Arr3 = new int[4];
		for(int i=0; i<Arr3.length; i++) {
			Arr3[i] = i+1;
			System.out.print(Arr3[i]+" "); // 1 2 3 4
		} // 배열값을 안 넣어놔서 int의 기본값인 0 출력됨
		System.out.println();
		
		
		// 배열 수정(크기 변경)?
		int[] aaa = new int[2];
		aaa[0] = 0;
		aaa[1] = 1;
		
		System.out.println(aaa);//[I@6d06d69c
		
		aaa = new int[3];
		System.out.println(aaa);//[I@7852e922
		
		// 다른 주소값이 나왔다. 보이기에는 길이가 수정된 것처럼 보이나
		// 실제로는 새로 만든 값으로 대체시킨 것
		
		
		// 배열 삭제
		aaa = null;
		System.out.println(aaa);
		
		Arr3 = null;
		System.out.println(Arr3);
		
		
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
		
		
		// 배열 복사
		// 1)얕은 복사(shallow copy)
		// 2)깊은 복사(deep copy)
		
		// 1)얕은 복사(shallow copy)
		String[] str1 = new String[3];
		String[] str2 = str1;
		
		// arr5의 주소값이 arr6로 그대로 들어가기 때문에 주소값 자체도 복사된다
		// 즉 arr5와 arr6는 같은 주소값을 갖으며,
		// 같은 주소값을 참조하기에 같은 값을 공유하게 된다
		
		// 검증
		System.out.println(str1);//[Ljava.lang.String;@4e25154f
		System.out.println(str2);//[Ljava.lang.String;@4e25154f
		// 같은 주소값 확인

		str1[0] = "A";
		str1[1] = "b";
		str1[2] = "b";

		for(int i=0; i<str1.length; i++) {
			System.out.print(str1[i]+" "); // A b b
		}
		System.out.println();
		for(int i=0; i<str2.length; i++) {
			System.out.print(str2[i]+" "); // A b b
		}
		System.out.println();
		// 원본과 클론 배열 둘의 주소값,값이 동일
		
		// 원본 값을 바꿔서 둘의 차이가 있는지 확인해보자
		str1[1] = "asdf";
		
		for(int i=0; i<str1.length; i++) {
			System.out.print(str1[i]+" "); // A asdf b 
		}
		System.out.println();
		for(int i=0; i<str2.length; i++) {
			System.out.print(str2[i]+" "); // A asdf b 
		}
		System.out.println();
		// 원본과 클론 배열 둘의 주소값,값이 여전히 동일
		
		
		//2)깊은 복사
		// 새로운 배열을 만들어 기존 데이터를 모두 복사해오는 것
		// 방법1:for문
		// 방법2:System.arraycopy()
		// 방법3:Arrays.copyOf()
		
		// 방법1:for문
		int[] srcArr1 = {5,10,15};
		int[] copyArr1 = new int[4];
		
		for(int i=0; i<srcArr1.length;i++) {
			copyArr1[i] = srcArr1[i];
			System.out.print(copyArr1[i]+" ");// 5 10 15 
		}
		
		// 검증
		// 주소값+값 비교
		System.out.println(srcArr1); // [I@70dea4e
		System.out.println(copyArr1);// [I@5c647e05
		// 주소값 다름
		for(int i=0; i<srcArr1.length; i++) {
			System.out.print(srcArr1[i]+" "); // 5 10 15  
		}
		System.out.println();
		for(int i=0; i<copyArr1.length; i++) {
			System.out.print(copyArr1[i]+" "); // 5 10 15 0  
		}
		System.out.println();
		// 값 자체도 다르다
		
		// 원본 값을 바꿔서 둘의 차이가 있는지 확인해보자
		srcArr1[0] = 20;
		System.out.println(srcArr1); // [I@70dea4e
		System.out.println(copyArr1);// [I@5c647e05
		// 원본 값 변경 후, 주소값 다름

		for(int i=0; i<srcArr1.length; i++) {
			System.out.print(srcArr1[i]+" ");  // 20 10 15 
		}
		System.out.println();
		for(int i=0; i<copyArr1.length; i++) {
			System.out.print(copyArr1[i]+" "); // 5 10 15 0  
		}
		System.out.println();
		// 원본 값 변경 후, 서로 값 영향x
		// 얕은 복사로 원본과 카피가 값이 같아졌지만 주소값은 여전히 다름
		
		
		// 방법2:System.arraycopy()
		// 배열길이 자동 수정x
		// 복사된 값의 나머지 공간은 해당 배열의 데이터 타입의 기본값으로 채워진다
		// ex)
		// int 배열값을 복사하고 나머지 공간은 0으로 채워진다
		// double  배열값을 복사하고 나머지 공간은 0.0
		// char 배열값을 복사하고 나머지 공간은 공백
		// String 배열값을 복사하고 나머지 공간은 null
		//
		// System.arraycopy(src, srcPos, dest, destPos, length)
		// src : 원본 배열
		// srcPos : 포지션. 원본배열에서 복사를 시작할 위치
		// dest : 복사 배열
		// destpos: 복사 배열에서 붙여놓기를 시작할 위치
		// length : 얼만큼 복사를 해올지에 대한 복사 길이
		
		int[] srcArr2 = {5,10,15};
		int[] copyArr2 = new int[4];
		
		System.arraycopy(srcArr2, 2, copyArr2, 1, 1);
		
		System.out.println(srcArr2); // [I@33909752
		System.out.println(copyArr2);// [I@55f96302
		// 주소값 다름
		
		for(int i=0; i<srcArr2.length; i++) {
			System.out.print(srcArr2[i]+" ");  // 5 10 15 
		}
		System.out.println();
		for(int i=0; i<copyArr2.length; i++) {
			System.out.print(copyArr2[i]+" "); // 0 15 0 0 
		}
		System.out.println();
		
		
		// int 배열
		int[] srcArr22 = {5,10,15};
		int[] copyArr22 = new int[4];
		System.arraycopy(srcArr22, 0, copyArr22, 0, srcArr22.length);
		
		for(int i=0; i<srcArr22.length; i++) {
			System.out.print(srcArr22[i]+" ");  // 5 10 15 
		}
		System.out.println();
		for(int i=0; i<copyArr22.length; i++) {
			System.out.print(copyArr22[i]+" "); // 5 10 15 0 
		}										// 남은 공간에 인트 기본값 0
		System.out.println();
		
		
		// double 배열
		double[] dSrcArr = {1.1,2.2,3.3};
		double[] dcopyArr = new double[5];
		System.arraycopy(dSrcArr, 0, dcopyArr, 2, dSrcArr.length);
		
		for(int i=0; i<dSrcArr.length; i++) {
			System.out.print(dSrcArr[i]+" ");  // 1.1 2.2 3.3  
		}
		System.out.println();
		for(int i=0; i<dcopyArr.length; i++) {
			System.out.print(dcopyArr[i]+" "); // 0.0 0.0 1.1 2.2 3.3 
		}									   // 남은 공간에 double 기본값 0.0
		System.out.println();
		
		
		// char 배열
		char[] cSrcArr = {'a','b','c'};
		char[] cCopyArr = new char[5];
		System.arraycopy(cSrcArr, 0, cCopyArr, 2, cSrcArr.length);

		for(int i=0; i<cSrcArr.length; i++) {
			System.out.print(cSrcArr[i]+" ");  // a b c 
		}
		System.out.println();
		for(int i=0; i<cCopyArr.length; i++) {
			System.out.print(cCopyArr[i]+" "); //      a b c 
		}									   // 남은 공간에 char 기본값  (공백)
		System.out.println();
		
		
		// String 배열
		String[] sSrcArr = {"어깨","팔","등"};
		String[] sCopyArr = new String[5];
		System.arraycopy(sSrcArr, 0, sCopyArr, 2, sSrcArr.length);		
		
		for(int i=0; i<sSrcArr.length; i++) {
			System.out.print(sSrcArr[i]+" ");  // 어깨 팔 등 
		}
		System.out.println();
		for(int i=0; i<sCopyArr.length; i++) {
			System.out.print(sCopyArr[i]+" "); // null null 어깨 팔 등 
		}									   // 남은 공간에 String(참조형) 기본값  null
		System.out.println();
		
		
		// 방법3:Arrays.copyof()
		
		// Arrays.copyOf(original, newLength)
		// - original : 원본
		// - newLength : 얼마만큼 복사할지
		// 배열 길이만큼 복사해오기에 System.arraycopy()처럼 공간이 남지않는다
		// 원본 길이보다 길게 복사할 경우, 남는 공간은 원본의 데이터타입 기본값으로 채운다
		
		int[] aSrcArr = {1,2,3};
		int[] aCopyArr = new int[5];
		aCopyArr = Arrays.copyOf(aSrcArr, 6);
		
		for(int i=0; i<aSrcArr.length; i++) {
			System.out.print(aSrcArr[i]+" ");  // 1 2 3 
		}
		System.out.println();
		for(int i=0; i<aCopyArr.length; i++) { // 자동 길이추가
			System.out.print(aCopyArr[i]+" "); // 1 2 3 0 0 0 
		}									   // 남은 공간에 int 기본값 0
		System.out.println();
		
		
		// int타입
		// 여분 : 0
		int[] aSrcArr2 = {1,2,3};
		int[] aCopyArr2 = new int[5];
		aCopyArr2 = Arrays.copyOf(aSrcArr2, 7);
		
		for(int i=0; i<aSrcArr2.length; i++) {
			System.out.print(aSrcArr2[i]+" ");  // 1 2 3 
		}
		System.out.println();
		for(int i=0; i<aCopyArr2.length; i++) { // 자동 길이추가
			System.out.print(aCopyArr2[i]+" "); // 1 2 3 0 0 0 0 
		}									   // 남은 공간에 int 기본값 0
		System.out.println();
		
		// double타입
		// 여분 : 0.0d
		double[] dSrcArr2 = {1.1,2.2,3.3};
		double[] dCopyArr2 = new double[5];
		dCopyArr2 = Arrays.copyOf(dSrcArr2, 7);
		
		for(int i=0; i<dSrcArr2.length; i++) {
			System.out.print(dSrcArr2[i]+" ");  // 1.1 2.2 3.3
		}
		System.out.println();
		for(int i=0; i<dCopyArr2.length; i++) { // 자동 길이추가
			System.out.print(dCopyArr2[i]+" "); // 1.1 2.2 3.3 0.0 0.0 0.0 0.0   
		}									   // 남은 공간에 int 기본값 0
		System.out.println();
		
		// char타입
		// 여분 : (공백)
		char[] cSrcArr2 = {'A','B','C'};
		char[] cCopyArr2 = new char[5];
		cCopyArr2 = Arrays.copyOf(cSrcArr2, 6);
		
		for(int i=0; i<cSrcArr2.length; i++) {
			System.out.print(cSrcArr2[i]+" ");  // A B C 
		}
		System.out.println();
		for(int i=0; i<cCopyArr2.length; i++) { // 자동 길이추가
			System.out.print(cCopyArr2[i]+" "); // A B C          (공백)
		}									   // 남은 공간에 int 기본값 0
		System.out.println();
		
		
		// String
		// 여분 : null
		String[] sSrcArr2 = {"사레레","케푸다","라트익"};
		String[] sCopyArr2 = new String[6];
		sCopyArr2 = Arrays.copyOf(sSrcArr2, 6);
		
		for(int i=0; i<sSrcArr2.length; i++) {
			System.out.print(sSrcArr2[i]+" ");  // A B C 
		}
		System.out.println();
		for(int i=0; i<sCopyArr2.length; i++) { // 자동 길이추가
			System.out.print(sCopyArr2[i]+" "); // 사레레 케푸다 라트익 
		}									   // 사레레 케푸다 라트익 null null null 
		System.out.println();
		
		
	}
	
}