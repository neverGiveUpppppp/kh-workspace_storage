
public class practice_everyday03 {

	public static void main(String[] args) {

		// 전체 유저 목록
		// 현재유저 아이디 암호 입력
		// 유저 목록에 있는 체크(반복문)
		// 로그인 완료 메세지
		
		String[][] users_all = {
				{"choi","1111"},
				{"kim","2222"},
				{"lee","3333"}
		};
		String[][] user_current = {
				{args[0]},
				{args[1]} // id pw 따로 받아야하나?		
		};
		
		
		boolean userLogin = false;
		for (int i = 0; i < users_all.length; i++) { // 2차원 배열이지만 안에 배열 갯수를 세온다
//			System.out.println(users_all[i][0]);
//			System.out.println(users_all[i][1]);
//			System.out.println(user_current[i]); // 디버깅 중 출력값 무엇?? [Ljava.lang.String;@6504e3b2 ??
												// current의 배열길이는 전체 두개인데 i변수는 all의 길이이므로 인덱스번호가 안맞아서 오류
//			String[] user_current_IdPw = user_current;
//			if (user_current_IdPw[0].equals(users_all[i][0]) && // 계속 로그인실패만 뜨는데 뭐가 문제지?
//				user_current_IdPw[1].equals(users_all[i][1])	
//						) {
//			if (user_current[0].equals(users_all[i][0]) &&  // 계속 로그인실패만 뜨는데 뭐가 문제지?
//				user_current[1].equals(users_all[i][1])		
//					) {
				userLogin = true;
				break;
			};
//		};
			
		
		if (userLogin) {
			System.out.printf("로그인 성공%n환영합니다");
		} else {
			System.out.println("로그인 실패");
		}
		
	}

}