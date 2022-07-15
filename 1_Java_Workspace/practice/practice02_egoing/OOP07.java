
// OOP 7. 생성자(constructor)와 this


// 생성자(constructor)
// 초기에 주입할 필요가 있는 값을 전달하거나 초기에 작업을 수행할 때 쓴다
// 리턴값이 없으며, 모든 클래스는 생성자가 반드시 한개이상 존재한다. 
// 따로 선언하지 않아도 보이지 않는 default constructor가 자동으로 추가된다.

// this 키워드
// 클래스가 인스턴스화 되었을 때에 인스턴스를 가리키게 하는 특수한 키워드
// 자바에서 this는 자기자신을 뜻함

public class OOP07 {
	public static void main(String[] args) {
	
//	 생성자(constructor)는 왜 써야할까?
//	 파일수정 시 어떤파일을 수정할지 파일 지정해줘야하는데 파일지정 행위를 까먹거나 나중에 하게되면 문제발생
//	 1)인스턴스 생성시점에서 ("data.txt")처럼 파일을 지정할 수 있다면 까먹지 않고 안정성 상승
//	 2)인스턴스가 생성될 때, 처리되어야할 어떤 작업(초기값 등)이 있을 때,
//	 또는 생성될 때 실행되어야하는 작업들을 하고 싶을 때 생성자(constructor)로 해결 가능
	
	
//	 print클래스는 어떤 작업을 처리하기전 delimiter값을 세팅해야 우리작업을 할 수 있는 상황이라고하면,
//	 이 파라미터값 조정을 까먹기가 상당히 쉽다.
//	 개선책
//	 인스턴스 생성시, delimiter값을 지정하지 않으면 클래스가 인스턴스화되지 못하도록 하면서 개발자가 실수할 가능성 차단가능
//	 인스턴시 생성할 때 delimiter값을 지정하는 것을 해볼 것. 생성자constructor를 정의해야함
	
//	 자바에서의 클래스는 생성자라는 특수한 메소드를 구현할 수 있는 기능을 제공하며, 중요기능은 초기화
//	 해당 클래스와 똑같은 이름을 정의하면, 얘가 바로 생성자(constructor)
//	 인스턴스를 생성할 때 자바는 이 클래스와 동일한 메소드가 있다면 그 메소드를 호출하도록 약속 되어있기에
//	 우리는 그 클래스가 인스턴스화 될 때 실행되어야할 코드를 construct method 안에 
//	 정의 하는 걸 통해서 초기화의 목적을 달성할 수 있는 것
		
//	 print클래스가 인스턴스화 될 때 구분자를 인자로써 받을 것이기에 print메소드의 매개변수로 delimiter를 받으면됨
		
		
	Print00 p1 = new Print00("----");		// new가 없으면 메소드를 호출하는 것과 같다
    p1.A();
    p1.B();

    Print00 p2 = new Print00("====");
    p2.A();
    p2.B();
    		
	}

}

class Print00 {
	public String delimiter = "";
	public Print00(String delimiter) {  // print00의 ()이 생성자
		this.delimiter = delimiter; 	// _delimiter는 이 맥락에서 "----"
	}
//	 이 클래스의 인스턴스 변수인 delimiter 값은 _delimiter의 값은 "----"
//	 밑에 A()메소드를 호출하면 println(delimiter)값에 "----" 들어가게됨
//	 만약 언더바를 빼고 delimiter = delimiter;라고 한다면 왼쪽 delimiter는 
//	 인스턴스 변수delimiter일까 생성자 메소드의 delimiter매개변수일까? 
//	 delimiter매개변수이다
//	 확인방법은 실행해보면 구분자가 출력이 안되어 나오는데,  String delimiter = "";에 세팅이 안됬기 때문
//	 이클립스에서 같은변수인지 색표시에서도 구별되어져 보임. 이런 경우 앞에 this.를 붙여준다.
//	 this는 우리가 생성한 인스턴스를 가리키는 것
//	 this.delimiter는 인스턴스의 변수를 가리키니까 String delimiter = "";의 delimiter를 가리킴
//	 생성자메소드 뿐 아니라 클래스 아래있는 메소드들의 delimiter에도 this.를 붙여 명시적으로 해두는게 좋다
	
//	 생성자(constructor)는 초기에 주입할 필요가 있는 값을 전달하거나 초기에 작업을 수행할 때 쓴다
//	 this는 클래스가 인스턴스화 되었을 때에 인스턴스를 가리키는 특수한 이름
	public void A() {
		System.out.println(this.delimiter);
		System.out.println("A");
	}
	public void B() {
		System.out.println(this.delimiter);
		System.out.println("B");
	}
}