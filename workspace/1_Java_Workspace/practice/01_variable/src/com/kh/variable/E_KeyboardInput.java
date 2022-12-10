package com.kh.variable;
import java.util.Scanner;


public class E_KeyboardInput {
	
	public void inputScanner1() {
		Scanner sc = new Scanner(System.in);
//		sc.nextLine();
		
//		System.out.print("이름을 입력하세요 : "); // 유저를 위한 안내문구 필히
//		String name = sc.nextLine();
//		System.out.println(name);
//		System.out.println(sc.nextLine());
		
		
		System.out.print("이름을 입력하세요 :");
		String name = sc.nextLine();
//		sc.nextLine();		
//		System.out.println(sc.nextLine());
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
//		System.out.println(age);
		
		System.out.print("키를 입력하세요(소수첫째자리까지) : ");
		float height = sc.nextFloat();
//		double heightD = sc.nextDouble();	// primitive 데이터타입은 첫글자 대문자x. 클래스가 되어버림
//		System.out.println(height);
		
		// 예문
		// 이름님은 나이세이며, 키는 키cm입니다.
		System.out.println(name+"님은 "+age+"세이며, 키는 "+height+"cm입니다.");
		System.out.printf("%s님은 %d세이며, 키는 %fcm입니다.",name,age,height);
		
	}
	public void inputScanner2() {
		// 예문
		// 이름, 나이, 주소
		// 이름(나이)님이 사시는 곳은 주소입니다.
		Scanner sc2 = new Scanner(System.in);
		
		
		
		
//		System.out.print("이름를 입력하세요 : ");
//		String name2 = sc2.nextLine();
//		System.out.print("나이를 입력하세요 : ");
//		int age2 = sc2.nextInt();
//		System.out.print("주소를 입력하세요 : ");
//		String address2 = sc2.nextLine();	// 결과값에서 address가 입력이 안됨
		

//		System.out.println(name2+"("+age2+")"+"님이 사시는 곳은 "+address2+"입니다.");
//		System.out.printf("%s(%d)님이 사시는 곳은 %s입니다.", name2, age2, address2);
//		System.out.printf("%s(%d)님이 사시는 곳은 %s입니다.", name2, age2, address2/*+2+address3*/                                                                );
		// 결과값에서 address가 입력이 안됨
		// why?
		// 둘째줄 nextInt()에서 버퍼에 남은 \n이 셋째줄 nexLine()에 들어가게 되는데 
		// 넥스트라인은 줄바꿈을 떼고 변수로 데이터값을 넘기게 되는 과정에서 \n중에 n만 떼고 
		// \이 커서 값 같은 것만 넘어가게 되면서 세번째줄 입력이 안나오는 것처럼 보이게 되는 것 
		
		// 해결방법 3가지
		// 1) 주소를 next()로 받아오기
		// 2) nextLine()을 추가하기
		// 3) 엔터가 남지 않도록 나이를 받을 때, nextLine() 받은 후 parsing하기
		
		// 1)코드
		// next()는 띄어쓰기를 구분자로 인지하여 각각 저장
//				System.out.print("이름를 입력하세요 : ");
//				String name2 = sc2.nextLine();
//				System.out.print("나이를 입력하세요 : ");
//				int age2 = sc2.nextInt();
//				System.out.print("주소를 입력하세요 : ");
//				String address2 = sc2.next();	// 마지막줄 nextLine()이 아닌 next()
//				System.out.printf("%s(%d)님이 사시는 곳은 %s입니다.", name2, age2, address2);		
		
		// 2)코드
		// 버퍼를 비우기 위한 용도로 nextLine() 사용
		// 띄어쓰기 포함해서 문장도 입력가능
//				System.out.print("이름를 입력하세요 : ");
//				String name2 = sc2.nextLine();
//				System.out.print("나이를 입력하세요 : ");
//				int age2 = sc2.nextInt();
//				sc2.nextLine(); // 중간에 넥스트라인 추가로 \n의 찌꺼끼를 패스시킴 
//				System.out.print("주소를 입력하세요 : ");
//				String address2 = sc2.nextLine();
//				System.out.printf("%s(%d)님이 사시는 곳은 %s입니다.", name2, age2, address2);
		// 3)코드
		// parsing : 문자열을 기본 자본형으로 바꾸는 것
		// 강사님 추천 방법 
		// 이유 래퍼 사용 익숙해지기, 편함 , 띄어쓰기 포함해서 문장도 입력가능
//				System.out.print("이름를 입력하세요 : ");
//				String name2 = sc2.nextLine();
//				System.out.print("나이를 입력하세요 : ");
//				String strAge = sc2.nextLine();
//				int age2 = Integer.parseInt(strAge); // (strAge)를 parsing 하고 나온 것을 변수에 넣어야함
//				System.out.print("주소를 입력하세요 : ");
//				String address2 = sc2.nextLine();
//				System.out.printf("%s(%d)님이 사시는 곳은 %s입니다.", name2, age2, address2);		
				
		// 문자열을 '문자'로 바꾸는 방법
		// parsing 통해서 하는게 아님xx
		// .charAt() : 문자열에서 i번째 인덱스번호로 '문자'를 뽑아오는 메소드
		System.out.print("이름를 입력하세요 : ");
		String name2 = sc2.nextLine();
		System.out.print("나이를 입력하세요 : ");
		String strAge = sc2.nextLine();
		int age2 = Integer.parseInt(strAge);// 3번해결방법 Integer.parseInt() 
		System.out.print("주소를 입력하세요 : ");
		String address2 = sc2.nextLine();
		System.out.print("성별을 입력하세요(M/F) : ");
		String strGender = sc2.nextLine();  // strGender에 str문자열인 "F"가 들어감
		char gender = strGender.charAt(0);	// 인덱스0번이 .charAt()의 인자로 들어감
		System.out.printf("%s(%d, %c)님이 사시는 곳은 %s입니다.", name2, age2, gender, address2);
	}
}
