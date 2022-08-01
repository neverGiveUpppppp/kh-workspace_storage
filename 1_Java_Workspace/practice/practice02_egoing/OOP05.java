

// OOP 5. 인스턴스


class Print05 {
	public String delimiter = ""; 
	public void A() {
		// ... 1억줄 코드
		System.out.println(delimiter); 
		System.out.println("A");	   
	}
	public void B() {
		// ... 1억줄 코드
		System.out.println(delimiter);
		System.out.println("B");
	}
}

public class OOP05 {
	public static void main(String[] args) {
	
	// 클래스 : 원형본
	// 인스턴스 : 복제본
	//
	// 원형본인 클래스에서 인스턴스를 만들고 새 변수에 담아두고 이 인스턴스의 메소드를 호출하므로써
	// 이 인스턴스를 조작할 수 있게되는 메커니즘
	
//		Print05.delimiter = "----";	
//		Print05.A();					
//		Print05.A();	
//	
//		Print05.delimiter = "====";	
//		Print05.B();
//		Print05.B();		
//	
//		Print05.delimiter = "****";
//		Print05.A();
//		Print05.delimiter = "====";
//		Print05.B();
		
		
	// 위와 같이 계속 변수의 파라미터를 계속 바꿔서 써야하는 상황이라면?
	// 이럴 때 인스턴스 사용
	
	// static : static 뒤에 오는 String(변수(?))이 클래스소속이라는 의미
	// 고로 위에 클래스 안 메소드에서 static 삭제
	Print05 p1 = new Print05();
	p1.delimiter = "****";
	p1.A();
	p1.A();
	p1.B();
	p1.B();

	Print05 p2 = new Print05();
	p2.delimiter = "++++";
	p2.A();
	p2.A();
	p2.B();
	p2.B();
	// 전처럼 중복된 코드를 계속 바꿀 필요 없이,
	// 파라미터 ****가 필요하면 p1 인스턴스를 불러오고 +가 필요하면 p2를 부르면된다
	
	

	}
}
