package MVC.controller;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import MVC.model.vo.pModelVo02;

public class pController02 {
	public void firstR() {
		
		HashSet<pModelVo02> hs = new HashSet<>();
		System.out.println("====HashSet====");
		
		hs.add(new pModelVo02("name",1));
		hs.add(new pModelVo02("dont",2));// 순서x
		hs.add(new pModelVo02("dont",2));// 중복x 
		System.out.println(hs);			 // 주소값달라서 중복됨
		
		// 중복 가능케 할려면? 
		// model 데이터에서 오버라이딩or 이미되었는 String,Integer클래스 사용
		HashSet<String> strs = new HashSet<>();
		strs.add(new String("a")); // 모델에서 세팅값의 Set이 아니라서 
		strs.add(new String("b")); // 값이 문자열 하나
		strs.add(new String("b")); // 중복x
		System.out.println(strs);
		
		System.out.println("====LinkedHashSet====");
		// LinkedHashSet
		// 순서유지되는 set
		// add(Object e):boolean
		// 리턴 : 트루반환
		LinkedHashSet<pModelVo02> lhs = new LinkedHashSet<>();
		lhs.add(new pModelVo02("1",1)); // 순서O
		lhs.add(new pModelVo02("2",2)); // 중복x 이나 주소값 달라 중복됨
		lhs.add(new pModelVo02("2",2)); // [(1-1), (2-2)] model에서 오버라이딩 후 중복x
		System.out.println(lhs); // [(1-1), (2-2)] 
		System.out.println(lhs.add(new pModelVo02("3",3))); // true
		System.out.println(lhs); // [(1-1), (2-2), (3-3)]
		
		System.out.println("====TreeSet====");
		// TreeSet
		// 정렬가능 set
		TreeSet<pModelVo02> ts = new TreeSet<>(lhs);// 정렬할 set값 넣기
		System.out.println(ts); // error : comparable x 
		// 에러원인 : 정렬기준점인 comparable없음
		// 에러메세지 : The type pModelVo02 must implement the inherited abstract method Comparable.compareTo(Object)
		// compareTo(Object o) 후 정상작동
		ts.iterator(); // 반복자iterator를 오름차순으로 반환
		System.out.println(ts);
		
		
		Iterator<pModelVo02> it = lhs.iterator(); // iterator 인덱스 없다
		while(it.hasNext()) { 
			pModelVo02 p = it.next(); 
			System.out.println(p);
		}	
		
		
		// String클래스에 comparable이 이미 오버라이딩 되어있어서 정상작동
		TreeSet<String> trs = new TreeSet<>();
		trs.add(new String("a")); // set 중복x
		trs.add(new String("a")); 
		trs.add(new String("d")); // 정렬
		trs.add(new String("c")); 
		trs.add(new String("b"));
		System.out.println(trs);  // [a, b, c, d]
		
		
//		TreeSet<pModelVo02> tss = new TreeSet<>(lhs); // error : java.lang.ClassCastException
//		System.out.println(tss);
		
	}
	
	
//	public void firstR() {
//		
//		// HashSet
//		HashSet<pModelVo02> hset =new HashSet<>();
//		
//		hset.add(new pModelVo02("힘내",1));
//		hset.add(new pModelVo02("포기 ㄴ",2));
//		System.out.println(hset);
//		
//		pModelVo02 pmv = new pModelVo02("a",0);
//		hset.add(pmv);
//		hset.add(new pModelVo02("추가",3));
//		System.out.println(hset);
//		
//		HashSet<String> strSet = new HashSet<String>();
//		strSet.add("안녕");
//		strSet.add(new String("안녕"));
//		System.out.println(hset);
//		System.out.println(strSet);
//		strSet.remove(new String("안녕"));
//		System.out.println(strSet);
//	}
//	public void second() {	
//
//		// LinkedHashSet
//		// 순서 유지
//		LinkedHashSet<pModelVo02> lhSet = new LinkedHashSet();
//		
//		lhSet.add(new pModelVo02("a",1));
//		lhSet.add(new pModelVo02("b",2));
//		System.out.println(lhSet);
//		
//		// TreeSet
//		// 정렬 가능
//		// 정렬 기능 + 기준 필요
//		// 기준이 되는 오버라이딩은 String class 제네릭으로 대체
//		TreeSet<String> tSet = new TreeSet<>();
////		tSet.add(new String("A",1));
//		System.out.println(tSet);
//		
//		tSet.add("A");
//		tSet.add("C");
//		tSet.add("B"); 			  // 추가 순서는 ACB
//		System.out.println(tSet); // 결과는        ABC (정렬 적용 확인)
//		
//	}

}
