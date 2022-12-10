
// JAVA method - 9. 부록 - static
//
// static

// 	  static - class method	
// no static - instance method
// 스태틱이라는 키워드가 붙은 메소드는 클래스의 메소드다
// 스태틱이 없는 메소드는 인스턴스의 메소드다
	
	
// void 의미 : 리턴값이 없다
// 비슷한 성격의 메소드를 정리정돈하는 도구 : 클래스

class Print{
	public String delimiter; // static 안씀. 바로 아래 a,b()메소드 ()안에 값도 삭제하고,
							 // println()안 값도 String delimiter → this.delimiter로 수정
//	public static void a(String delimiter) { 
//  	System.out.println(delimiter); 
	public void a() { 
		System.out.println(this.delimiter);  // 이 this.delimiter는 아래 t1.delimiter = "----";의값
		System.out.println("a");
		System.out.println("a");
	}
//	public static void b(String delimiter) {
//		System.out.println(delimiter); 
	public void b() {						 // 메소드가 인스턴스 소속일 때는 static 제거해야함
		System.out.println(this.delimiter); 
		System.out.println("b");
		System.out.println("b");
	}
	public static void c(String delimiter) { // static 추가
		System.out.println(delimiter);		 
		System.out.println("c");
		System.out.println("c");
	}
}

public class method09 {

	
	public static void main(String[] args) {

	
//		a("----"); // a,b메소드 둘 다 클래스 Print로 묶고, Print.을 붙여줘서 경로지정
//		b("===="); // 경로 변경으로 인한 에러 해결
		
//		Print.a("----"); // 이 코드가 1억줄이라면, 구분자를 변경해야할 때마다 곤욕...
//		Print.b("----"); // 이를 위해 아래처럼 인스턴스를 사용한다
		
								// 데이터타입이 Print클래스인 변수 t1이고,
		Print t1 = new Print(); // Print 클래스 복제. 인스턴스 : new Print()
		t1.delimiter = "----";  // Print의 인스턴스 t1은 내부적으로 구분자의 값이 ----가 됨
		t1.a();					// 좌측처럼 구분자를 추가하지 않아도 자동적용됨
		t1.b();					// 위의 Print.b("----");는 각 메소드마다 구분자를 정해준 것이고,
								// 인스턴스를 사용한 이녀석은 메소드마다 지정안해줘도 된다
		
//		Print.a("====");		// 클래스 Print 소속으로 실행됨
//		Print.b("====");
		
		Print t2 = new Print(); // t1처럼 같은 클래스를 복제한 것 뿐인데, 왜 에러뜨고 작동하지 않을까?
		t2.delimiter = "====";  // static의 유무에 따라 에러 on&off
		t2.a();					// 이 a()메소드는 t2 '인스턴스 소속'으로 실행됨
		t2.b();					// Print.a("====");의 a는 '클래스 Print 소속'으로 실행됨
		
								// 메소드가 인스턴스 소속일 때는 static을 빼줘야함
								// 메소드가 클래스 소속일 때는 static이 있어야함
		// Print.a();에서 Print.은 클래스이고 이렇게 실행하면 작동이 안되고 에러
		// a()라는 메소드는 클래스 소속이 아니고 인스턴스 소속이기 때문에 에러. static이 없기에 작동x
		// Print.a();를 작동시킬려면 static을 넣으면 클래스를 쓸 수 있다. 
		// ↓↓↓
		Print.c("++++");		// 클래스 소속 메소드로써 잘 작동
								// static을 위에서 추가시켜뒀기 때문
//		Print.a("++++");		// 에러
//		Print.b("++++");		// 에러
	}
}
