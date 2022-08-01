package com.kh.model.vo;
// 
//model VO(Vaule Object) :데이터를 잠시 담아두는 ‘임시 저장공간’
//변수로써 사용
//Read-Only속성을 값 오브젝트
//자바에서 단순히 값 타입을 표현하기 위해 불변 클래스(Read-Only)를 만들어 사용

/*
 * DTO : Data Transfer Object 
 * VO라고도 표현하며 계층 간 데이터 교환을 위한 자바 빈즈(Java Beans)이다.
 * 
 * 데이터베이스 레코드의 데이터를 매핑하기 위한 데이터 객체를 의미한다.
 * 
 * DTO는 보통 로직을 가지고 있지 않고 Data와 그 Data에 접근을 위한 getter, setter만 가지고 있다.
 * 
 * 즉 DTO는 DataBase에서 Data를 얻어 Service나 Controller 등으로 보낼 때 사용하는 객체를 말한다.
*/

/*
 * VO : Value Object
 * 값 오브젝트로써 값을 위해 쓰인다.
 * 
 * 자바는 값 타입을 표현하기 위해 불변 클래스를 만들어 사용하는데, 불변이라는 것은 read only 특징을 가진다.
 * 
 * DTO와 VO의 공통점은 넣어진 데이터를 getter를 통해 사용하므로 주 목적은 같으나 VO는 불변의 성격을 가졌다.
*/


import java.sql.Date;

public class Employee {

// - empNo : int	
// - empName : String
// - job : String
// - mgr : int
//	- hireDate : Date(java.sql)
//	- sal : int
//	- comm : int
//	- deptNo : int
//	
//	+Employee()
//	+Employee(job:String, sal:int, comm:int)
//	+Employee(empNo:int, job:String, sal:int, comm:int)
//	+Employee(empNo:int, empName:String, job:String, mgr:int, sal:int, comm:int, deptNo:int)
//	+Employee(empNo:int, empName:String, job:String, mgr:int, hireDate:Date, sal:int, comm:int, deptNo:int)
//	+getter/setter
//	+toString():String
//		empNo / empName / job / mgr / hireDate / sal / comm / deptNo		
	
	
//	private int empNo;
//	private String empName;
//	private String job;
//	private int mgr;
//	private Date hireDate;
//	private int sal;
//	private  int comm;
//	private  int deptNo;

	private int empNo; // 사번
	private String empName; // 이름
	private String job; // 직책
	private int mgr; // 직속 상사(manager)
	private Date hireDate; // java.sql.Date // 고용일
	private int sal; // 급여
	private int comm; // 커미션(인센티브)
	private int deptNo; // 부서번호

	
	
	// default constructor
	public Employee() {}
	
	// 매개변수 있는 생성자
	public Employee(int empNo, String empName, String job, int mgr, Date hireDate, int sal, int comm, int deptNo) {
	    this.empNo = empNo;
	    this.empName = empName;
	    this.job = job;
	    this.mgr = mgr;
	    this.hireDate = hireDate;
	    this.sal = sal;
	    this.comm = comm;
	    this.deptNo = deptNo;
	}
	
	public Employee(int empNo, String empName, String job, int mgr, int sal, int comm, int deptNo) {
	    this.empNo = empNo;
	    this.empName = empName;
	    this.job = job;
	    this.mgr = mgr;
	    this.sal = sal;
	    this.comm = comm;
	    this.deptNo = deptNo;
	}
	 
	public Employee(int empNo, String job, int sal, int comm) {
//	    this(job,sal,comm);
		this.empNo = empNo;
	    this.job = job;
	    this.sal = sal;
	    this.comm = comm;
	}
	
	public Employee(String job, int sal, int comm) {
	    this.job = job;
	    this.sal = sal;
	    this.comm = comm;
	}
	   

			
		
	// getter & setter
	public int getEmpNo() {
		return empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public String getJob() {
		return job;
	}
	public int getMgr() {
		return mgr;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public int getSal() {
		return sal;
	}	
	public int getComnn() {
		return comm;
	}
	public int getDeptNo() {
		return deptNo;
	}
	
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public String toString() {
		return empNo + " / " + empName + " / " + job + " / " + mgr + " / " + hireDate +  " / " + sal +
				 " / "  + comm +  " / "  + deptNo;
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
