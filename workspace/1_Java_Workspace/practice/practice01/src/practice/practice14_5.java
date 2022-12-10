package practice;

public class practice14_5 {
	public static void main(String[] args) { // String[] args가 str타입이라 아래 args는 double
											 // 에러가 나기에 아래서 Double.parseDouble()로 캐스팅
		// run configuration에서 arguments의 값과 이름 변경하여 자주쓰는 항목 추가해두고
		// application마다 사용하면 좋다
		
		double valueOfSupply = Double.parseDouble(args[0]); // 
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply*vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply*expenseRate;
		double income = valueOfSupply - expense;
		
		double dividend1 = income * 0.5;
		double dividend2 = income * 0.3;
		double dividend3 = income * 0.2;

		if (income > 10000.0) {
			dividend1 = income * 0.5;
			dividend2 = income * 0.3;
			dividend3 = income * 0.2;
		} else {
			dividend1 = income * 1.0;
			dividend2 = income * 0;
			dividend3 = income * 0;
		}
		
		System.out.println("Value of supply : " + valueOfSupply);
		System.out.println("VAT : " + vat);
		System.out.println("Total : " + total); // 공급가+부가가치세로 최종 판매가 도출
		System.out.println("Expense : " + expense); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + income); // 공급가-비용=수입
		System.out.println("Dividend 1 : " + dividend1); // 배당1
		System.out.println("Dividend 2 : " + dividend2); // 배당2
		System.out.println("Dividend 3 : " + dividend3); // 배당3

		
		
	} 

}