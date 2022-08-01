package com.kh.example.chap02_user.run;
import com.kh.example.chap02_user.controller.UserExceptionController;
import com.kh.example.chap02_user.model.exception.MyException;

public class Run {

	public static void main(String[] args) {

		UserExceptionController uec = new UserExceptionController();
		try {
			uec.method();
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		
	}

}
