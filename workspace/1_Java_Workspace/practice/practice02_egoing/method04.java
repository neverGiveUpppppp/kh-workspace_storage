
public class method04 {


	public static void main(String[] args) { // main이라는 메소드 있어야 자바가 프로그램을 호출한다는 약속
// String뒤에 []는 문자열 배열. args는 자바가 메인메소드를 실행할 때, 입력해주는 입력값이 args를 통해서 들어가게됨
		printTwoTimes("a");	
		// 1억번 코드 반복
		printTwoTimes("b");	
		// 1억번 코드 반복
		
		
		printTwoTimes2("a","----");	// delimiter(구분자) 적용 메소드 호출
		printTwoTimes2("a","****");	
		printTwoTimes2("b","%%%%");	
		printTwoTimes2("b","!!!!");	
								// 위의 함수 안에 입력 된 값을 인자(argument) 
	}
								// 아래 text, delimiter와 같은 변수를 파라미터(parameter)라고 부름. 
								// 메소드 밖에서 메소드를 사용하는 쪽으로 주입한 값을 메소드 안으로 흘려보내주는 매개자라고 해서 매개변수
	public static void printTwoTimes(String text) {// 이 코드를 자바가 어떻게 받아들일까? 
		System.out.println("----");		 // printTwoTimes라는 메소드를 정의하고 있고
		System.out.println("a");		 // 이 메소드 ()안에 들어온 첫번째 값은 반드시 String타입으로 받으며
		System.out.println(text);		 // {}안에서 text라는 변수의 값이 되겠구나라고 생각한다
	}									 // 메소드명(데이터타입 변수명) {메소드 작동내용}
	// 이 메소드 밖에서 printTwoTimes 메소드를 호출하면 printTwoTimes()안에 첫째값을 "a"이구나 
	// 그럼 자바는 text 값은 {}안에서 "a"이구나라고 생각
	
	// printTwoTimes메소드 안에 "a”를 변수명 text로 변경하면, 메소드 데이터를 추가해야할 것을 더이상 수정할 필요가 없게됨

	// 만약 위의 구분표시----를 다른걸로 메소드처럼 일괄 변환하고 싶다면?
	public static void printTwoTimes2(String text, String delimiter) {
		System.out.println(delimiter); // delimiter 구분자라는 의미
		System.out.println(text);	   // 
		System.out.println(text);
	}

}
