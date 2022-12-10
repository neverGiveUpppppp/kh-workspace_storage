package MVC.model.vo;


public class pModelVo04 {


	private String flavor;
	private int price;
	
	public pModelVo04() {}
	public pModelVo04(String flavor, int price) {
		super(); // 안써도 됨. 자동완성해서 생긴것. 원래는 생성자를 불러올 때 부모생성자를 불러오고 시작함. 
		this.flavor = flavor;   // 그래야 자식 객체를 만들 때 부모 객체 생성자를 만들기 때문
		this.price = price;
	}
	
	// getter / setter
	public String getFlavor() {
		return flavor;
	}
	public int getPrice() {
		return price;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// toString
	@Override
	public String toString() {
		return flavor+"["+price+"원]";
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
		
		pModelVo04 other = (pModelVo04)obj; // 다운캐스팅 : obj->Snack
		if(flavor == null) {      // other는 레퍼런스 변수
			if(other.flavor != null) { 
				return false;
			}
		}else if(!flavor.equals(other.flavor)) { // 이름에 대한 비교
			return false;
		}
		
		if(price != other.price) { // 목록에 대한 비교
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31; // 컴퓨터가 이해하기 좋은 숫자가 31이라함
		int result = 1;
		
		result = PRIME * result + (flavor == null ? 0 : flavor.hashCode()); // 내 해쉬코드가 아니라 스트링의 해쉬코드를 가져오는 것
		result = PRIME * result + price; // 형이 안맞아서 에러나니 캐스팅 또는 소수점 없게끔 계산
		
		return result;
	}	
		
	
	
}
