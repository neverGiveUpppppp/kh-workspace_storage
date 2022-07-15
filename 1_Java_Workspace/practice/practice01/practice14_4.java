package practice;
import java.io.PrintWriter;

public class practice14_4 {
	public static void main(String[] args) {

		double valueOfSupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply*vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply*expenseRate;
		double income = valueOfSupply - expense;
		double dividend1 = (valueOfSupply - expense) * 0.5;
		double dividend2 = (valueOfSupply - expense) * 0.3;
		double dividend3 = (valueOfSupply - expense) * 0.2;

		
		System.out.println("Value of supply : " + valueOfSupply);
		System.out.println("Value of supply : " + vat);
		System.out.println("Total : " + total); // 공급가+부가가치세로 최종 판매가 도출
		System.out.println("Expense : " + expense); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + income); // 공급가-비용=수입
		System.out.println("Dividend 1 : " + dividend1); // 배당1
		System.out.println("Dividend 2 : " + dividend2); // 배당2
		System.out.println("Dividend 3 : " + dividend3); // 배당3

		
		
	} 

}