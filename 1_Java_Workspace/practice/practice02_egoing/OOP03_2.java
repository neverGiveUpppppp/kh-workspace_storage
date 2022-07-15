

// OOP 03_2 : 변수와 메소드 - 메소드 호출 + 구분자 처리 방식

public class OOP03_2 {
	public static void main(String[] args) {
		
		
		// 1억줄 코드에 자주 구분자를 바꿔줘야한다면?
		// 변수를 지정해주자 ↓↓↓
		String delimiter = "----";
		printA(delimiter);			
		printA(delimiter);	
		
		delimiter = "====";
		printB(delimiter);
		printB(delimiter);
	}


	public static void printA(String delimiter) {
		// ... 1억줄 코드
		System.out.println(delimiter); 
		System.out.println("A");	
		System.out.println("A");	
	}
	public static void printB(String delimiter) {
		// ... 1억줄 코드
		System.out.println(delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}
