
public class VarEx1 {

	public static void main(String[] args) {
		final int score = 100; // 상수(constant) 
		score = 200;  // 에러 표시 빨간줄
		// 변수는 꼭 선언과 동시에 초기화시킬 것
		System.out.println(score);
	}

}

public class VarEx2 {

	public static void main(String[] args) {
		final int score = // 100; // 상수(constant) 
//		score = 200;  
// 변수는 꼭 선언과 동시에 초기화시킬 것
		System.out.println(score); // 에러 표시 빨간줄
	}							   // 변수 초기화안해서 에러발생

}

public class VarEx3 {

	public static void main(String[] args) {
		final int score = // 100; // 상수(constant) 
		score = 200;  // 변수 초기화 시키니 score 에러사라짐
// 변수는 꼭 선언과 동시에 초기화시킬 것
		System.out.println(score); 
	}							   

}







