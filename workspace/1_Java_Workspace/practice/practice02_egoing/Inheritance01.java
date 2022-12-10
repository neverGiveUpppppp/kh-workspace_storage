
// Java 상속 - 1. 수업소개 : 상속의 정의 & 장점

class Cal1 {
	public int sum(int v1, int v2) {
		return v1+v2;
	}
}
class Cal3 extends Cal1{		// extends : Cal1을 상속
	
}
public class Inheritance01 {

	public static void main(String[] args) {

		Cal1 c1 = new Cal1();
		System.out.println(c1.sum(2,1));
		
		Cal3 c3 = new Cal3();
		System.out.println(c3.sum(2,1));
		
		
	}
class Cal2 {
	public int sum(int v1, int v2) {
		return v1+v2;
	}
	public int minus(int v1, int v2) {
		return v1-v2;
	}
}
}
