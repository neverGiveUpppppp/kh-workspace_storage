package com.kh.example.chap03.map.controller;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import MVC.model.vo.pModelVo04;

public class MapController_arranged {
	
	// Map
	// {key=value} 형식으로 출력됨 // map도 중괄호{} 찍혀서 나온다
	public void pMap() {
		
		// 1.HashMap
		// 2.TreeMap
		
		
		// 1.HashMap
		// put(K key, V value):V
		// 반환타입 : value
		System.out.println("===HashMap===");
		
		HashMap<String, pModelVo04> hmap = new HashMap<>();
		
		hmap.put(new String("블루베리류"), new pModelVo04("블루베리",100)); // 순서x
		hmap.put(new String("사과류"), new pModelVo04("아오리",200));
		System.out.println(hmap);	// {사과류=아오리[200원], 블루베리류=블루베리[100원]}
		System.out.println(hmap.put(new String("참외류"), new pModelVo04("참외",300))); // null
		System.out.println(hmap.put(new String("1"), new pModelVo04("1",300))); 	// null
		System.out.println(hmap);		// {사과류=아오리[200원], 블루베리류=블루베리[100원], 참외류=참외[300원]}
		
		
		
		// 2.containsKey(Object key)
		// 키나 값이 들어가 있는지를 확인하는 메소드
		// containsKey(Object key):boolean	
		// containsValue(Object value):boolean	
		
		hmap.containsKey(new String("블루베리류"));
		System.out.println(hmap);   // {사과류=아오리[200원], 1=1[300원], 블루베리류=블루베리[100원], 참외류=참외[300원]}
		System.out.println(hmap.containsKey(new String("블루베리류")));// true
		
		hmap.containsValue(new pModelVo04("블루베리",100));
		System.out.println(hmap.containsValue(new pModelVo04("블루베리",100))); // false
		System.out.println(hmap.containsValue(new pModelVo04("블루베리",100))); // true    // model에서 오버라이딩 후 true
		
		
		// 3.get()
		// get(Object key) : v
		// key값에 맞는 'value값 반환'
		hmap.get(new String("참외류"));
		System.out.println(hmap.get(new String("사과류"))); // 아오리[200원]
		System.out.println(hmap.getClass()); // class java.util.HashMap
		System.out.println(hmap); // {사과류=아오리[200원], 1=1[300원], 블루베리류=블루베리[100원], 참외류=참외[300원]}
		
		System.out.println("===4.remove()======");
		// 4-1.remove(Object key):V
		System.out.println(hmap.remove("1")); // 1[300원]
		System.out.println(hmap); // {사과류=아오리[200원], 블루베리류=블루베리[100원], 참외류=참외[300원]}
		
		// 4-2.remove(Object key, Object value):default boolean
		System.out.println(hmap.remove(new String("블루베리류"),new pModelVo04("블루베리",100)));//true 오바라이딩 적용
		hmap.remove(new String("블루베리류"),new pModelVo04("블루베리",100));
		System.out.println(hmap); // {사과류=아오리[200원], 참외류=참외[300원]} 오버라이딩 적용
		

		
		// 5.keySet() & entrySet()
		System.out.println("===keySet() & entrySet()======");
		
		// keySet()
		// keySet():Set<K>
		// 맵에 있는 key들을 set에 담아 반환
		
		// 방법1
		System.out.println(hmap.keySet()); // [사과류, 참외류]
		
		// 방법2
		// set의 [] 없이 안에 값만 뽑고 싶다면 방법2 사용
		Set<String> sset = hmap.keySet();
		Iterator<String> is = sset.iterator();
		while(is.hasNext()) {
			String s = is.next();
			System.out.print(s+" "); // 사과류  참외류 
		}
		System.out.println();
		
		
		// entrySet()
		// entrySet():Set<Map.Entry<K,V>>
		// map에 있는 entry들을 set 담에 반환(키와 값의 쌍을 set에 담아 반환)
		// entry 의미 : 키와 값을 묶은 것(키와 값의 쌍)
		
		// 방법1
		System.out.println(hmap.entrySet());//[사과류=아오리[200원], 참외류=참외[300원]]
		
		// 방법2
		// set의 [] 없이 안에 값만 뽑고 싶다면 방법2 사용
		Set<Entry<String,pModelVo04>> eset = hmap.entrySet();
		Iterator<Entry<String,pModelVo04>> it_eset = eset.iterator();
		while(it_eset.hasNext()){
			Entry<String, pModelVo04> a = it_eset.next();
			System.out.print(a+" ");  		// 사과류=아오리[200원] 참외류=참외[300원] 
		}									
		System.out.println();
		
		
		// size():int
		System.out.println(hmap.size()); // 2
		
		
		
		// TreeMap
		// 정렬 가능 
		System.out.println("===TreeMap===");
		
		TreeMap<String,pModelVo04> treeM = new TreeMap<>();
		
		treeM.put(new String("TreeMap"),new pModelVo04("Map",1));
		System.out.println(treeM.put(new String("TreeMap"),new pModelVo04("Map",1)));//Map[1원]
		System.out.println(treeM); // {TreeMap=Map[1원]}
		treeM.put(new String("a"), new pModelVo04("b",2));
		System.out.println(treeM);
		
		// putAll()
		// putAll(Map<? extends K,? extends V> m):void
		// 다른 맵의 값을 추가
		treeM.putAll(hmap);
		System.out.println(treeM); // {TreeMap=Map[1원], 사과류=아오리[200원], 참외류=참외[300원]}
		
		// remove(Object key):V
		System.out.println(treeM.remove(new String("참외류"))); // 참외[300원]
		System.out.println(treeM); // {TreeMap=Map[1원], 사과류=아오리[200원]}
		
		// replace(K key, V oldValue, V newValue):boolean
		treeM.replace(new String("TreeMap"),new pModelVo04("Map",1), new pModelVo04("맵",2)); 
		System.out.println(treeM); // {TreeMap=맵[2원], 사과류=아오리[200원]}
		
		// remove(Object key, Object value):boolean
		System.out.println(treeM.remove(new String("사과류"),new pModelVo04("아오리",200))); // true 오버라이딩 적용
		treeM.remove(new String("사과류"),new pModelVo04("아오리",200));
		System.out.println(treeM); // {TreeMap=맵[2원]}
		
		

		
	}	
		
}
