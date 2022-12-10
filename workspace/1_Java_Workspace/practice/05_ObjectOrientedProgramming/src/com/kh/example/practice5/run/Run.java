package com.kh.example.practice5.run;

import com.kh.example.practice5.model.vo.Employee;

public class Run {
	public static void main(String[] args) {

		Employee e = new Employee();
		e.setEmpNo(100);
		e.setEmpName("홍길동");
		e.setDept("영업부");
		e.setJob("과장");
		e.setAge(25);
		e.setGender('남');
		e.setSalary(2500000);
		e.setBonusPoint(0.05);
		e.setPhone("010-1234-5678");
		e.setAddress("서울시 강남구");
				
		e.getEmpNo();
		e.getEmpName();
		e.getDept();
		e.getJob();
		e.getAge();
		e.getGender();
		e.getSalary();
		e.getBonusPoint();
		e.getPhone();
		e.getAddress();
		
		int eNo = e.getEmpNo();
		String eName = e.getEmpName();
		String dept_ = e.getDept();
		String job_ = e.getJob();
		int age_= e.getAge();
		char gender_ = e.getGender();
		int salary_ = e.getSalary();
		double bonus_ = e.getBonusPoint();
		String phone_ = e.getPhone();
		String addrs = e.getAddress();
		
		// 변수 도입 출력 방식
		System.out.println("empNo : " + eNo);
		System.out.println("empName : " + eName);
		System.out.println("dept : " + dept_);
		System.out.println("job : " + job_);
		System.out.println("age : " + age_);
		System.out.println("gender : " + gender_);
		System.out.println("salary : " + salary_);
		System.out.println("bonus : " + bonus_);
		System.out.println("phone : " + phone_);
		System.out.println("address : " + addrs);
		
		// 다이렉트 모니터 출력 방식
//		System.out.println(e.getEmpNo());
//		System.out.println(e.getEmpName());
//		System.out.println(e.getDept());
//		System.out.println(e.getJob());
//		System.out.println(e.getAge());
//		System.out.println(e.getGender());
//		System.out.println(e.getSalary());
//		System.out.println(e.getBonusPoint());
//		System.out.println(e.getPhone());
//		System.out.println(e.getAddress());
		
		
	}

}
