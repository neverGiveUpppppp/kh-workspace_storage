

// OOP 4.1 : 클래스 - 존재 이유와 기본형식

class Print04_1 {
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
	// 메소드가 1억개라면 헬 난이도 복잡도
	// 구원자는 class
	// 새로운 클라스를 만들어서 정리하자
	// class print04를 생성하고 같은 주제인 메소드들을 안으로 이사시킴
}

public class OOP04_1 {
	public static void main(String[] args) {
		
		Print04_1.delimiter = "----";	// 추가 경로지정 : 클래스명. 추가
		Print04_1.A();					
		Print04_1.A();	
		
		Print04_1.delimiter = "====";	
		Print04_1.B();
		Print04_1.B();			
	}
}
