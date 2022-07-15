package com.kh.example.chap02.set.model.vo;

public class Dog2 implements Comparable{ // java.lang.(Interface) Comparable
	// Dog2 error : Comparable추상메소드(compareTo())를 오버라이딩 하지않아서
	// Comparable 노란줄 이유 : <> 지네릭 제한 안해서
	
	/*
	java.lang
	Interface Comparable<T> 
	<T> : 제네릭
	
	*/
	private String name;
	private double weight;
	
	public Dog2() {}
	public Dog2(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	// Comparable에 제네릭 지정 버젼
//	@Override
	public int compareTo(Dog o) {
//		String other = 0.name;
//		return name.compareTo(other);
		return name.compareTo(o.name); // 오름차순
		return -name.compareTo(o.name);// 내림차순 : -붙이기
	}
	
	// Comparable에 제네릭 미지정 버전
	@Override
	public int compareTo(Object o) {
	    // Dog 이름 오름차순
		// Object o를 다운 캐스팅 해줘야함
		Dog otherDog = (Dog)o;
		
		String other = otherDog.name;
		
		int result = name.compareTo(other); // compareTO 자체가 인트값 반환
		return 0;
	}
	
	
	
	// getter & setter
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
	
	//toString
	@Override
	public String toString() {
		return name+"("+weight+"kg)";
	}
	
	// 사용자 정의 클래스를 오버라이딩 해서 값 자체를 비교하기 위한 코드
	// (String과 Integer는 오버라이딩이 이미 되어있음)
	@Override
	public boolean equals(Object obj) {
		// 내 주소값과 obj의 값이 같다면?
		// 같은 주소값인데 다른 객체일리는 없다
		// 이퀄 맞고 리턴 트루해준다
		
		// 이퀄즈의 비교 내용 2가지
		// 1.클래스 비교
		// 2.내용 비교
		
		if (this == obj) { // this는 주소값 비교할려고 넣은 것
			return true;
		}
		if(obj == null) {
//		내 객체가 이미 올라가있는 상태. 그리고 나서 내 안에 이퀄즈를 호출해오는 것
//		따라서 this는 반드시 존재함. this가 null일 수가 없음
			return false;
		}
		if(getClass() != obj.getClass()) {
			// 내가 가진 클래스 정보랑 니가가진 클래스정보랑 다르면 같다고 할 수 없으니 false
			return false;
		}
		
		Dog2 other = (Dog2)obj; // 다운캐스팅 : obj->Dog
		if(name == null) {
			if(other.name != null) { // other는 레퍼런스 변수
				return false;
			}
		}else if(!name.equals(other.name)) { // 이름에 대한 비교
			return false;
		}
		
		if(weight != other.weight) { // 목록에 대한 비교
			return false;
		}
		return true;
		
		// equals 오버라이딩 하는 방법이 클래스 비교는 그대로이고 내용비교만 
		// 해당 모델에 따라서 변수의 타입과 갯수에 따라 달라지는게 맞는거죠? yes

		// equals 오버라이딩 완료
		// 이퀄즈를 했으면 hashcode도 같이 오버라이딩 해야함
				
	}
	@Override
	public int hashCode() {
		final int PRIME = 31; // 컴퓨터가 이해하기 좋은 숫자가 31이라함
		int result = 1;
		
		result = PRIME * result + (name == null ? 0 : name.hashCode()); // 내 해쉬코드가 아니라 스트링의 해쉬코드를 가져오는 것
		result = PRIME * result + (int)weight; // 형이 안맞아서 에러나니 캐스팅 또는 소수점 없게끔 계산
		
		
		return result;
	}

	
}
