
public class method010203 {
	public static void printTwoTimesA() {// 이 줄울 보고 자바는 이런 메소드 있고 이런 내용을 가졌구나
		System.out.println("-");		 // 하고 기억해둠
		System.out.println("A");		 // 여기서 코드수정시 이 메소드를 쓴 모든 코드에 적용되어 엄청난 생산성업
		System.out.println("A");
	}
	public static void main(String[] args) { // 여기 main도 메인이라는 메소드. 처음부터 끝까지

		System.out.println("hello"); // println도 입력값을 모니터로 출력해주는 메소드
		System.out.println(Math.floor(1.1)); // 내림 메소드. 1.1을 1.0으로
		
		
		// 1억번 반복
		printTwoTimesA();
//		// 1억번 반복
//		System.out.println("-");
//		System.out.println("A");
//		System.out.println("A");
//		// 1억번 반복
//		System.out.println("-");
//		System.out.println("A");
//		System.out.println("A"); // 이 반복되는 코드들을 위에 만들어둔 메소드 printTwoTimesA로 변경
		// 1억번 반복				 // 같은 일하게 된다
		printTwoTimesA();		
		// 1억번 반복
		printTwoTimesA();
		
		// 이클립스 refactoring 기능
		// 매소드로 만들기를 원하는 부분을 드래그 범위 지정-우클릭 refactoring 클릭-우측 extract method 클릭
		// 프리뷰 기능을 이용하여 어찌 바뀔껀지 미리 확인가능
	}

}
