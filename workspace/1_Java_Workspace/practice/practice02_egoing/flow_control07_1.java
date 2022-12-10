
// 반복문 looping statement

public class flow_control07_1 {

	public static void main(String[] args) {

		
		System.out.println(1);
		
		// while문
		int i = 0; // 숫자 세는 코드
		           // i는 일반적으로 반복문에서 카운팅하기 위해 많이 지정함
//		while(true) {
		while( i < 3 ) {
			System.out.println(2);
			System.out.println(3);
			i = i + 1; // 같은 코드 i++;
//			i++;
			
		}
		
		System.out.println("===================");
		
		// for문 
		// 반복 횟수가 지정되있을 경우 for문을 쓰는게 좋다
		// for문은 ()안에 boolean타입이 아닌 초기값을 세팅하는 코드가 들어감
		for(int j=0; j<3; j++) {
			System.out.println(2);
			System.out.println(3);
		}
		
		System.out.println(4);
		
		
		
	}

}
