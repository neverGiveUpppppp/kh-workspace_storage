package com.kh.practice.student.run;
import com.kh.practice.student.controller.StudentController;

public class Run {
	public static void main(String[] args) {
	
		StudentController sc = new StudentController();
		sc.printStudent();
		System.out.println(sc.printStudent());
		
	}
}
