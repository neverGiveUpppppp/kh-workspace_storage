
// OOP 8.2. 활용 - 인스턴스화

// 클래스화 to 인스턴스화

 
 
//class Accounting08_2{		// 클래스화
//
//    public static double valueOfSupply;		
//    public static double vatRate = 0.1;		
//    public static double getVAT() {
//        return valueOfSupply * vatRate;
//    }
//    public static double getTotal() {
//        return valueOfSupply + getVAT();
//    }
//}
//					클래스화
//             ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//					인스턴스화


class Accounting08_2{		// 인스턴스화
	// 인스턴스 소속, static 제거
	// static은 클래스소속이고 클래스가 인스턴스에 접근하면 에러나는건 어떤 인스턴스인지 모르기때문 a1?a2?
	public double valueOfSupply;		
	public static double vatRate = 0.1;	// 부가가치세는 어느 인스턴스나 10% 고정이기에 static설정이 유리	
	public double getVAT() {			// 인스턴스 만들 때마다 메모리 사용하지 않아도 되고, 
	    return valueOfSupply * vatRate; // vatRate파라미터는 얘 하나로 조절 가능해서 유지보수 용이
	}
	public double getTotal() {
	    return valueOfSupply + getVAT();
	}
}

public class OOP08_2 {
	
	public static void main(String[] args) {
		
//		클래스화의 경우
//		내부적인 상태가 한번 세팅이되면 여러 작업들이 끝나고 그 다음에 새로운 내부적인 상태가 변화가 오는 
//		케이스에서도 클래스를 인스턴스화 시킬 필요는 없다고 본다
		
//		그런데 클래스의 상태가 계속 바뀌어야하는 상황이라면?
//		ex) 공급가액(vauleOfSupply) 1만 세팅에서 2만,3만 등 경우의수가 엄청나게 많아지고 계속 바꿔가면서 써야한다면? 
//		공급가액(vauleOfSupply)이 하나가 아닌 내부적으로 수십개의 값들이 있고 계속 바꿔야한다면 버그 발생 확률 고위험 
//		 - 하나의 클래스를 여러상태에서 돌려써서 버그발생 확률이 높아지게 되는 것
//		 - 이럴 때 인스턴스화
		
//		인스턴스화의 경우
//		독립된 인스턴스기에 상태별로 인스턴스를 만들어서 분리시키고 개별맞춤으로 관리가능
		
//		아래처럼 내부 상황이 자주 변하고 valueOfSupply가 내부적으로 여러가지이고 자주 변한다면 
//		인스턴스화가 유리		
//        Accounting08_2.valueOfSupply = 10000.0;		
//        System.out.println("Value of supply : " + Accounting.valueOfSupply);
//        System.out.println("VAT : " + Accounting.getVAT());
//        System.out.println("Total : " + Accounting.getTotal());
//        
//        Accounting08_2.valueOfSupply = 20000.0;		
//        System.out.println("VAT : " + Accounting.getVAT());
//        
//        Accounting08_2.valueOfSupply = 50000.0;		
//        System.out.println("VAT : " + Accounting.getVAT());
//        
//        Accounting08_2.valueOfSupply = 900.0;		
//        System.out.println("Total : " + Accounting.getTotal());
//        
//        
		Accounting08_2 a1 = new Accounting08_2();
        a1.valueOfSupply = 10000.0;
        
        Accounting08_2 a2 = new Accounting08_2();
        a2.valueOfSupply = 20000.0;
        
        System.out.println("Value of supply : " + a1.valueOfSupply);
        System.out.println("Value of supply : " + a2.valueOfSupply);
        
        System.out.println("VAT : " + a1.getVAT());
        System.out.println("VAT : " + a2.getVAT());
        
        System.out.println("Total : " + a1.getTotal());
        System.out.println("Total : " + a2.getTotal());
        
        
	}
}
