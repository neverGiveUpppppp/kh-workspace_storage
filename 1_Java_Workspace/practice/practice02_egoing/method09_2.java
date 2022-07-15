
// JAVA method - 9. 부록 - static
//
// static

// 	  static - class method	
// no static - instance method
// 스태틱이라는 키워드가 붙은 메소드는 클래스의 메소드다
// 스태틱이 없는 메소드는 인스턴스의 메소드다
	
	
// void 의미 : 리턴값이 없다
// 비슷한 성격의 메소드를 정리정돈하는 도구 : 클래스


class Print2 {						// Class Print를 새로 만들고 원래있던
	public static void a() {		// 메소드a,b,c,d를 Class Print안으로 옮김
		System.out.println("a");
		System.out.println("a");
	}
	public static void b() {
		System.out.println("b");
		System.out.println("b");
	}
	public static void c(String delimiter) {
		System.out.println(delimiter);
		System.out.println("c");
		System.out.println("c");
	}
	public static void d(String delimiter) {
		System.out.println(delimiter);
		System.out.println("d");
		System.out.println("d");
	}
}
public class method09_2 {
	public static void main(String[] args) {
		
		Print2.a();			// Print라는 클래스가 없음
		Print2.b();			// 위에서 class Print{}로 만들어주자
		
		Print2.c("----");  // 위에 메소드c의 delimiter값 설정으로 아랫줄c()안에 ----같이 출력
		Print2.d("====");  // 클래스인 print2 소속으로 실행되는 메소드(static O)
	}
}
