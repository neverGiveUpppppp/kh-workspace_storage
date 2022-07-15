import java.util.Arrays;

public class Array_review {
	public static void main(String[] args) {
		
		// 배열
		// 같은 자료형의 데이터의 여러개의 값을 저장할 수 있는 공간
		
		// 배열 선언
		int[] arr;
		
		// 배열 할당

		int[] arr1 = new int[3]; // 방법1 : 주로 Java에서 사용
		int arr2[] = new int[3]; // 방법2 : 주로 C에서 사용
		
		// 배열 초기화
		// 1)인덱스
		// 2)중괄호 {}
		// 3)for문 이용
		
		// 1)인덱스
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		
		arr[0] = 1; // error
					// 배열길이 지정하지 않았는데 인덱스번호 지정하고 값 넣을려니 에러
		
		System.out.println(arr1[0]); // 1
		System.out.println(arr1[1]); // 2
		System.out.println(arr1[2]); // 3
		
		
		// 2)중괄호 {}
		int[] arr3 = {1,2,3};
//		int arr3[] = {1,2,3}; // error
//		arr3 = {1,2,3}; // error 
		//Array constants can only be used in initializers
		for(int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i]+ " "); // 1 2 3
		}
		System.out.println();
		
		// 3)for문
		// 초기화할 값에 ‘규칙’이 존재할 경우 사용가능
		// for문 인덱스 이용한거라 int만 가능
		char[] Arr = new char[3]; // for문 인덱스 이용한거라 int만 가능
		int[] Arr2 = new int[3];
		for(int i=0; i<Arr2.length; i++) {
			System.out.print(Arr2[i]+" "); // 0 0 0
		} // 배열값을 안 넣어놔서 int의 기본값인 0 출력됨
		
		
		int[] arr4 = new int[3];
		for(int i=0; i<arr4.length; i++) {
			arr4[i] = i+3;
			System.out.print(arr4[i]+" ");
		}
		System.out.println();
		
		// 배열 수정(크기 변경)?
		int size = 5;
		int[] dArr = new int[size];
		System.out.println("dArr길이:"+dArr.length);
		System.out.println("dArr주소:"+dArr);// [I@6d06d69c
		dArr = new int[5]; // 같은 배열 길이
		System.out.println(dArr); // [I@7852e922 주소값이 다르다
		dArr = new int[4]; // 배열길이 4로 수정. 과연 주소값이 같을까?
		System.out.println(dArr); // [I@4e25154f
		// 전부 다른 주소값이 나왔다. 보이기에는 길이가 수정된 것처럼 보이나
		// 실제로는 새로 만든 값으로 대체시킨 것
		
		
		// 배열 삭제
		// 배열 삭제 = null
		dArr = null;
		// 배열에 null을 넣게되면 기존 주소값이 null로 바뀌면서 연결된 값도 끊어지면서
		// 사실상 삭제 효과가 나타난다
		
		
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
		
		
		// 배열 복사
		// 1)얕은 복사(shallow copy)
		// 2)깊은 복사(deep copy)
		
		// 1)얕은 복사(shallow copy)
		int[] arr5 = new int[2];
		int[] arr6 = arr5;
		// arr5의 주소값이 arr6로 그대로 들어가기 때문에 주소값 자체도 복사된다
		// 즉 arr5와 arr6는 같은 주소값을 갖으며,
		// 같은 주소값을 참조하기에 같은 값을 공유하게 된다
		
		// 검증
		int[] sourceArray = {10,20,30};
		int[] cloneArray = sourceArray;
		//주소값 확인
		System.out.println(sourceArray);//[I@70dea4e
		System.out.println(cloneArray); //[I@70dea4e
		for(int i=0;i<sourceArray.length;i++) {
			System.out.print(sourceArray[i]+" ");
		} // 10 20 30 
		for(int i=0;i<cloneArray.length;i++) {
			System.out.print(cloneArray[i]+" ");
		} // 10 20 30 
		System.out.println();
		// 원본과 클론 배열 둘의 주소값,값이 동일
		
		// 원본 값을 바꿔서 둘의 차이가 있는지 확인해보자
		sourceArray[2] = 40; // 길이는 여전히 3으로 같다
		System.out.println(sourceArray);//[I@70dea4e
		System.out.println(cloneArray); //[I@70dea4e
		
		for(int i=0;i<sourceArray.length;i++) {
			System.out.print(sourceArray[i]+" ");
		} // 10 20 40 
		for(int i=0;i<cloneArray.length;i++) {
			System.out.print(cloneArray[i]+" ");
		} // 10 20 40 
		// 원본과 클론 배열 둘의 주소값,값이 여전히 동일
		
		System.out.println();
		
		//2)깊은 복사
		// 새로운 배열을 만들어 기존 데이터를 모두 복사해오는 것
		// 방법1:for문
		// 방법2:System.arraycopy()
		// 방법3:Arrays.copyOf()
		
		// 방법1:for문
		int[] sourceArr = {10,20,30};
		int[] cloneArr = new int[3];
		
		// 검증
		// 주소값+값 비교
		System.out.println(sourceArr);// [I@5c647e05
		System.out.println(cloneArr); // [I@33909752
		// 주소값 다름
		for(int i=0;i<sourceArr.length;i++) {
			System.out.print(sourceArr[i]+" ");//10 20 30 
		}
		for(int i=0;i<cloneArr.length;i++) {
			System.out.print(cloneArr[i]+" "); //0 0 0 
		}
		// 값 자체도 다르다
		
		// 원본 값을 바꿔서 둘의 차이가 있는지 확인해보자
		System.out.println();
		System.out.println("========");
		sourceArr[2] = 31;
		System.out.println(sourceArr); // [I@5c647e05
		System.out.println(cloneArr);  // [I@33909752
		// 원본 값 변경 후, 주소값 다름
		for(int i=0;i<sourceArr.length;i++) {
			System.out.print(sourceArr[i]+" ");//10 20 31
		}
		for(int i=0;i<cloneArr.length;i++) {
			System.out.print(cloneArr[i]+" "); //0 0 0 
		}
		// 원본 값 변경 후, 서로 값 영향x
		
		System.out.println();
		for(int i=0;i<sourceArr.length;i++) {
			cloneArr[i] = sourceArr[i];		   // 얇은복사 실행
			System.out.print(cloneArr[i]+" "); // 10 20 31 
		}
		System.out.println();
		System.out.println(sourceArr); // [I@5c647e05
		System.out.println(cloneArr);  // [I@33909752
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
		
		
		int[] sourceArr3 = {10,20,30};
		int[] cloneArr3 = new int[3];
		 
		System.arraycopy(sourceArr3, 0, cloneArr3, 0, cloneArr3.length);
		System.out.println(sourceArr3);
		for(int i=0;i<sourceArr3.length;i++) {
			System.out.print(sourceArr3[i]+" "); // 10 20 30
		} 										 // 원본 값
		System.out.println();
		for(int i=0;i<cloneArr3.length;i++) {
			System.out.print(cloneArr3[i]+" ");  // 10 20 30
		} 										 // 클론 값
		System.out.println();
		
		int[] sourceArr4 = {10,20,30,40,50};
		int[] cloneArr4 = new int[3];
		 
		System.arraycopy(sourceArr4, 0, cloneArr4, 0, cloneArr4.length);
		// 원본 인덱스0번부터4번까지 배열값 복사해서 복제본의 0번째 인덱스부터 붙여넣는다는 의미
		for(int i=0;i<sourceArr4.length;i++) {
			System.out.print(sourceArr4[i]+" ");// 10 20 30 40 50
		} 										// 원본값
		System.out.println();
		for(int i=0;i<cloneArr4.length;i++) {
			System.out.print(cloneArr4[i]+" "); // 10 20 30
		} 										// 클론값
		// 
		System.out.println();
		
		System.arraycopy(sourceArr4, 2, cloneArr4, 0, cloneArr4.length);
		// 원본 인덱스2번부터4번까지 30 40 50의 배열값 복사해서 복제본의 0번째 인덱스부터 붙여넣는다는 의미
		for(int i=0;i<sourceArr4.length;i++) {
			System.out.print(sourceArr4[i]+" ");// 10 20 30 40 50
		} 										// 원본값
		System.out.println();
		for(int i=0;i<cloneArr4.length;i++) {
			System.out.print(cloneArr4[i]+" "); // 30 40 50 
		} 										// 클론값
		// 
		System.out.println();
		
		
		
		int[] a = {2,4,6,8,10};
		int[] b = new int [10];
		
		System.arraycopy(a, 3, b, 0, 2);
		// dest의 범위가 0-5까지는 잘나오고 6부터 error
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+" "); // 2 4 6 8 10 
		}								// 원본값
		System.out.println();
		for(int i=0; i<b.length;i++) {
			System.out.print(b[i]+" "); // 8 10 0 0 0 0 0 0 0 0 
		}								// 카피값
		System.out.println();
		
		// int 배열
		int[] src = {3,6,9,12};
		int[] clone = new int[8];
		
		System.arraycopy(src, 2, clone, 6, 2);
		// src 2번인덱스부터 길이2를 복사해서 9,12값을 clone의 6번째부터 복사
		for(int i=0; i<src.length;i++) {
			System.out.print(src[i]+" "); // 3 6 9 12 
		}								  // 원본값
		System.out.println();
		for(int i=0; i<clone.length;i++) {
			System.out.print(clone[i]+" ");// 0 0 0 0 0 0 9 12 
		}								   // 카피값
		System.out.println();
		
		int[] src2 = {3,6,9,12};
		int[] clone2 = new int[8];
		System.arraycopy(src2, 2, clone2, 5, 2);
		for(int i=0; i<clone2.length;i++) {
			System.out.print(clone2[i]+" ");// 0 0 0 0 0 9 12 0  
		} // 복사되고 int배열의 공백은 0으로 채워진다       // 카피값
		System.out.println();
		
		
		// double 배열
		double[] dSrc = {1.0,1.5,2.0,2.5};
		double[] dCopy = new double[8];
		
		System.arraycopy(dSrc, 0, dCopy, 4, dSrc.length);
		for(int i=0;i<dCopy.length;i++) {
			System.out.print(dCopy[i]+" ");//0.0 0.0 0.0 0.0 1.0 1.5 2.0 2.5  
		}								   // 복사된 값 외에 나머지 공간 : 0.0
		System.out.println();
		
		// char 배열
		char[] cSrc = {'a','b','c'};
		char[] cCopy = new char[6];
		
		System.arraycopy(cSrc, 0, cCopy, 0, cSrc.length);
		for(int i=0;i<cCopy.length;i++) {
			System.out.print(cCopy[i]+" ");//a b c (공백)
		}								   // // 복사된 값 외에 나머지 공간 : 공백
		System.out.println();
		
		// String 배열
		String[] sSrc = {"A","B","C"};
		String[] sCopy = new String[6];
		
		System.arraycopy(sSrc, 0, sCopy, 0, sSrc.length);
		for(int i=0;i<sCopy.length;i++) {
			System.out.print(sCopy[i]+" ");// A B C null null null 
		}								   // 복사된 값 외에 나머지 공간 : null
		System.out.println();
		
		
		
		// 방법3:Arrays.copyof()
		
		// Arrays.copyOf(original, newLength)
		// - original : 원본
		// - newLength : 얼마만큼 복사할지
		// 배열 길이만큼 복사해오기에 System.arraycopy()처럼 공간이 남지않는다
		// 원본 길이보다 길게 복사할 경우, 남는 공간은 원본의 데이터타입 기본값으로 채운다
		
		// int타입
		// 여분 : 0
		int[] aSrc = {1,2,3,4,5};
		int[] aCopy = new int[10];
		
		
		aCopy = Arrays.copyOf(aSrc, 4);
		for(int i=0;i<aCopy.length;i++) {
			System.out.print(aCopy[i]+" ");// 1 2 3 4 
		}								   
		System.out.println();
		
		aCopy = Arrays.copyOf(aSrc, 3);
		for(int i=0;i<aCopy.length;i++) {
			System.out.print(aCopy[i]+" ");// 1 2 3
		}								   
		System.out.println();
		
		aCopy = Arrays.copyOf(aSrc, 6);
		for(int i=0;i<aCopy.length;i++) {
			System.out.print(aCopy[i]+" ");// 1 2 3 4 5 0
		}								   
		System.out.println();
		
		
		// double타입
		// 여분 : 0.0d
		double[] adSrc = {1.0,1.5,2.0,2.5,3.0};
		double[] adCopy = new double[10];
		
		
		adCopy = Arrays.copyOf(adSrc, 6);
		for(int i=0;i<adCopy.length;i++) {
			System.out.print(adCopy[i]+" ");// 1.0 1.5 2.0 2.5 3.0 0.0 
		}								   
		System.out.println();
		
		
		// char타입
		// 여분 : (공백)
		char[] acSrc = {'a','b','c'};
		char[] acCopy = new char[6];
		
		acCopy = Arrays.copyOf(acSrc, 6);
		for(int i=0;i<acCopy.length;i++) {
			System.out.print(acCopy[i]+" ");// a b c (공백)
		}								   
		System.out.println();
		
		
		// String
		// 여분 : null
		String[] asSrc = {"a","b","c"};
		String[] asCopy = new String[6];
		
		asCopy = Arrays.copyOf(asSrc, 6);
		for(int i=0;i<asCopy.length;i++) {
			System.out.print(asCopy[i]+" ");// a b c null null null 
		}								   
		System.out.println();
		
		
		
	}
	
}