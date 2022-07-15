
// Java 상속 - 4. this & super

class Cal111 {
	public int sum(int v1, int v2) {
		return v1+v2;
	}
	// this
	// 자기 자신을 뜻함
	public int sum(int v1, int v2, int v3) { // 같은 이름 메소드 // int v3 추가
		return this.sum(v1,v2)+v3;	// .sum() 자기자신
	}
}
class Cal333 extends Cal11{		// extends : Cal1을 상속
	public int minus(int v1, int v2) {
		return v1-v2;			// Cal3는 이제 부모 클래스가 없는 마이너스 기능도 탑재
	}
	
	// super
	// 부모를 뜻함
	public int sum(int v1, int v2) {
		System.out.println("Cal3!!");
		return super.sum(v1,v2);	// .sum()은 부모클래스 sum()
	}
}

public class Inheritance04 {
	public static void main(String[] args) {

		Cal111 c1 = new Cal111();
		System.out.println(c1.sum(2,1));
		System.out.println(c1.sum(2,1,1));
		
		Cal333 c3 = new Cal333();
		System.out.println(c3.sum(2,1));
		System.out.println(c3.minus(2,1));	// 자식클래스에 추가된 minus기능
		
		
	}
class Cal222 {
	public int sum(int v1, int v2) {
		return v1+v2;
	}
	public int minus(int v1, int v2) {
		return v1-v2;
	}
}
}
