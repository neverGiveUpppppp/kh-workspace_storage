package com.kh.operator;

public class A_LogicalNagation {
	public void method() {
		boolean bool1 = true;
		boolean bool2 = false;
		boolean bool3 = !true;
		boolean bool4 = !false;
		
		System.out.println("bool1 : " + bool1); 	// true
		System.out.println("bool2 : " + bool2);		// false
		System.out.println("bool3 : " + bool3);		// false
		System.out.println("bool4 : " + bool4);		// true
		
		System.out.println("!bool1 : " + !bool1);	// false
		System.out.println("!bool2 : " + !bool2);	// true
		System.out.println("!bool3 : " + !bool3);	// true
		System.out.println("!bool4 : " + !bool4);	// false
	}
}
