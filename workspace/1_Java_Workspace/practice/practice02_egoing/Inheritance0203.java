
// Java 상속 - 2. 기능의 개선과 발전
// Java 상속 - 3. Overrinng & Overloading


// 오버라이딩(Overriding)
// 부모가 가진 기능을 재정의하는 것을 오버라이딩(Overriding)

// 오버로딩(Overloading)
// 과적하다 의미. 상속과 관련x
// 부모클래스도 자식클래스도 오버로딩 가능. 자식 클래스는 부모 클래스를 오버라이딩, 오버로딩 둘 다 가능
// 자바는 형태만 다르면 같은 이름의 메소드를 과적할 수 있다

class Cal11 {
	public int sum(int v1, int v2) {
		return v1+v2;
	}
	// overloading
	public int sum(int v1, int v2, int v3) { // 같은 이름 메소드 // int v3 추가
		return v1+v2+v3;
	}
}
class Cal33 extends Cal11{		// extends : Cal1을 상속
	public int minus(int v1, int v2) {
		return v1-v2;			// Cal3는 이제 부모 클래스가 없는 마이너스 기능도 탑재
	}
	//overriding
	public int sum(int v1, int v2) {
		System.out.println("Cal3!!");
		return v1+v2;
	}
}
public class Inheritance0203 {

	public static void main(String[] args) {

		Cal11 c1 = new Cal11();
		System.out.println(c1.sum(2,1));
		System.out.println(c1.sum(2,1,1));
		
		Cal33 c3 = new Cal33();
		System.out.println(c3.sum(2,1));
		System.out.println(c3.minus(2,1));	// 자식클래스에 추가된 minus기능
		
		
	}
class Cal22 {
	public int sum(int v1, int v2) {
		return v1+v2;
	}
	public int minus(int v1, int v2) {
		return v1-v2;
	}
}
}
