

// 불리언(boolean) data type
// true or false 반환
public class flow_control0102 {

	public static void main(String[] args) {

		System.out.println("one");
		System.out.println(1);
		
		System.out.println(true);
		System.out.println(false);
		
		String foo = "Hello world";
//		String true = "Hello world"; : reserved word
		
		System.out.println(foo.contains("world")); // 변수foo에 world라는 문자열이 들어가 있기에 True 출력
		System.out.println(foo.contains("egoing")); 
		
		
// 비교 연산자(comparison operator)
// 왼쪽에 있는 값과 오른 쪽에 있는 값을 비교해서 그 결과가 무엇이냐에 따라서 
// True 또는 False 하나의 값을 만들어 내는 연산자(operator)
		System.out.println(1 > 1);  // false
		System.out.println(1 == 1); // true
		System.out.println(1 < 1);  // false
		System.out.println(1 >= 1); // true
		System.out.println();
		
	}

}
