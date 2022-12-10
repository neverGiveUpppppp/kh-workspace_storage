import java.io.FileWriter;
import java.io.IOException;

public class OOP02 {

	public static void main(String[] args) throws IOException {
		// class : System, Math, FileWriter
		// Instance : f1, f2 
		System.out.println(Math.PI);
		System.out.println(Math.floor(1.8));
		System.out.println(Math.ceil(1.8));
		
		FileWriter f1 = new FileWriter("data.txt"); // FileWriter의 복사본
		f1.write("Hello");
		f1.write("Java");

				
		FileWriter f2 = new FileWriter("data2.txt"); // FileWriter의 또 다른 복사본
		f2.write("Hello");
		f2.write("Java2");
		f2.close();
		
		f1.write("!!!");  				// 긴 맥락의 작업
		f1.close();
	}

}
