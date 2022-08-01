

public class method06 {
	public static double valueOfSupply = 10000.0; // 공급가액
	public static double vatRate = 0.1;           // 부가가치 세율
	// public static이라 붙이는 의미 : 위의 method06 클래스의 직접적인 소속이라는 것
	
	
	public static double getVAT() {
		return valueOfSupply * vatRate;
	}
	public static double getTotal() {
		return valueOfSupply + getVAT();
	}
	
	
	public static void main(String[] args) {
	
	
		
	// 지역변수
//	double vat = valueOfSupply * vatRate;  // 부가세
	double vat = getVAT(); // 위와 같은 코드. get메소드 get변수명의 변수값을 가져온다
//	double total = valueOfSupply + vat;    // 합계
	double total = getTotal();
	
	
	System.out.println("Value of supply : " + valueOfSupply);
	System.out.println("VAT : " + vat);
	System.out.println("Total : " + total);
	
	// 메소드 사용의 장점
	// 1.코드의 가독성↑
	// 2.재사용 용이 : 호출만 하면 됨
	// 3.유지보수 관리 용이
	
	}
}
