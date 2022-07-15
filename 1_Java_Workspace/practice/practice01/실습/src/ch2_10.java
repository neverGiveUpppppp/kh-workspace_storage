
public class ch2_10 {

	public static void main(String[] args) {

		int x = 4, y = 2;
		int tmp;
		
		// 여전히 int타입이므로 타입생략한듯
		tmp = x; // 1. x값을 임시변수 tmp에 저장
		x = y;   // 2. y값을 x값에 저장
		y = tmp; // 3. x값을 임시저장한 tmp의 값을 y값에 저장

		
		System.out.println(x); // 
		System.out.println(y); // 
		System.out.println();
		System.out.println("x="+x); // 문자열+숫자 : 문자열 뒤에 숫자를 붙이라는 뜻
		System.out.println("y="+y); // 
			
		
		
		
		
	}

}
