package com.kh.run;
import com.kh.variable.A_Variable;
import com.kh.variable.B_Constant;
import com.kh.variable.C_Cast;
import com.kh.variable.D_PrintMethod;
import com.kh.variable.E_KeyboardInput;

public class Run {
	public static void main(String[] args) {
		
		// 1)클래스 풀네임 적는 방법
//		com.kh.variable.A_Variable av = new com.kh.variable.A_Variable();
		
		// 2)import 
		// import : 외부의 경로 지정
		// import 생성 단축키 : ctrl+shift+o
		// import com.kh.variable.A_Variable;
		
		A_Variable av = new A_Variable();	
		av.declareVariable();
		av.initVariable();
		
//		System.out.println(av.initVariable(bNum)); error
//		A_Variable.initVariable("s");				error
//		System.out.println(A_Variable.initVariable()); error
		
		
//		B_Constant.finalConstant();
//		System.out.println();
//		B_Constant bc = new B_Constant();
//		bc.finalConstant();
//		
		C_Cast cc = new C_Cast();
		cc.cast1();
		
//		D_PrintMethod dp = new D_PrintMethod();
//		dp.printlnMethod();
//		dp.printMethod();
//		dp.printfMethod();
//		dp.stringExample();
//		
//		E_KeyboardInput ek = new E_KeyboardInput();
//		ek.inputScanner1();
//		ek.inputScanner2();	
	}
}
