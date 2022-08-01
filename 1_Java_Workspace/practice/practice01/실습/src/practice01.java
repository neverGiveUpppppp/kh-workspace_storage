
public class practice01 {
	public static void main(String[] args) {
		
		int x = 1, y = 2, z = 3;
		
		z=x; // z변수에 임시로 x값을 저장
		x=y; // x변수에 y값을 저장
		y=z; // 원래 x값이 들어있는 z변수의 값을 y변수에 넣어서 x값을 넣는다
		
		// 문자열 + 숫자의 결과는?
		char str10 = 't';
		int num10 = -1;
		
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println();
		System.out.println(str10+num10);
		
		
	}

}
