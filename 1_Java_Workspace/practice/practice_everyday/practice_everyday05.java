import java.io.FileWriter;
import java.io.IOException;

class scaner {
	public static String scaner1() {
		return "go get\'em\n";
	}
	public static int scaner2() {
		System.out.println();
		return 101;				// 출력결과값 : d
	}
	public static double scaner3() {
		return 200.000;			// 출력결과값 : 소수점 아래 첫째자리까지만 출력됨
	}
}
public class practice_everyday05 {
	
	public static void main(String[] args) throws IOException {
		
		// 클래스 출력
		FileWriter fw = new FileWriter("1234.txt");
		fw.write(scaner.scaner1());	// (경로지정)클래스명.클래스의 메소드명
		fw.write(scaner.scaner2());	
		fw.write(Double.toString(scaner.scaner3())); // double을 str로 캐스팅
		fw.close();
		System.out.println("파일 출력 성공");
		
	}
}