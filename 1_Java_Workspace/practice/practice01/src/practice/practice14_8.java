package practice;

// 반복문 Loop
public class practice14_8 {
	public static void main(String[] args) { // 왼쪽 String[] args가 문자열로 이루어진 배열이란 의미

		double valueOfSupply = 10000.0;
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply*vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply*expenseRate;
		double income = valueOfSupply - expense;
		

		System.out.println("Value of supply : " + valueOfSupply);
		System.out.println("VAT: " + vat);
		System.out.println("Total : " + total); // 공급가+부가가치세로 최종 판매가 도출
		System.out.println("Expense : " + expense); // 얼마를 벌었는지 알려면? 쓴 비용을 빼야함(ex:재료값,장비값,인건비등)
		System.out.println("income : " + income); // 공급가-비용=수입
		
		double[] dividendRates = new double[3]; // double[] : 더블형으로 이루어진 배열이라 선언
		dividendRates[0] = 0.5;		    // new double[3] : 더블형데이터 세개 담을 수 있는 공간 생성
		dividendRates[1] = 0.3;
		dividendRates[2] = 0.2;
		
		double dividend1 = income * dividendRates[0];
		double dividend2 = income * dividendRates[1];
		double dividend3 = income * dividendRates[2];
		
		// println()을 반복문으로 해결
		int i = 0; // 변수 초기화 및 반복문수 기록
		while(i < dividendRates.length) { // dividend의 수(투자자수)만큼 반복해야함
			System.out.println("Dividend 1 : " + (income * dividendRates[i])); // dividend1을 dividendRates[i]로 변경
			i = i + 1;
		// arguments에 입력값 입력	
		}

		
		
	} 

}