package practice;

public class practice14 {
	public static void main(String[] args) {

		double valueOfSupply = 10000.0;
		System.out.println("Value of supply : " + valueOfSupply);
		double vatRate = 0.1;
		System.out.println("Value of supply : " + valueOfSupply*vatRate);
		System.out.println("Total : " + ( valueOfSupply + valueOfSupply*vatRate)); // 공급가+부가가치세로 최종 판매가 도출
		double expenseRate = 0.3;
		System.out.println("Expense : " + ( valueOfSupply*expenseRate)); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + ( valueOfSupply - valueOfSupply*expenseRate)); // 공급가-비용=수입
		System.out.println("Dividend 1 : " + ( valueOfSupply - valueOfSupply*0.3) * 0.5); // 배당1
		System.out.println("Dividend 2 : " + ( valueOfSupply - valueOfSupply*0.3) * 0.3); // 배당2
		System.out.println("Dividend 3 : " + ( valueOfSupply - valueOfSupply*0.3) * 0.2); // 배당3

		
		
	} 

}