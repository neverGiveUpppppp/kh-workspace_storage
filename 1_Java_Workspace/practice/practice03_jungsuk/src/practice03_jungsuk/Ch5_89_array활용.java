package practice03_jungsuk;

public class Ch5_89_array활용 {
	public static void main(String[] args) {
		
		// 총합과 평균
		int sum = 0;
		float average = 0f;
		
		int[] score = {100, 88 , 100, 100, 90};
		
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		average = sum / (float)score.length; // 평균 연산시, 실수 형변환 잊지말것
		// casting안하면 정수로 결과도출 및 데이터 손실. (float)변환시 95.6 int시 95
		
		System.out.println("총점 : " +sum);
		System.out.println("평균 : " +average);
		
		
		// 최대값 최소값
		
		int[] score2 = {79,88,91,33,100,55,95}; 
		
		int max = score2[0]; // 배열의 첫번째 값으로 최대값 초기화
		int min = score2[0]; // 배열의 첫번째 값으로 최소값 초기화
		
		for(int i=1; i<score2.length; i++) {
			if(score2[i] > max) {
				max = score2[i];
			}else if(score2[i] < min) {
				min = score2[i];
			}
		} 
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}	
}
