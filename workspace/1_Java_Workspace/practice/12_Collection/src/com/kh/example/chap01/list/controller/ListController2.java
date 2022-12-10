package com.kh.example.chap01.list.controller;
import java.util.ArrayList;
import java.util.List;

import com.kh.example.chap01.list.model.vo.Student;

public class ListController2 {

	public void doList() {
		ArrayList<Student> list = new ArrayList<Student>(3); // 끝에 (3)은 Arraylist 길이
		
		
		// add(E e):boolean
		list.add(new Student("테스트",0));  // 결과값 :[테스트(0점), 도대담(60점), 남나눔(90점)]
		list.add(new Student("도대담",60)); // []는  Arraylist에서 자체적으로 출력하는 것이고, 나머지 (0점)이런 것은
		list.add(new Student("남나눔",90)); // model.vo Student의 toString() 리턴값이 반영된 것
		
		
		System.out.println("list : "+list); 
		// ArrayList는 ___의 ____를 ____했기 때문에 list만 찍어도 안에 내용이 나온다
		// Object의 toString()를 오버라이딩 했기에
		
		
		// ArrayList 메소드()는 API 문서 참고
		
		
		// 장점1. 크기 제약 x
		// 값 추가
		list.add(new Student("하현호", 85));  // 추가시, 자동 길이 추가
		System.out.println("list : "+list); 
		System.out.println("list에 담긴 element 개수 : "+list.size()); // .size() : ArrayList 배열길이체크
		
		

		
		// 장점2. 추가/삭제/정렬 기능처리 간단
		// add(int index, E elemnet) 
		list.add(0, new Student("류라라",100)); // add(int index, E elemnet) : 맨 앞 위치에 추가
		System.out.println("list : " +list);  // 자동 길이 추가
		list.add(3, new Student("류라라",100)); // 네번째 자리에 추가
		System.out.println("list : " +list);  // 자동 길이 추가
		
		// 삭제
		// remove(int index):E
//		// remove()의 return은 삭제한 값을 돌려준다
		Student s = list.remove(1); // remove의 반환타입은 E이고 (API문서에서 E라고 설명나와있다)
		System.out.println(s);		// 반환타입인 E가 여기서는 지네릭스에서 특정지은 Student라 사용
		System.out.println("list : " +list);  
		
		
		// 삭제
		// remove(Object o):boolean
		list.remove(new Student("강건강",40)); // 주소값 비교
		System.out.println("list : " +list); 
		
		Student kkk = new Student("강건강",40);
		list.remove(kkk);
		System.out.println("list : " +list); 
		
		Student kk = new Student("류라라",100); // Q. 삭제가 안됨
		list.remove(kk);
		System.out.println("list : " +list); 
		
		
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
		
		
		}
	
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	public void doList2() {
			
		ArrayList<Student> list = new ArrayList<Student>(3);	
		list.add(new Student("남나눔",90));
		list.add(new Student("남나눔",90));
		list.add(new Student("남나눔",90));
		System.out.println("list : "+list);
		
		// set(int index, E e)
		// 해당 인덱스 번호에 값  교체
		list.set(0, new Student("박보배",95)); // 
		System.out.println("list : "+list);
		
		
		//get(int index):E
		// 인덱스번호의 엘리먼트 값을 가져온다
		list.get(2);  // 반환값 스튜던트 타입. 이클립스 마우스오버. 첫번째 글자 나오는게 리턴값
		Student s2 = list.get(2);
		System.out.println("get : "+s2);
		//어레이 리스트 안에 스튜던트가 담길 수 있도록 만든 것

		//메소드 안에 포함 되는지
		
		// 지네릭 추가 : <String> 
		ArrayList<String> strlist = new ArrayList<String>();
		
		// contains(Object) : boolean
		// indexObject : int 
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

	
}




