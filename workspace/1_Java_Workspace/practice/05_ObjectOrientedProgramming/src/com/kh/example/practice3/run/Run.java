package com.kh.example.practice3.run;

import com.kh.example.practice3.model.vo.Circle;

public class Run {
	public static void main(String[] args) {

		Circle c = new Circle();
		System.out.println("초기 원의 넓이와 둘레값");
		c.getAreaOfCircle();
		c.getSizeOfCircle();
		
		System.out.println();
		System.out.println("반지름 1증가");
		c.incrementRadius();
		
		System.out.println("반지름 1증가 후 원의 널비와 둘레 값");
		c.getAreaOfCircle();
		c.getSizeOfCircle();
		
	}

}
