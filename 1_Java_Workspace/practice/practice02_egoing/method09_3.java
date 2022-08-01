
// JAVA method - 9. 부록 - static
//
// static

// 	  static - class method	
// no static - instance method
// 스태틱이라는 키워드가 붙은 메소드는 클래스의 메소드다
// 스태틱이 없는 메소드는 인스턴스의 메소드다
	
	
// void 의미 : 리턴값이 없다
// 비슷한 성격의 메소드를 정리정돈하는 도구 : 클래스


class Print3 {						// Class Print를 새로 만들고 원래있던 메소드a,b,c,d를 Class Print안으로 옮김
	public String delimiter;		// 2.클래스 print3의 공통 인자 생성
	public static void a() {		
		System.out.println("a");
		System.out.println("a");
	}
	public static void b() {
		System.out.println("b");
		System.out.println("b");
	}
	public void c() {							 // 3. 2번의 생성으로 중첩되는 ()안 왼쪽인자와 static 삭제
		System.out.println(this.delimiter);		 // 왼쪽 인자에 this.추가
		System.out.println("c");				 // this.는 t1111.delimiter = "----"; 여기서 지정한 값이 됨
		System.out.println("c");
	}
//	public static void d(String delimiter) { 	 // 윗 줄의 원형
//		System.out.println(delimiter);
//		System.out.println("d");
//		System.out.println("d");
//	}
}
public class method09_3 {
	public static void main(String[] args) {
		
//		Print3.a();		 	// 각각의 메소드마다 구분자를 인자값으로 줬어야하나 
//		Print3.b();			// 아래 인스턴스는 하나만 바꾸면 됨
		
//		Print3.c("----");  
//		Print3.d("====");	
		
		// 1억줄 코드에서 똑같은 메소드 호출할 때마다 아래에서 구분자를 중복해서 넣어야함
		// 이를 관리 용이를 위해 인스턴스(instance) 생성
		// 1.인스턴스(Instance) 생성
		Print3 t1111 = new Print3();
		t1111.delimiter = "----"; 
		t1111.a();					// 인스턴스 소속 메소드(static X)
		t1111.b();
		t1111.c();
//		t1111.d();
		
		Print3 t2222 = new Print3();
		t2222.delimiter = "===="; 
		t2222.a();
		t2222.b();
		t2222.c();
//		t2222.d();
		// 2. 위로 가서 public String delimiter; 추가
		
	}
}
