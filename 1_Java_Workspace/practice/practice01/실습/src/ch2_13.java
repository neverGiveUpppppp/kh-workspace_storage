
public class ch2_13 {

	public static void main(String[] args) {

		
		System.out.printf("[%5d]%n", 1234567); // 지시앞 숫자 : 전체자릿수
		System.out.printf("[%-5d]%n", 10); // - : 왼쪽정렬
		System.out.printf("[%05d]%n", 10); // 공백 공간 대신 채우는 0
		System.out.printf("<%05d>%n", 10); // 간략화 지시자 %g // 막자리6인데 반올림되서 7
		
		double d = 1.23456789;			 // 총 10자리
		System.out.printf("%14.10f", d); // 앞 공백두칸과 뒤에 0 2개해서 총14자리
		System.out.println();
		System.out.printf("%14.6f", d); // 보이는 것만 끝자리8이고 실제저장된 값은 제대로 789까지 다 저장되어있음
		System.out.println();
		System.out.printf("%.6f", d); // 소수점 6자리
		System.out.println();
		System.out.println();
		
		System.out.printf("%14.10f%n", d); // 앞 공백두칸과 뒤에 0 2개해서 총14자리
		System.out.printf("%14.6f%n", d); // 보이는 것만 끝자리8이고 실제저장된 값은 제대로 789까지 다 저장되어있음
		System.out.printf("%.6f%n", d); // 소수점 6자리
		
		
	}

}
