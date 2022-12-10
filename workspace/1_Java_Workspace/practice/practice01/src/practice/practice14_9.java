package practice;


public class practice14_9 {
	public static double valueOfSupply; // 변수만 선언(값 선언은 x)
	public static double vatRate;
	public static double expenseRate;
	public static void main(String[] args) {

		valueOfSupply = 10000.0;
		vatRate = 0.1;
		expenseRate = 0.3;
		// 위의 valueOfSupply값이 아래 getVAT() 안에 valueOfSupply값으로 들어가고
		// 아래 getVAT() 안에 valueOfSupply값을 통해서 
		// 맨아래 private static..안에 getVAT() 안에 valueOfSupply으로 들어감
//		double vat = getVAT(); //만들어진 메소드를 호출,실행하는 코드
//		double total = getTotal();
//		double expense = getExpense();
//		double income = getIncome();
//		double dividend1 = getDividend1();
//		double dividend2 = getDividend2();
//		double dividend3 = getDividend3(); 
		// ↑↑↑ 바로 아래 print()메소드와 같은 동작하는 코드라 삭제

		print();
		// 수익이 필요하면 여기에 바로 getIncome(); 써서 불러오면 됨
	}

	private static void print() {
		System.out.println("Value of supply : " + valueOfSupply); // 전역변수선언이라 아래것들이랑 혼자다름
		System.out.println("VAT : " + getVAT());
		System.out.println("Total : " + getTotal()); // 공급가+부가가치세로 최종 판매가 도출
		System.out.println("Expense : " + getExpense()); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + getIncome()); // 공급가-비용=수입
		System.out.println("Dividend 1 : " + getDividend1()); // 배당1
		System.out.println("Dividend 2 : " + getDividend2()); // 배당2
		System.out.println("Dividend 3 : " + getDividend3()); // 배당3
	}

	private static double getDividend1() {
		return getIncome() * 0.5;
	}
	private static double getDividend2() {
		return getIncome() * 0.3;
	}
	private static double getDividend3() {
		return getIncome() * 0.2;
	}

	private static double getIncome() {
		return valueOfSupply - getExpense(); // 
	}

	private static double getExpense() {
		return valueOfSupply * expenseRate; // 전역변수 설정으로 에러해결
	}

	private static double getTotal() {
		return valueOfSupply + getVAT(); // 지역변수를 전역변수 선언도 가능하지만, 
	}								// vat를 getVAT()로 바꾸므로써 똑같은 목적 달성가능

	private static double getVAT() {
		return valueOfSupply * vatRate; // 메소드를 만드는 코드
		// 위의 valueOfSupply * vatRate;에서 값을 받아 연산이 된게 return코드로 인해
		// 맨 위의 첫 getVAT()로 돌아가게 되어 double vat이 1000.0이 되는 개념
		// 1억줄인 코드였다면 이거 하나로 줄이게 된 것!
	} 

}