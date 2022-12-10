
public class ch2_12 {

	public static void main(String[] args) {


		
		System.out.println(10.0/3); //
		
		
		System.out.printf("%d%n", 15); // 10진수(decimal number)
		System.out.printf("%o%n", 15); // 8진수(octal)
		System.out.printf("%x%n", 15); // 16진수(hexadecimal)

		System.out.println();
		
//		System.out.printf("%#d%n", 15); // 10진수는 접두사 없어서 #붙이면 에러
		System.out.printf("%#o%n", 15); // 접두사 붙이고 싶을 땐 지시자 앞 #추가
		System.out.printf("%#x%n", 15); // 접두사 붙이고 싶을 땐 지시자 앞 #추가
		System.out.printf("%s", Integer.toBinaryString(15)); // 10진수를 2진수로 출력하는 지시자는 존재x
										// 좌측 메소드 사용해야만함
		System.out.println();
		System.out.println();
		
		float f = 123.456789f; // 결과값이 7까지 정밀(123.4567/7자리). 결과값이 운좋게 8자리까지 맞음
		double ff = 123.456789; // double은 정밀도 15자리까지
		System.out.printf("%f%n", f);
		System.out.printf("%f%n", ff);
		System.out.printf("%e%n", ff); // 지수형태 지시자 %e
		System.out.printf("%g%n", ff); // 간략화 지시자 %g // 막자리6인데 반올림되서 7
		
		
	}

}
