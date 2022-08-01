package com.kh.example.chap03.map.controller;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.chap03.map.compare.SnackComparator;
import com.kh.example.chap03.map.model.vo.Snack;

public class MapController {
	Scanner sc = new Scanner(System.in);
			
	
	public void doMap() {
		
		HashMap<String, Snack> map = new HashMap<String, Snack>();
//		HashMap<String, Snack> map = new HashMap<>(); // 타입추론 적용
		// HashMap 객체 생성( 키는 String 객체가, 값은 Snack 객체가 들어갈 수 있는)

		// 1.put()
		// put(K key, V value):V
		// 반환값이 value
		// 같은 키가 있을 때 덮어씌워야하니까 그 이전값을 반환하는거. 지금은 새로값을 넣기에 이전 값이 없어서 null이 뜨는 것
		// 반환하는 value값이 이전값. 이전값이 없으면 null 반환.
		map.put("새우깡", new Snack("짠맛",1500)); // 결과값 : 짠맛[1500원]  
		System.out.println(map.put("새우깡", new Snack("짠맛",1500))); // 결과값 : null
		System.out.println(map); // 결과값 : {새우깡=짠맛[1500원]} 
								 // {key=value} 형식으로 출력됨 // map도 중괄호{} 찍혀서 나온다 
		
		map.put("새우깡",new Snack("짠맛",1500)); 	  // 순서 유지x
		map.put("다이제",new Snack("단맛",2500)); 	  // 순서 유지x
		map.put("포테이토칩",new Snack("짠맛",1500)); // 순서 유지x
		map.put("고소미",new Snack("고소한 맛",1000)); // 순서 유지x
		System.out.println(map);
		
		System.out.println(map.put("새우깡",new Snack("매운맛",1500))); // 같은 키값으로 새롭게 집어 넣으면 새롭게 집어놓은 value가 덮어씌움. 짠맛->매운맛 변경됨
		System.out.println(map); // 이전에 있던 밸류값이 있으면 반환하고 없으면 새로 집어 넣는거는 null값이 뜨게 된다
		
		
		// 2.containsKey(Object key)
		// 키나 값이 들어가 있는지를 확인하는 메소드
		//
		// containsKey(Object key):boolean	
		// containsValue(Object value):boolean	
		System.out.println(map.containsKey("새우깡")); // true : key에 새우깡이 존재해서 true 반환
													 // 
		System.out.println(map.containsValue(new Snack("짠맛",1500))); // false : 주소값이 달라서 없다고 나옴
		// containsValue나 containsKey나 주소값체크하지만 key에는 String Class라 오버라이딩 되어있음
		// containsValue는 Snack 클래스라 오버라이딩x라서 false 뜬 것
		
		// Snack class 오버라이딩 이후 map.containsValue(new Snack("짠맛",1500)) : 결과값 true
		

		// 3.get()
		// get(Object key) : v
		// key값에 맞는 value값 반환
		System.out.println(map.get("새우깡")); // 결과값 : 매운맛[1500원]
											 // 없는 값을 호출하면? null
		System.out.println(map.get("홈런볼")); // 결과값 : null
		
		// index가 없기에 for문 사용불가
		// 반복할려면 뭘 써야할까? iterator 사용?
		// 문제는 iterator는 리스트 셋에서만 사용가능
		// Map에서 그럼 뭘 써야할까?
		// 해결책
		// 1)keySet():Set<K>
		// 맵에 있는 key들을 set에 담아 반환
		// 2)entrySet():Set<Map.Entry<K,V>>
		// 
		// 둘다 반환값이 set
		
		
		
		// 1)keySet():Set<K>
		// 맵에 있는 key들을 set에 담아 반환
		// keySet에 제네릭 값은 String, why?
		// 맵에 대한 제네릭은 스트링으로 위에서 지정했고 맵에 있는 키들을 set에 담아 반환하기 때문에
		// set의 제네릭에는 String 밖에 못들어감. 즉, 맵의 키값을 string으로 지정해서
		
		// 방법1
		System.out.println("keySet="+map.keySet()); // [다이제, 새우깡, 포테이토칩, 고소미]
		
		// 방법2
		Set<String> set1 = map.keySet();
		Iterator<String> it1 = set1.iterator(); // 셋안에 스트링값이 들어가 있기에 스트링을 제너릭으로
		while(it1.hasNext()) {
			String key = it1.next();
			System.out.println("ketSet:"+key+" : "+map.get(key)); // 키값을 뽑았으니 밸류값도 get()메소드로 추출
		} // ketSet:다이제 : 단맛[2500원] ketSet:새우깡 : 매운맛[1500원] ketSet:포테이토칩 : 짠맛[1500원] ketSet:고소미 : 고소한 맛[1000원]
		// Q.방법1이 쉬운데 방법2가 필요한 경우는?
		// A.방법1 keySet()) // [내, 힘, 라]의 결과값이 나오는데 set 때문에 대괄호[]에 묶여 나오고
		//	  방법2는  출력 결과(내 힘 라)를 문자열 하나씩 뺄 수 있다

		
		
		// 2)entrySet()
		// entrySet():Set<Map.Entry<K,V>>
		// entry 의미 : 키와 값을 묶은 것(키와 값의 쌍)
		// map에 있는 entry들을 set 담에 반환(키와 값의 쌍을 set에 담아 반환)
		
		Set<Entry<String, Snack>> set2 = map.entrySet(); // java.util entry
		// <Entry<String, Snack>> : 셋안에 엔트리들이 있고 엔트리들은 키와값이 쌍이니까 키와 값의 제너릭을 각각 지정해준 것
		
		Iterator<Entry<String, Snack>> it2 = set2.iterator(); // 이터레이너는 엔트리 안에 있는 것들을 하나하나 꺼내므로 제네릭은 Entry
		while(it2.hasNext()) {
			Entry<String, Snack> entry = it2.next();
			System.out.println(entry+" : "+entry.getValue()); // 키값을 뽑았으니 밸류값도 get()메소드로 추출
		} // 엔트리 하나로 키와 밸류 둘 다 뽑는 것
		
		System.out.println("=====================");
		
		// TreeMap
		TreeMap<String, Snack> map2 = new TreeMap<>(map);
		System.out.println(map2);
		
		TreeMap<String, Snack> map3 = new TreeMap<>(new SnackComparator());
		map3.putAll(map);
		System.out.println(map3);
		
		
		
		// size():int
		System.out.println(map3.size());
		
		// remove(Object key):V
		System.out.println(map3 );
		System.out.println(map3.remove("다이제"));
		System.out.println(map3 );
		
		// replace(K key, V oldValue, V newValue):boolean
		// 키 밸류 둘 다 맞아야 삭제하는 메소드
		System.out.println(map3.remove("고소미",new Snack("고소한 맛",1000)));
		System.out.println(map3);
		System.out.println(map3.remove("포테이토",new Snack("짠맛",1500))); // 둘 다 맞아야 삭제됨
		
		
		// clear():void
		map3.clear();
		System.out.println(map3); // 결과값 : {}
		// isEmpty():boolean
		System.out.println(map3.isEmpty()); // 결과값 : true
		
		System.out.println("=========================");
		System.out.println("========Properties=======");
		
	}
	
	public void doProperties() {
		
		Properties prop = new Properties();
		// key와 value를 String으로 제한시켜놓은 Map구조의 컬렉션
		
		prop.setProperty("채소", "오이");
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");
		prop.setProperty("채소", "피망");  // 채소,오이->피망
		System.out.println(prop);		// {과일=사과, 채소=피망, 간식=젤리}
		
		System.out.println(prop.getProperty("채소")); // 결과값 : 피망 
		System.out.println(prop.getProperty("견과")); // 결과값 : null
		System.out.println(prop.getProperty("채소","배추")); // 프로퍼티도 오버로딩이 되어있음
		System.out.println(prop.getProperty("견과","땅콩")); // 원래 null인데 땅콩이 나옴
		
		// getProperty(String key, String defaultValue):String
		// key값이 존재하면 그 key에 해당하는 value값을 반환
		// key값이 존재하지 않으면 defaultValue를 반환

		 
		 
		 
		 
		 
		
	}
		
		
		
}
