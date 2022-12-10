package practice03_jungsuk;

import java.util.*;

public class Ch2_14_Scanner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		System.out.println(num);
		System.out.println(num2);
		System.out.println(num3); // 가로로 공백한칸 띄우고 입력가능
		
		// 라인 단위로 값을 입력받기 가능
		String input = sc.nextLine();
		int num4 = Integer.parseInt(input);
		System.out.println(num4);
		
		
	}

}
