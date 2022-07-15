
// 제어문(flow control) 4.1-3

public class flow_control04_3 {

	public static void main(String[] args) {

		
		String id = "egoing";
		String inputId = args[0];
		
		String pass = "1111"; // pw : 1111
		String inputPass = args[1];
				
		System.out.println("Hi");
		
//		if(inputId.equals(id)) {
//			if(inputPass.equals(pass)) {
//				System.out.println("Master!");
//			} else {
//				System.out.println("Wrong pw!");
//			}
//		} else {
//			System.out.println("Who are you?");
//		}
//		// 디버깅debugging 사용
//		// 값이 같은 egoing인데 왜 false로 되서 else문으로 들어갈까?
//		// 해결책 .equals()
// 
// 위의 if문을 더 심플하게 해보는 코드
		if(inputId.equals(id) && inputPass.equals(pass)) {
			System.out.println("Master!");
		} else {
			System.out.println("Who are you?");
		}
		// && 논리연산자(=and)
	}

}
