
// JAVA method - 9. 부록 - static
//
// static

// 	  static - class method	
// no static - instance method
// 스태틱이라는 키워드가 붙은 메소드는 클래스의 메소드다
// 스태틱이 없는 메소드는 인스턴스의 메소드다
	
	
// void 의미 : 리턴값이 없다
// 비슷한 성격의 메소드를 정리정돈하는 도구 : 클래스


public class method09_1 {
	public static void a() {				 // 메소드 a()
		System.out.println("a");
		System.out.println("a");
	}
	public static void b() {				 // 메소드 b()
		System.out.println("b");
		System.out.println("b");
	}
	public static void c(String delimiter) { // 메소드 c()
		System.out.println(delimiter);
		System.out.println("c");
		System.out.println("c");
	}
	public static void d(String delimiter) { // 메소드 d()
		System.out.println(delimiter);
		System.out.println("d");
		System.out.println("d");
	}
	public static void main(String[] args) {
		// 아래는 전부 static 있는 클래스의 메소드
		a();		// 위에 메소드a 안에 println값만 받아서 aa출력
		b();
		
		c("----");  // 위에 메소드c의 delimiter값 설정으로 아랫줄c()안에 ----같이 출력
		d("====");
	}
}
