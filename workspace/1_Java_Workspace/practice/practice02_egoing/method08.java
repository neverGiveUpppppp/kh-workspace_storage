
// JAVA method - 8. 부록 - Access level modifiers
//
// Access level modifiers : 외부에서의 접근권한 설정


class Greeting{
	public static void hi() {
//	private static void hi() {
		System.out.println("Hi");
	}
}

public class method08 {
	
	public static void main(String[] args) {
	// public 자리에 올 수 있는 다른 명령어들 : 외부에서 접근하는 레벨을 지정하는 부분
	// public, protected, default(생략), private(같은 클래스 안에서만 작동하게하는 기능)
	// 위의 명령어가 무엇이든 다 동작하기는 한다
		
		
		Greeting.hi(); // 위의 hi메소드가 public이면 작동. private면 미작동 에러
		
		// protected & default는 경제적이지 않음
		
		// public과 private의 예
		// 스마트폰 안에 오만가지 선들이 있는데 이것을 사용자가 만지면 안되고 알 필요도 없음
		// 반대로 사용자가 컨트롤 해야할 볼륨키, 전원키 등은 외부로 나와줘야한다
		// public : 외부로 노출되어 있는 버튼들(유저가 사용가능)
		// private : 내부 선들(유저 사용불가)
	
	}
}
