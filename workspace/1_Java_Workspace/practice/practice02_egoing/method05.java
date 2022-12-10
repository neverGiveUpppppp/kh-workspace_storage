import java.io.FileWriter;
import java.io.IOException;

public class method05 {
	
	
	public static String a() { // 리턴값 str타입
		// ...
		return "a";
	}
	public static int one() {  // 리턴값 int타입
		return 1;
	}
	
	
	
	public static String twoTimes(String text, String delimiter) {
		String out = "";
		out = out + delimiter + "\n";
		out = out + text + "\n";
		out = out + text + "\n";
		return out;
	}

	public static void main(String[] args) throws IOException { 
		// void : 리턴값이 없다
		// throws IOException : 오류가 발생했을 때, 오류를 이 클래스를 사용하는 쪽으로  던져버리는 기능
		
		// 자바에서 메소드 아웃풋의 핵심
		// 1)메소드 뒤에 있는 리턴값이 메소드의 실행 결과가 된다
		// 2)리턴값은 메소드를 종료시키는 역할도 한다
		// 3)메소드는 그 메소드의 리턴값이 어떤 데이터타입인지 지정해주어야한다
		
		System.out.println(a());
		System.out.println(one());
		
		printTwoTimes("a","-");		 // 아래와 같은 코드지만, 화면 출력기능을 빼고 
		System.out.println(twoTimes("a","-")); // 리턴값을 갖고있어 여러곳에서 사용가능
		
		writeFileTwoTimes("a","*");  // 아래와 같은 코드
		FileWriter fw = new FileWriter("out.txt");	
		fw.write(twoTimes("a","*"));
		fw.close();
//		Email.send("egoing@gmail.com", "two times a", twoTimes("a", "&")); // 예를들면 이렇게 나중에 코드 처리가능
		
		
	}
	
	public static void printTwoTimes(String text, String delimiter) {
		System.out.println(delimiter); // 
		System.out.println(text);	   // 
		System.out.println(text);
	}
	public static void writeFileTwoTimes(String text, String delimiter) throws IOException {
		FileWriter fw = new FileWriter("output.txt");
		fw.write(delimiter+"\n");
		fw.write(text+"\n");
		fw.write(text+"\n");
		fw.close();
	}
	

}
