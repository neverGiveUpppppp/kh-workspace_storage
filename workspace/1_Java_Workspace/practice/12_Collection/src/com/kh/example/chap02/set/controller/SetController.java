package com.kh.example.chap02.set.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.TreeSet;

import com.kh.example.chap01.list.model.vo.Student;
import com.kh.example.chap02.set.model.vo.Dog;

public class SetController {
	
	// Interface Set
	// 핵심 Hashset() 메소드
	public void doSet() {
		
//		HashSet set = new HashSet(); // 노란줄 원인 : 제네릭 지정안해서
		// 제네릭 <> : 데이터타입 제한
		HashSet<Dog> set = new HashSet<>(); // 뒤 제네릭 생략 → 타입추론 : 뒤 생략가능하다는 의미.
											// List나 다른데도 적용가능
		
		set.add(new Dog("장군",2.2));
		set.add(new Dog("구름",3.3)); // 추가 위치가 랜덤(순서x)
		set.add(new Dog("사랑",5.4));
		System.out.println("set : "+set); // 결과값 set : [구름(3.3kg), 장군(2.2kg)]
		// console 결과값이 null이 나올 경우는 Dog클래스의 toString()메소드에 이상있는 것
		// toString()에서 값을 반환
		
		Dog jangoon = new Dog("장군",2.2);	// equals hashCode오버라이딩 후 중복x
		set.add(jangoon);
		set.add(new Dog("장군",2.2));
		System.out.println("set : "+set); // set : [구름(3.3kg), 장군(2.2kg), 장군(2.2kg), 사랑(5.4kg)]
		// 중복 저장이 불가능한데 왜 장군이 두번 저장됬을까?
		// new Dog() 객체의 각 주소값이 달라서
		// equals이 주소값을 비교하기 때문에 주소값이 다르면 값이 같아도 저장 가능
		
		
		// 주소값이 아닌 내용 비교해야하는 상황에서는 뭘 써야할까?
		// equals hashCode오버라이딩
		// hashcode를 오버라이딩 하는 이유? 이퀄즈하고 해쉬코드가 규약으로 묶여있기 때문
		
		// equals hashCode오버라이딩 내용을 자체적으로 이미 되어있는 
		// String클래스로 해보기
		HashSet<String> strSet = new HashSet<String>();
		strSet.add("안녕");
		strSet.add(new String("안녕")); // 스트링 안에는 이퀄즈가 오버라이딩 되어있기에 중복저장X
		
		System.out.println("strSet : "+strSet);
		
	}
	
	public void doSet2() {
		// 순서가 유지되고 중복저장이 안되는 컬렉션
		// -> LinkedHashSet
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		set2.add(new Dog("초코",2.1));
		set2.add(new Dog("콩이",8.3));
		set2.add(new Dog("두부",5.0));
		set2.add(new Dog("초코",2.1));
		System.out.println("set2 : "+set2);
		// 결과값 : set2 : [초코(2.1kg), 콩이(8.3kg), 두부(5.0kg)]
		// 순서 O set
		// 순서가 있는 set
		//
		// 중복 저장이 안된 이유?
		// Dog클래스에 equals()를 오버라이딩 해줬기 때문에 내용비교가 가능하게 되었고
		// 이 때문에 같은 객체로 인지되었기 때문
		
		set2.add(new Dog("로이",6.1));
		set2.add(new Dog("공주",5.2));
		System.out.println("set2 : "+set2);

		// 정렬을 해주는 Set
		// TreeSet
		HashSet<String> strSet = new HashSet<String>();
		strSet.add("안녕");
		strSet.add(new String("안녕")); // 스트링 안에는 이퀄즈가 오버라이딩 되어있기에 중복저장X
		strSet.add("너는");
		strSet.add("이름이");
		strSet.add("뭐니");
		strSet.add("우리");
		strSet.add("친하게");
		strSet.add("지내자");
		strSet.add("어때?");
		strSet.add("싫어?");
		strSet.add("왜?");
		strSet.add("제발..");
		System.out.println("strSet : "+strSet);
		
		TreeSet<String> set3 = new TreeSet<>();// 뒤 제네릭 생략 → 타입추론 : 뒤 생략가능하다는 의미.
		System.out.println("set3 : "+set3);
		set3.addAll(strSet); // addAll() : 한번에 옮겨주기만 하는 역할. 정렬은 TreeSet이
		System.out.println("set3 : "+set3); // 결과값 오름차순 정렬됨
		// TreeSet이 정렬시킨다
		
		
		/*
		정렬 기준
		정렬할 수 있는 기능과 기준 둘 다 만족되어야함
		정렬 할 수 있는 기능이 충분하지만 정렬 기준이 없으면 정렬 못함.
		
		정렬 기준을 세워주는 건 <String>
		String 클래스 안에 comparable 인터페이스가(compareTo())가
		구현 되어있기 때문에 정렬 기준이 정해져 있고, 정렬 기준이 정해져 있는
		클래스 String이 TreeSet 안에 들어가 있기 때문에 정렬 가능
		
		*/
		
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(set2); // set2의 데이터가 set4로 들어간다. addAll()로도 가능!
		System.out.println("set4 : "+set4); // error
		// 에러메세지 : java.lang.ClassCastException: com.kh.example.chap02.set.model.vo.Dog cannot be cast to java.lang.Comparable
		// 원인 : Comparable Comparator 둘 중 하나가 있어야 정렬 가능한데 Dog클래스에 없다
	
		// 전체데이터 넣는 방법
		// 1) addAll()
		// 2) 생성자 매개변수 이용
		
		
		// list에 있는 element에 하나씩 접근하고 싶을 때 for문 이용 가능. 인덱스가 존재했기 때문
//		for(int i=0, i<list.size();i++) {
//			list.get(i);
//		}
		// set에는 인덱스 존재x -> list와 같은 방법으로 하나씩 element에 접근 불가능. 
		// set에서는 Iterator 사용 
		
		// Iterator
		// Iterator : 내가 컬렉션에 저장된 element에 접근 가능케 하는 역할
		// iterator(): iterator<E>
		// set안에 접근 가능한 엘리먼트를 반환
		// Returns an iterator over the elements in this set.
		
		set2.iterator(); // 반환값 iterator<E> -> 지네릭스로 반환값을 고정시킬 수 있다
		// 여기 클래스에서는 Dog로만 제한되어있음 
		// 반복자iterator를 오름차순으로 반환
		
		Iterator<Dog> it = set2.iterator(); // iterator 인덱스 없다
		// 인덱스가 없어서 for문이 아닌 while문에다 다음값 가져오는 hasNext() 사용
		while(it.hasNext()) { // hasNext():boolean 다음 값이 있으면 true, 없으면 false반환
			Dog d = it.next(); // next 다음값은 Dog
			System.out.println(d);
		}// 지네릭스로 데이터타입 고정시킨거라 데이터타입dog만 주머니에 가득하고 그걸 하나씩 없어질 때까지 꺼내는 것
		 // .next()는 꺼내오는 그 메소드
		//Iterator<Dog> it = set2.iterator(); 에서  set안에 있는 Dog에 접근하는 iterator타입의 it
 
		while(it.hasNext()) {  // 한번 읽은거는 다시 돌아가서 읽지는 않는다
			Dog d = it.next(); // next():E 다음값 반환
			System.out.println("11"+d);
		}
		
		ArrayList<Dog> list = new ArrayList<>(set2);
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		ListIterator<Dog> li = list.listIterator();
		while(li.hasNext()) { // hasNext()여기서 이미 한번 끝에 도달
			System.out.println(li.next());
		}
		while(li.hasNext()) { // hasNext() 두번째 돌리면 처음부터 다시 가는게 아니라 이미 끝에 있기에 의미없음
			System.out.println(li.next());
		}
		while(li.hasPrevious()) { // hasPrevious() : hasNext의 반대. 이전 값을 가져오기
			System.out.println(li.previous()); // previous() : next()의 반대. 이전 값이 있으면 값을 가져오는 것.
		} // 반대방향으로 한칸씩 가서 처음으로 도달
		// 양방향으로 하려면 ListIterator를 써야하는ㄱ건가요?
		// yes
		
		
		
	}
	
	public void doSet3() {

	
		
	}
}
