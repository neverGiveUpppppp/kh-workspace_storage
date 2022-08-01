package com.kh.example.chap01_exception.run;
import java.io.IOException;
import com.kh.example.chap01_exception.controller.ExceptionController;

public class Run {
	public static void main(String[] args) throws IOException {

		ExceptionController ec = new ExceptionController();
		try {
			ec.method1();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		System.out.println("정상종료. .printStackTrace() 에러정보 알림");
		System.out.println("정상적으로 종료됨...");
		// run해보면 빨간줄 뜨는데 비정상 종료된 것 같아보이지만 정상종료됨
		// 빨간줄은 .printStackTrace()가 에러정보를 알려주기 때문에 뜬 것
		// .printStackTrace() 안쓰면 에러발생 여부를 모를 수 있음
	}	
}
