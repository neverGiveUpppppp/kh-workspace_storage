package com.kh.example.chap01_byte.run;
import com.kh.example.chap01_byte.model.dao.ByteDAO;
public class Run {
	public static void main(String[] args) {
		
		ByteDAO bd = new ByteDAO();
		bd.fileOpen(); // error:없는 파일 호출이라 에러
		bd.fileSave();
		
//		bd.fileOpen2();
//		bd.fileSave2();
	}
}
 