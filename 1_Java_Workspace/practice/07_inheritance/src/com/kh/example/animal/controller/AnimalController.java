package com.kh.example.animal.controller;
import com.kh.example.animal.model.vo.Animal_상속;
import com.kh.example.animal.model.vo.Dog_상속;
import com.kh.example.animal.model.vo.Snake_상속;

public class AnimalController {
	public void method() {
		Animal_상속 a = new Animal_상속("강아지",9,6.4);
//		System.out.println(a.inform());
		System.out.println(a);
		System.out.println(a.toString());
		
		
		Dog_상속 d = new Dog_상속("두부",1,4.2,50,"장모");
//		System.out.println(d.inform());
		System.out.println(d);
		System.out.println(d.toString());
		
		Snake_상속 s = new Snake_상속("방울이",4,10.2,"빗살");
//		System.out.println(s.inform());
		System.out.println(s);
		System.out.println(s.toString());
		
	}
}
