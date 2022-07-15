import java.io.FileWriter;
import java.io.IOException;

public class practice_everyday02 {
	public static String cccc() {
		return "go get them\n";
	}
	public static void main(String[] args) throws IOException {
		
		String aaaa = "1";
		String aaaa1 = new String();
		
		FileWriter io_Try = new FileWriter("1.txt");
		io_Try.write("바보\n");  // 일반 str 문구 출력
		io_Try.write(aaaa);		// 변수 넣고 변수값 출력
		io_Try.write("\n");		// 줄바꿈
		io_Try.write(cccc());	// 메소드 넣고 리턴값 출력
		if (io_Try.equals(io_Try)) { // .equals()는 call by value(내용)
			io_Try.write("twice");   // primive type에는 사용불가
		}
		io_Try.close();
		
	}
}