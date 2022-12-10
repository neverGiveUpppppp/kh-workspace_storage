
// Java 상속 - 5. 상속과 생성자

class Cal1111 {
	int v1,v2;				  		// 정수 데이터타입 세팅
	Cal1111(int v1, int v2) { 		// 생성자 
		this.v1 = v1; this.v2 = v2; // this.v1의 v1은 class Cal1111 { 아랫줄 int v1
		//매개변수에 들어온 값				// this.v1 = v1;에서 v1;은 Cal1111(int v1, int v2)에서 int v1
		System.out.println("Cal init!!!");
	}
	public int sum() {return this.v1+v2;}
	
}
class Cal3333 extends Cal1111{  // extends : Cal1을 상속
	Cal3333(int v1, int v2) {
		super(v1, v2);	// super=부모클래스. 즉,부모클래스의 생성자를 실행시킴. 
						// 부모클래스의 생성자는 아래와 같다
						// Cal1111(int v1, int v2) {
						// 		this.v1 = v1; this.v2 = v2;
	System.out.println("Cal3 init!!!");
	}
	public int minus() {return this.v1-v2;}
}
public class Inheritance05 {
	public static void main(String[] args) {
		// new cal() 안에 입력값 2,1 새로 입력
		Cal1111 c1 = new Cal1111(2,1); // 출력 : 클래스cal1에서 println() 한번만 출력 
		Cal3333 c3 = new Cal3333(2,1); // 출력 : super(v1, v2); 이 문구가 
									   // 클래스cal1에서 println() 한번 출력시키고
									   // 클래스cal3에서 println() 한번 출력시켜 두번출력
		System.out.println(c3.sum());  // 결과값 3
		System.out.println(c3.minus());// 결과값 1
		
	}
}
