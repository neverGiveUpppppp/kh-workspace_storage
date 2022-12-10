
// OOP 8.2. 활용 - 인스턴스화

// 클래스화 to 인스턴스화


class Accounting08_3{		// 인스턴스화
	public double valueOfSupply;		
	public static double vatRate = 0.1;	// 부가가치세는 어느 인스턴스나 10% 고정이기에 static설정이 유리	
										// 인스턴스 만들 때마다 메모리 사용하지 않아도 되고, 
										// vatRate파라미터는 얘 하나로 조절 가능해서 유지보수 용이
	
	// Q.인스턴스가 생성될 때, 인스턴스가 내부적으로 꼭 가져야될 값(valueOfSupply)을 
	//   생성자 레벨에서 강제하고 싶다면?
	// A.아랫줄 코드 추가 및 인스턴스 생생코드 new Accounting(생성자); 생성자 인자부분 채우기
	public Accounting08_3(double valueOfSupply) { // 생성자가 호출될 때 인자를 매개변수로 전달하고 싶기에 public accounting() {}에 valueOfSupply를 넣는다
		this.valueOfSupply = valueOfSupply;		  // this.valueOfSupply는 public double valueOfSupply;의 valueOfSupply를 가리킴
	}											  // 오른쪽 valueOfSupply는 바로 윗줄의 public Accounting08_3(double valueOfSupply)의 valueOfSupply
	public double getVAT() {			// 
	    return valueOfSupply * vatRate; // 
	}
	public double getTotal() {
	    return valueOfSupply + getVAT();
	}
}

public class OOP08_3 {
	
	public static void main(String[] args) {
		
		Accounting08_3 a1 = new Accounting08_3(10000.0);
        a1.valueOfSupply = 10000.0;
        
        Accounting08_3 a2 = new Accounting08_3(20000.0);
        a2.valueOfSupply = 20000.0;
        
        System.out.println("Value of supply : " + a1.valueOfSupply);
        System.out.println("Value of supply : " + a2.valueOfSupply);
        
        System.out.println("VAT : " + a1.getVAT());
        System.out.println("VAT : " + a2.getVAT());
        
        System.out.println("Total : " + a1.getTotal());
        System.out.println("Total : " + a2.getTotal());
        
        
	}
}
