package MVC.controller;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



public class pController7 {
	
	public void output() {
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("test.txt",true);
			fw.write(97);
			fw.write(65);
			
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}	
	
	
	
	public void output2() {
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("test.txt");
			fw.write(97);
			fw.write(65);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
