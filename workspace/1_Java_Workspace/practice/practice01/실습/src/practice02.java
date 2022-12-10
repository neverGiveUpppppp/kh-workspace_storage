
import org.opentutorials.iot.Elevator; 

public class practice02 {
	public static void main(String[] args) {
		
		double a = 1.1;
		double b = 1; // 문제없음. 1.0으로 출력
		System.out.println(b);
		
//		int c = 1.1
//		double d = 1.1;
//		int e = (int) 1.1;
//	
		double b1=1;              // 자동 캐스팅
		double b2 = (double) 1; // 수동 캐스팅. 명시적으로 바꿔준 것
//		이 둘은 같은 코드
		System.out.println(b1);
		System.out.println(b2);
		System.out.println();

//		*int to str 캐스팅 검색
		String f = Integer.toString(1);  // 정수에서 문자열로 변환

//		.getClass() : 해당 변수가 어떤 타입인지 알려줌(파이썬의 type()함수 역할)
//		ex) 
		System.out.println(f.getClass());
		
	}

}
