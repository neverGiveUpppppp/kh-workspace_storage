
// OOP 03_1 : 변수와 메소드 - 메소드 호출방식

// 1.메소드
// 2.클래스 소속 메소드
// 3.인스턴스 소속 메소드

// 1.메소드
//
// 메소드 생성하고 해당 메소드를 호출 & 메소드 한 줄마다 파라미터를 지정해줘야함  
public class OOP03_1 {
	public static void main(String[] args) {
		
		printA();			
		printA();			
		printB();
		printB();	// 이 방식은 메소드 한줄마다 바꿔줘야함. 그래서 구분자 변수 지정(String delimiter = "----";)하는것
	}

	public static void printA() {
		// ... 1억줄 코드
		System.out.println("----"); // 여기서 구분자를 ----으로했지만
		System.out.println("A");	// 위 printA()에서 *로 하고 싶다면?
		System.out.println("A");	// 각각의 메소드에 파라미터 지정해주는 것
									// 옆 메소드에서 printA()에 타입,변수지정
									// 및 지정변수 println하고 
									// (메소드09번 수업1,2,3에서 변환한 그거인듯)
	}
	public static void printB() {
		// ... 1억줄 코드
		System.out.println("====");
		System.out.println("B");
		System.out.println("B");
	}
}
