package MVC.model.vo;
import java.sql.Date;

public class pModelVo07 {
//  VO : Vaule Object
//		 데이터를 잠시 담아두는 ‘임시 저장공간’
//    	 변수로써 사용
//	 	 Read-Only속성을 값 오브젝트
//   	  자바에서 단순히 값 타입을 표현하기 위해 불변 클래스(Read-Only)를 만들어 사용

	private int empNo; // 사번
	private String empName; // 이름
	private String job; // 직책
	private int mgr; // 직속 상사(manager)
	private Date hireDate; // java.sql.Date // 고용일
	private int sal; // 급여
	private int comm; // 커미션(인센티브)
	private int deptNo; // 부서번호

	
	public pModelVo07() {}
	public pModelVo07(String job, int sal, int comm) {
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	public pModelVo07(int empNo, String job, int sal, int comm) {
		this(job, sal, comm);
		this.empNo = empNo;
	}
	public pModelVo07(int empNo, String empName, String job, int mgr, int sal, int comm, int deptNo) {
		this(job,sal,comm);
		this.empNo = empNo;
		this.empName = empName;
		this.mgr = mgr;
		this.deptNo = deptNo;
	}
	public pModelVo07(int empNo, String empName, String job, int mgr, Date hireDate, int sal, int comm, int deptNo) {
		this(job,sal,comm);
		this.empNo = empNo;
		this.empName = empName;
		this.mgr = mgr;
		this.deptNo = deptNo;
		this.hireDate = hireDate;
	}
	
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
		return empNo+" / "+empName+" / "+job+" / "+mgr+" / "+hireDate+" / "+sal+" / "+comm+" / "+deptNo+" / ";
	}
	
}




