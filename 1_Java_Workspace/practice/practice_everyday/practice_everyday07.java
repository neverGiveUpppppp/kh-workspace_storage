import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class practice_everyday07 {
	public static void main(String[] args) throws IOException {
		
		// 문자 기반 스트림
		// FileReader
		// FileWriter
		
		FileWriter fw = new FileWriter("D:\\file\\file2\\first.txt");
		fw.write("initiate\n");
		fw.append("2\n");
		char[] cArray = {'c','h','e','e','r'};
		char[] sArray = {'u','p'};
		fw.write(cArray);
		fw.write(sArray);
		fw.close();
		
		FileReader fr = new FileReader("D:\\file\\file2\\first.txt");
		int i;
		while((i=fr.read()) != -1) {
			System.out.print((char)i);
		}
		fr.close();
		
	}	
}