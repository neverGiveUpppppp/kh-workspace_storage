package practice;

// 14.19 Class


class Accounting{
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
public class practice14_10 {
	
	public static void main(String[] args) {

		Accounting.valueOfSupply = 10000.0;
		Accounting.vatRate = 0.1;
		Accounting.expenseRate = 0.3;
		Accounting.print();
	}


}