package MVC.model.vo;

public class pModelVo02 implements Comparable{

	private String name;
	private int weight;
	
	public pModelVo02() {}
	public pModelVo02(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	
	
	// getter & setter
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	
	//toString
	@Override
	public String toString() {
		return "("+name+"-"+weight+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		// 객체 비교
		if (this == obj) { // this는 주소값 비교할려고 넣은 것
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) { // 내 클래스 정보와 상대방의 클래스 정보가 같은지 비교
			return false;
		}
		
		pModelVo02 other = (pModelVo02)obj; // 다운캐스팅 : obj->Snack
		if(name == null) {      // other는 레퍼런스 변수
			if(other.name != null) { 
				return false;
			}
		}else if(!name.equals(other.name)) { // 이름에 대한 비교
			return false;
		}
		
		if(weight != other.weight) { // 목록에 대한 비교
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31; // 컴퓨터가 이해하기 좋은 숫자가 31이라함
		int result = 1;
		
		result = PRIME * result + (name == null ? 0 : name.hashCode()); // 내 해쉬코드가 아니라 스트링의 해쉬코드를 가져오는 것
		result = PRIME * result + weight; // 형이 안맞아서 에러나니 캐스팅 또는 소수점 없게끔 계산
		
		return result;
	}
	
	@Override
	public int compareTo(Object o) {
	    // Dog 이름 오름차순
		// Object o를 다운 캐스팅 해줘야함
		pModelVo02 otherP = (pModelVo02)o;
		
		String other = otherP.name;
		
		int result = name.compareTo(other); // compareTO 자체가 인트값 반환
		return 0;
	}
	
}
