

// OOP 6. static


// static이란?
// 클래스가 로딩될 때 static 선언된 자원들은 JVM에서 메모리에 딱 한번 올라감.
// 즉, static 변수는 클래스가 사용되기 전 미리 메모리에 올라감
// static을 사용하면 객체 생성할 필요없이 공용된 자원을 사용함으로써 메모리를 효율적으로 사용가능


class Foo {
	public static String classVar = "I class var"; // static O :  클래스 소속
	public String instanceVar = "I instance var";  // static x : 인스턴스 소속
	
	public static void classMethod() {		// 클래스 메소드에서 classVar와 insVar 접근가능?
		System.out.println(classVar);		// yes
//		System.out.println(instanceVar);	// error
		// 클래스 메소드에서 classVar에는 접근이 되나 instanceVar에는 접근할 수 없다
		// static 여부차이로 클래스 소속과 메소드 소속으로 나뉘어 제어되기 때문
	}
	public void instanceMethod() {			// 인스턴스 메소드에서 classVar와 insVar 접근가능?
		System.out.println(classVar);		// yes
		System.out.println(instanceVar);	// yes
		// 인스턴스 메소드에서는 클래스 변수, 인스턴스 변수 모두 접근가능!
	
	}
}

public class OOP06 {
	public static void main(String[] args) {
	
	// 클래스를 통해서 classVar에 접근이 되는가? 		yes
	// 클래스를 통해서 instanceVar에 접근이 되는가?	error
		System.out.println(Foo.classVar); 
//		System.out.println(Foo.insatanceVar);  error
		Foo.classMethod();		// Foo클래스에서 클래스 메소드 호출 가능
//		Foo.instanceMethod();	// Foo클래스에서 인스턴스메소드 호출 불가
		// 인스턴스 메소드는 인스턴스 소속이기에 클래스를 통해서 접근하는 것은 금지 되어있음
		
		
		////////////////////////////////////////////////////////////////
		//// f1이라는 새 인스턴스를 생성했을 때 내부적으로 어떤 일이 일어나는지 살펴보자 ////
		////////////////////////////////////////////////////////////////
		
		//				class Foo        		  vs       	instance f1
		// static String classVar="I class var" 		 static String classVar
		// String instanceVar="I instance var"	 	 String InstanceVar="I instance var"
		// 			static classMethod()		 		 static classMethod()	
		// 			instanceMethod()					 instanceMethod()
			
		
		// f1인스턴스는 클래스Foo를 원형으로하며, f1에는 실제값이 존재하지 않는다
		
		// 첫째줄
		// 인스턴스f1의 static String classVar는 클래스Foo의 static String classVar="I class var"를 가릴킬 뿐
		
		// 둘째줄
		// instanceVar는 Foo에서 f1이라는 인스턴스가 생성될 때 인스턴스바라고 하는 변수가 생성되면서 클래스 값도 세팅되어있다면 값도 복제됨. 
		// 이 둘은 서로 링크 걸려있지 않기에 인스턴스f1의 값이 바꾼다고 해서 class foo의 값이 바뀌지 않음 
		// 첫째줄 인스턴스f1의 static String classVar의 값을 바꾸면 클래스Foo의 static String classVar="I class var"값도 변경됨.
		// 물론 반대로 class foo의 값을 바꿔도 instance f1의 값도 같이 변경된다(원형과 복제본) ★상호영향 중요★!!!
		
		// 셋째줄
		// 메소드도 마찬가지로 클래스foo를 참조하는 것
		// instance f1의 static classMethod()의 메소드는 class Foo의 static classMethod()를 참조
		
		
		// 넷째줄
		// 인스턴스f1의 instanceMethod()는 클래스foo의 instanceMethod()를 복제한 것. 독립된 존재
		
		// 인스턴스f2 생성
		
		
		// 중요법칙
		// 클래스의 변수를 바꾸면 모든 인스턴스의 값이 바뀐다
		// 인스턴스에서 원형클래스 변수를 바꿀 수도 있는데, 그럼 이 클래스와 이 클래스를 사용하는 모든 인스턴스의 값도 변경된다 
		
		
		Foo f1 = new Foo(); 
		Foo f2 = new Foo(); 
		
		System.out.println(f1.classVar);	 // 출력 : I class var
		System.out.println(f1.instanceVar);	 // 출력 : I instance var
		
		f1.classVar = "changed by f1";		 // 클래스바 변수값을 인스턴스f1이 변경시킴."changed by f1"으로
		System.out.println(Foo.classVar);  	 // 출력 : changed by f1
		System.out.println(f2.classVar); 	 // 출력 : changed by f1
		
		f1.instanceVar = "changed by f1";	 // 인스턴스바 변수값을 인스턴스f1이 변경시킴."changed by f1"으로
		System.out.println(f1.instanceVar);	 // 출력 : changed by f1  // 변경된 변수값으로 출력됨
		System.out.println(f2.instanceVar);	 // 출력 : I instance var // f1과 f2가 독립적이라 기존값으로 출력됨
		// 복제된 인스턴스끼리는 영향을 주지 않음. 원형인 클래스값을 변경시키지 않는 이상
		// 
	}
}
