
// OOP 8 .1. 활용 - 클래스화


// 메소드 사용방식에서 클래스화 시키면서 정리정돈
// 1)새클래스 생성
// 2)관련 카테고리의 기존 메소드들을 새클래스 안으로 이주
// 3)기존 메소드들 앞에 클래스명 추가 : Accounting.
// +@ 클래스를 따로 파일화해서 분리관리 


// 목차
// 1.기존 메소드 방식 코드
// 2.클래스화된 코드



// 1.기존 메소드 방식 코드
// public class OOP08_1 {
//	 public static double valueOfSupply = 10000.0;
//	 public static double vatRate = 0.1;
//	 public static double  getVAT() {
//		 return valueOfSupply * vatRate;
//	 }
//	 public static double getTotal() {
//		 return valueOfSupply + getVAT();
//	 }
//	 public static void main(String[] args) {
//		 System.out.println("Value of supply : " + valueOfSupply);
//		 System.out.println("VAT : " + getVAT());
//		 System.out.println("Total : " + getTotal());
//	 }
// }

 
 
// 2.클래스화된 코드
class Accounting{
	
    public static double valueOfSupply;		// 공급가액	// 파라미터는 메인메소드 안에서 설정함
    public static double vatRate = 0.1;		// 부가가치세율
    public static double getVAT() {
        return valueOfSupply * vatRate;
    }
    public static double getTotal() {
        return valueOfSupply + getVAT();
    }
}

public class OOP08_1 {
	
	public static void main(String[] args) {
		
        Accounting.valueOfSupply = 10000.0;		// 공급가액 파라미터
        System.out.println("Value of supply : " + Accounting.valueOfSupply);
        System.out.println("VAT : " + Accounting.getVAT());
        System.out.println("Total : " + Accounting.getTotal());
	}
}
