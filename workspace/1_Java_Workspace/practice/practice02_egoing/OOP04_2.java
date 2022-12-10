

// OOP 4.2. 클래스 - 형식

// 이클립스 [Refactor] - [Move type to New File]
//	사이드 클래스 부분만 따로 떼어서 파일화 시킴


class Print04_2 {
	public static String delimiter = ""; 
	public static void A() {
		// ... 1억줄 코드
		System.out.println(delimiter); // printA() 메소드 안에  delimiter가 없다면
		System.out.println("A");	   // 이 파일 클래스(메인 메소드 위에)에서 찾아서 사용
		System.out.println("A");	   // 
	}
	public static void B() {
		// ... 1억줄 코드
		System.out.println(delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}

public class OOP04_2 {
	public static void main(String[] args) {
		
		Print04_2.delimiter = "----";	// 추가 경로지정 : 클래스명. 추가
		Print04_2.A();					
		Print04_2.A();	
		
		Print04_2.delimiter = "====";	
		Print04_2.B();
		Print04_2.B();			
	}
}
