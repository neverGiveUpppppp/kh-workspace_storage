package com.kh.model.vo;

import java.sql.Date;

public class Employee2 {

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
	public Employee2() {}
	
	// 매개변수 있는 생성자
	public Employee2(int empNo, String empName, String job, int mgr, Date hireDate, int sal, int comm, int deptNo) {
	    this.empNo = empNo;
	    this.empName = empName;
	    this.job = job;
	    this.mgr = mgr;
	    this.hireDate = hireDate;
	    this.sal = sal;
	    this.comm = comm;
	    this.deptNo = deptNo;
	}
	
	public Employee2(int empNo, String empName, String job, int mgr, int sal, int comm, int deptNo) {
	    this.empNo = empNo;
	    this.empName = empName;
	    this.job = job;
	    this.mgr = mgr;
	    this.sal = sal;
	    this.comm = comm;
	    this.deptNo = deptNo;
	}
	 
	public Employee2(int empNo, String job, int sal, int comm) {
//	    this(job,sal,comm);
		this.empNo = empNo;
	    this.job = job;
	    this.sal = sal;
	    this.comm = comm;
	}
	
	public Employee2(String job, int sal, int comm) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
