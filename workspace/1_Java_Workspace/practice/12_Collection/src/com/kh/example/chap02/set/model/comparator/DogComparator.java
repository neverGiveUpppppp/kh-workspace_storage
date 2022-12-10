package com.kh.example.chap02.set.model.comparator;

import java.util.Comparator;

import com.kh.example.chap02.set.model.vo.Dog;

//public class DogComparator implements Comparator<>{
public class DogComparator implements Comparator<Dog>{

	// 제네릭 지정 버젼
	@Override
	public int compare(Dog o1, Dog o2) {
		
		return 0;
	}
	// 제네릭 미지정 버젼
	@Override
	public int compare(Object o1, Object o2) {
		Dog standardDog = (Dog)o1;
		Dog objectDog = (Dog)o2;
		
		double standard = standardDog.getWeight(); // 기준
		double object = objectDog.getWeight();     // 비교
		
		if(standard > object) {
			return 1;
			
		}else if (standard == object) {
			return 0;
		}else {
			return -1;
		}// 내림차순 하고 싶으면 return 값만 뒤집으면 된다
		
	}
	
	
}
