package com.kh.example.chap01.list.controller;
import java.util.ArrayList;
import java.util.List;

import com.kh.example.chap01.list.model.vo.Student;

public class ListController {

	public void doList() {
//		List list1 = new ArrayList();
		// 부모                            자식               // 인터페이스,추상클래스는 참조변수로는 가능하기에 부모타입 자식객체 가능
		// 참조변수? 참조변수로는 사용 가능하다?
		
//		List list = new List(); list는 인터페이스. 직접적으로 객체생성 불가
		
		ArrayList list1 = new ArrayList(); // 지네릭 추가 안했기에 노란줄
		// 지네릭 추가 : <Student> 
		ArrayList<Student> list = new ArrayList<Student>(3); // 끝에 (3)은 Arraylist 길이
//		list.add(Studnent e)
//		list1.add(Object e) // 타입제한을 뭘 해야할지 몰라서 다 받아줘야하니까 최상위클래스 오브젝트룰 받는 것
		
		
		
		// 타입 제한 왜 굳이? 모든걸 다 받아오게 하는게 컬렉션의 장점이라 안해도 상관없지만 
		// 여러가지를 담게되면 꺼내올 때 어떤 타입인지 확인을 하고 꺼내와야한다. 즉 , 인스턴스오브를 사용해야함
		// 일일히 하나씩 데이터타입을 확인해야하니 일이 많아져서 애초에 타입을 지정해서 받도록 지네릭을 지정하는 것(편의성,생선성up)
		
		
		
		// add(E e):boolean
		// add(int index, E element):void
		// 마지막 인덱스번호보다 더 뒤에 번호를 지정하면 길이 에러발생
		// void 즉 없는 값을 출력하라하면 에러 발생
		list.add(new Student("테스트",0));  // 결과값 :[테스트(0점), 도대담(60점), 남나눔(90점)]
		list.add(new Student("도대담",60)); // []는  Arraylist에서 자체적으로 출력하는 것이고, 나머지 (0점)이런 것은
		list.add(new Student("남나눔",90)); // model.vo Student의 toString() 리턴값이 반영된 것
//		list.add("하이"); // error :student로만 받게 제한시켜서 "하이"는 str이라 제한되서 들어갈 수 없다
		// 에러메세지 : The method add(Student) in the type ArrayList<Student> is not applicable for the arguments (String)
		
		
		System.out.println("list : "+list); 
		// ArrayList는 ___의 ____를 ____했기 때문에 list만 찍어도 안에 내용이 나온다
		// Object의 toString()를 오버라이딩 했기에
		
		// 결과값 [] 출력된 것
		// 어레이리스트에서 리턴값을 [] 포함해서 출략하도록? 만듬
		
		
		
		// ArrayList 메소드()는 API 문서 참고
		
		
		// 장점1. 크기 제약 x
		// 값 추가
		list.add(new Student("하현호", 85)); // 값 추가
		System.out.println("list : "+list); // 길이3의 배열이 값을 추가하고 나서 자동적으로 길이4가 됨
		System.out.println("list에 담긴 element 개수 : "+list.size()); // .size() : ArrayList 배열길이체크
																  // .size() = .length
		
		
		list.add(new Student("문미미",66));
		System.out.println("list : " +list); // 자동 길이 추가

		
		// 장점2. 추가/삭제/정렬 기능처리 간단
		// add(int index, E elemnet) 
		list.add(0, new Student("류라라",100)); // add(int index, E elemnet) : 맨 앞 위치에 추가
		System.out.println("list : " +list);  // 자동 길이 추가
		list.add(3, new Student("류라라",100)); // 네번째 자리에 추가
		System.out.println("list : " +list);  // 자동 길이 추가
		
		// 삭제
		// remove(int index):E
//		// remove()의 return은 삭제한 값을 돌려준다
		Student s = list.remove(1); // Student s 변수에는 왜 넣어준건가요? remove()의 반환값을 보여주기 위함.
		System.out.println(s);		// remove의 반환타입은 E이고 (API문서에서 E라고 설명나와있다)
									// 반환타입인 E가 여기서는 지네릭스에서 특정지은 Student라 사용
									// <E> 지네릭스로 Student 데이터타입만 받기로 했고 remove()의 리턴은 E인데 
									// 지네릭스로 데이터타입 제한했으니 반환 타입이 student일 수 밖에 없음
									// * 배열, 클래스의 값 반환은 주소값 반환
		System.out.println("list : " +list);  
		System.out.println("==============================");
		
		
		// 삭제
		// remove(Object o):boolean
		list.remove(new Student("강건강",40)); // 삭제가 안됬다. why?
		System.out.println("list : " +list); 
		
		// list.remove(new Student("강건강",40)); // 삭제가 안됬다. why?
		// 주소값이 달라서
		// remove(Object o):boolean 안에 로직이 (Object o)의 주소값과 ArrayList 안에 있는 데이터들과 대조해서
		// 주소값이 같은 걸 삭제하는 로직
		// 즉, remove() 안의 new Student로 새 객체를 만들었기에 ArrayList 안에 있는 데이터들과 주소값이 다르기에 삭제안된 것
		// → 해결법 : 미리 객체를 만들어서 주소값 통일 시켜줄 것
		// → 해결법 : equals()와 hashcode()를 오버라이딩 해서 new 객체가 먹히도록 함
		
		// equals()와 hashcode() 오버라이딩이  되어 있는 클래스 -> String, Integer
		// 따로 오버라이딩 할 필요 없이 그냥 String클래스나 Integer클래스 쓰면 remove() 사용가능
		
		Student kkk = new Student("강건강",40);
		list.remove(kkk);
		System.out.println("list : " +list); 
		
		Student kk = new Student("류라라",100); // Q. 삭제가 안됨
		list.remove(kk);
		System.out.println("list : " +list); 
		
		
		
		// Object equals()메소드의 오버라이딩 원리(?)
		// equals()메소도를 오버라이딩 해야함. 안에 있는 내용을 비교할 수 있또록 오버라이딩해줄 것
		// new해서 다시 만들어도 삭제 가능
		// equals()메소드는 object에서 가져온 놈인데 얘가 주소값을 비교하기 때문에
		// 스투턴트 안에 이퀄즈를 오버라이딩 // 오바리ㅇ딩한거를 먼저 쓰기 때문에 오브젝트 이퀄즈를 안쓰게 할 수 있고
		// 

		// 이퀄즈() 오버라이딩
		// 왜 오버라이딩할까? 
//		이퀄즈 주소값 비교한다
//		안에 있는 내용을 가지고 비교하고 싶다면? 오버라이딩 필수
//		then how? 주소값 자체 비교 또는 내용으로 비교해볼 수 있다

		
		// 지네릭 추가 : <String> 
		ArrayList<String> strlist = new ArrayList<String>();
		
		strlist.add("김");
		strlist.add("이");
		strlist.add("박");
		strlist.add("최");
		System.out.println(strlist);
		strlist.remove(new String("이")); // 잘지워진다
		strlist.remove(new String("최")); // equals랑 hashCode가 잘 오버라이딩이 되어있기 때문
		System.out.println(strlist);
		
		
		// 정렬
		// 정렬할 기준이 없어서 정렬 불가
		// 정렬가능케하는 인터페이스 -> interface comparable,comparator
		// comparable,comparator 얘네들이	구현이 되어있어야만 받아와져 있어야만 
		// 정렬 가능
		// comparable,comparator가 있어야 정렬 기준을 세울 수 있음
		// String과 Integer 클래스는 comparable,comparator  이 둘도
		// 오버라이딩 되어있다
		
//		정렬 기준을 세워주는 메소드
//		comparable이 들어가면 기준을 세울 수 있음
//		Colleactions.sort(list);
//		Colleactions.sort(strlist);
		
		
		// 정렬
		// sort(Comparator<? super E> c):default void
//		list.sort(Comparator<? super Student> c); sort가 int값 반환
		
		
		// set()
		// set(int index, E e):E
		// == replace 대체
		list.set(3, new Student("박보배",95));
		System.out.println("list : "+list);
		
		
		//get(int index):E
		list.get(2);  // 반환값 스튜던트 타입. 이클립스 마우스오버. 첫번째 글자 나오는게 리턴값
		Student s2 = list.get(2);
		System.out.println(s2);
		//어레이 리스트 안에 스튜던트가 담길 수 있도록 만든 것

		//메소드 안에 포함 되는지
		
		// contains(Object) : boolean
		// 해당 객체를 포함한지 true/false반환
		
		// indexOf(Object o) : int 
		// 해당 인덱스 번호 반환
		// 해당 값이 없을경우 -1 반환
		System.out.println(list.contains(new Student("류라라", 100))); // 주소값비교 하는 둘
		System.out.println(list.indexOf(new Student("류라라", 100)));  // 없으면 ???해쉬코드랑 
		
		System.out.println(strlist.contains(new String("김"))); // 주소값비교 하는 둘
		System.out.println(strlist.indexOf(new String("qkr")));  // 없으면 ???해쉬코드랑 
		
		
		// clear():void
		// isEmpty():boolean
		list.clear();
		System.out.println("list "+list);
		System.out.println(list.isEmpty());
		
		
		
	}

	public void equals_overriding() {
//		// 클래스비교
//		this==obj 같은 주소
//		getclass() 안에 있는 클래스 정보를 반환
//		클래스 정보가 다르기에 같다고 할 수 없음
//		// 내용비교
		
//		@Override
//		   public boolean equals(Object obj) {
//		      // 클래스 비교
//		      if(this == obj) {
//		         return true;
//		      }
//		      if(obj == null) {
//		         return false;
//		      }
//		      if(getClass() != obj.getClass()) {
//		         return false;
//		      }
//		      
//		      // 내용 비교
//		      Student other = (Student)obj;
//		      if(name == null) {
//		         if(other.name != null) {
//		            return false;
//		         }
//		      } else if(!name.equals(other.name)) {
//		         return false;
//		      }
//		      
//		      if(score != other.score) {
//		         return false;
//		      }
//		      
//		      return true;
//		   }
//		   
//		   @Override
//		   public int hashCode() {
//		      final int PRIME = 31;
//		      int result = 1;
//		      
//		      result = PRIME * result + (name == null ? 0 : name.hashCode());
//		      result = PRIME * result + score;
//		      
//		      return result;
//		   }
	}
	
}




