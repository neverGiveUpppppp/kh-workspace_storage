

// OOP 03_3 : 변수와 메소드

public class OOP03_3 {
	public static String delimiter = ""; 
	// 메인 메소드 안 delimiter를 안에서 메소드 밖에 있는 delimiter값을 사용하게끔 지정
	public static void main(String[] args) {
		
		// 인자로 변수를 주는 것도 싫다면?
		// 
		// 메인 메소드 안 delimiter를 메소드 안에서 메소드 밖에 있는 delimiter값을 사용하면 됨
		// 다만, 유효범위 체크
		delimiter = "----";	// 이 delimiter = public static String delimiter = ""; 
		printA();			// 메인 메소드 안에 delimiter 변수가 없기에 이 파일 클래스 전체에서 찾는 것
		printA();	
		
		delimiter = "====";	// 이 방식은 구분자 하나만 바꿔주면 끝
		printB();
		printB();			// 이 방식은 메소드 한줄마다 바꿔줘야함. 그래서 구분자 변수 지정(String delimiter = "----";)
	}


	public static void printA() {
		// ... 1억줄 코드
		System.out.println(delimiter); // printA() 메소드 안에  delimiter가 없다면
		System.out.println("A");	   // 이 파일 클래스(메인 메소드 위에)에서 찾아서 사용
		System.out.println("A");	   // 
	}
	public static void printB() {
		// ... 1억줄 코드
		System.out.println(delimiter);
		System.out.println("B");
		System.out.println("B");
	}
	// public static String delimiter = ""; 
	// public static void printA() {
	// public static void printB() { 와 같이 연관성이 깊고 같은 주제 코드들이 모여있지만
	// 주제가 다 다른 코드들이 1억개라면 지옥 같이 복잡해짐
	// 이 상황에서 구원자는 class! 
	
}
