
//논리 연산자 logical operator 5

public class flow_control06 {

	public static void main(String[] args) {

		// AND 연산자 : 그리고, 둘 다
		System.out.println(1 == 1);
		System.out.println(true &&  true); // true
		System.out.println(true &&  false); // false
		System.out.println(false &&  false); // false
		System.out.println();
		
		// OR 연산자 : 또는, 둘 중 하나
		// true와 false가 섞여있으면 true 따라감
		System.out.println(true || true); // true
		System.out.println(true || false); // true
		System.out.println(false || true); // true
		System.out.println(false || false); // false
		System.out.println();
		
		// not
		System.out.println(!true); // false
		System.out.println(!false);// true
		
		
		
		
		
	}

}
