package com.kh.example.chap03.map.compare;
import java.util.Comparator;

public class SnackComparator implements Comparator<String> { // 노란줄 : 제네릭 써달라. 제네릭 뭘 넣어야할까?
	// 기준 없는데 Comparator를 쓴 이유?
	// String 객체 안에 이미 기준이 한개 있어서 
	// 스낵한테 정렬 기준을 세워준 적이 없는데 컴퍼러블부터 안하고 컴퍼레이터부터하지?
	// 맵에서는 맵에서의 정렬 기준은 키.
	// String이 이미 comparable을 사용하고 있다 : String (comparable)
	// key가 String으로 되어서 comparable이 이미 구현되어서 그런 것

	@Override // 내림차순으로 만듬
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2);
	}
	
	
}
