
//제어문(flow control) 4.1-3

public class flow_control04 {

	public static void main(String[] args) {

		
		System.out.println("a");
		if(true) {
			System.out.println(1);
		} else if(true){
			System.out.println(2);
		} else {
			System.out.println(3);
		}
		System.out.println("b");
		System.out.println();
		
		
		////////4.2 응용2/////////
		
		String id = "egoing";
		String inputId = args[0];
				
		System.out.println("Hi");
		
//		if(inputId == id) {
		if(inputId.equals(id)) {
			System.out.println("Master!");
		} else {
			System.out.println("Who are you?");
		}
		// 디버깅debugging 사용
		// 값이 같은 egoing인데 왜 false로 되서 else문으로 들어갈까?
		// 해결책 .equals()
		
		
		
		
	}

}
