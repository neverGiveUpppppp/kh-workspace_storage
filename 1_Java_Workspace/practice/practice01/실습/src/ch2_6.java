
public class ch2_6 {
	public static void main(String[] args) {

		final int score = 100;
		boolean power = true;
		
		byte b = 127; // byte 범위 : -128 ~ 127
//		byte b = 128; // byte 범위 넘어서 에러
		
		int oct = 010;  // 8진수, 10진수로 8
		int hex = 0x10; // 16진수, 10진수로 16
		
//		long l = 1000_000_000; // _는 빼도되지만 가시성을 위해 삽입
//		long l = 10_000_000_000; // int범위초과로 에러
		long l = 10_000_000_000L; // 접두사L로 에러수정
		
//		float f = 3.14;  // 접미사f붙여야 에러 해결가능
//		double d = 3.14;
		double d = 3.14f; // 더블이 플로트보다 넓어서 에러발생x
		
		System.out.println(10.);
		System.out.println(.10);
		System.out.println(10f);
		System.out.println(1e3);
		System.out.println();
		System.out.println(score);
		System.out.println(oct);
		System.out.println(hex);
	}

}
