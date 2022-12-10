package practice;

// 14.11 Instance

class Accountingg{
	public double valueOfSupply; // 변수만 선언(값 선언은 x)
	public double vatRate;
	public double expenseRate;
	

	public void print() {
		System.out.println("Value of supply : " + valueOfSupply); // 전역변수선언이라 아래것들이랑 혼자다름
		System.out.println("VAT : " + getVAT());
		System.out.println("Total : " + getTotal()); // 공급가+부가가치세로 최종 판매가 도출
		System.out.println("Expense : " + getExpense()); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + getIncome()); // 공급가-비용=수입
		System.out.println("Dividend 1 : " + getDividend1()); // 배당1
		System.out.println("Dividend 2 : " + getDividend2()); // 배당2
		System.out.println("Dividend 3 : " + getDividend3()); // 배당3
	}

	public double getDividend1() {
		return getIncome() * 0.5;
	}
	public double getDividend2() {
		return getIncome() * 0.3;
	}
	public double getDividend3() {
		return getIncome() * 0.2;
	}

	public double getIncome() {
		return valueOfSupply - getExpense(); // 
	}

	public double getExpense() {
		return valueOfSupply * expenseRate; // 전역변수 설정으로 에러해결
	}

	public double getTotal() {
		return valueOfSupply + getVAT(); // 지역변수를 전역변수 선언도 가능하지만, 
	}								// vat를 getVAT()로 바꾸므로써 똑같은 목적 달성가능

	public double getVAT() {
		return valueOfSupply * vatRate; // 메소드를 만드는 코드
	} 
}



class Accountingg1{
	public static double valueOfSupply; // 변수만 선언(값 선언은 x)
	public static double vatRate;
	public static double expenseRate;
	

	public static void print() {
		System.out.println("Value of supply : " + valueOfSupply); // 전역변수선언이라 아래것들이랑 혼자다름
		System.out.println("VAT : " + getVAT());
		System.out.println("Total : " + getTotal()); // 공급가+부가가치세로 최종 판매가 도출
		System.out.println("Expense : " + getExpense()); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + getIncome()); // 공급가-비용=수입
		System.out.println("Dividend 1 : " + getDividend1()); // 배당1
		System.out.println("Dividend 2 : " + getDividend2()); // 배당2
		System.out.println("Dividend 3 : " + getDividend3()); // 배당3
	}

	public static double getDividend1() {
		return getIncome() * 0.5;
	}
	public static double getDividend2() {
		return getIncome() * 0.3;
	}
	public static double getDividend3() {
		return getIncome() * 0.2;
	}

	public static double getIncome() {
		return valueOfSupply - getExpense(); // 
	}

	public static double getExpense() {
		return valueOfSupply * expenseRate; // 전역변수 설정으로 에러해결
	}

	public static double getTotal() {
		return valueOfSupply + getVAT(); // 지역변수를 전역변수 선언도 가능하지만, 
	}								// vat를 getVAT()로 바꾸므로써 똑같은 목적 달성가능

	public static double getVAT() {
		return valueOfSupply * vatRate; // 메소드를 만드는 코드
	} 
}


class Accountingg2{
	public static double valueOfSupply; // 변수만 선언(값 선언은 x)
	public static double vatRate;
	public static double expenseRate;
	

	public static void print() {
		System.out.println("Value of supply : " + valueOfSupply); // 전역변수선언이라 아래것들이랑 혼자다름
		System.out.println("VAT : " + getVAT());
		System.out.println("Total : " + getTotal()); // 공급가+부가가치세로 최종 판매가 도출
		System.out.println("Expense : " + getExpense()); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + getIncome()); // 공급가-비용=수입
		System.out.println("Dividend 1 : " + getDividend1()); // 배당1
		System.out.println("Dividend 2 : " + getDividend2()); // 배당2
		System.out.println("Dividend 3 : " + getDividend3()); // 배당3
	}

	public static double getDividend1() {
		return getIncome() * 0.5;
	}
	public static double getDividend2() {
		return getIncome() * 0.3;
	}
	public static double getDividend3() {
		return getIncome() * 0.2;
	}

	public static double getIncome() {
		return valueOfSupply - getExpense(); // 
	}

	public static double getExpense() {
		return valueOfSupply * expenseRate; // 전역변수 설정으로 에러해결
	}

	public static double getTotal() {
		return valueOfSupply + getVAT(); // 지역변수를 전역변수 선언도 가능하지만, 
	}								// vat를 getVAT()로 바꾸므로써 똑같은 목적 달성가능

	public static double getVAT() {
		return valueOfSupply * vatRate; // 메소드를 만드는 코드
	} 
}

public class practice14_11 {
	
	public static void main(String[] args) {

//		Accountingg.valueOfSupply = 10000.0;
//		Accountingg.vatRate = 0.1;
//		Accountingg.expenseRate = 0.3;
//		Accountingg.print();
		
		// 맨위 클래스를 새로 만들어서 하나씩 연결 시킨 것 
		// but, 새상품이 들어올 때마다 클래스를 새로 만들고 매번 값 세팅해줘야하는 번거로움이...
		// 그래서 Instance를 사용 : new 클래스명();
//		Accountingg1.valueOfSupply = 10000.0;
//		Accountingg1.vatRate = 0.1;
//		Accountingg1.expenseRate = 0.3;
//		Accountingg1.print();
//
//		Accountingg2.valueOfSupply = 20000.0;
//		Accountingg2.vatRate = 0.5;
//		Accountingg2.expenseRate = 0.2;
//		Accountingg2.print();
		
		
		// Instance : 클래스 이름 앞에 new를 붙여서 만들어진 무언가가 인스턴스
		// 인스턴스를 썼으면 연결된 클래스에서 public 앞에 static가 쓰이면 안된다. 삭제해야함
		Accountingg a1 = new Accountingg(); // a1변수 앞 Accountingg의 의미는 
		       // a1변수의 값으로는 Accountingg 클래스의 복제본만 들어 올 수 있다는 의미
		a1.valueOfSupply = 20000.0;
		a1.vatRate = 0.5;
		a1.expenseRate = 0.2;
		a1.print();
		
		Accountingg a2 = new Accountingg(); 
		a2.valueOfSupply = 20000.0;
		a2.vatRate = 0.5;
		a2.expenseRate = 0.2;
		a2.print();
		
		a1.print(); // a1.print();를 또 써도 잘 작동한다는 것을 확인하기 위한 중복코드
		
	}


}