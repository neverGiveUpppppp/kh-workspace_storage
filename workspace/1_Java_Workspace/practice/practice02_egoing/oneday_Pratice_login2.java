


public class oneday_Pratice_login2 {
	public static void main(String[] args) {
		
		// 로그인 확인 절차 코드
		// id & pw 체킹
		
		String[][] usersList = {   // 전체 유저목록과 id,pw
				{"Lina","1111"},   // 2차원 배열로 id,pw관리
				{"Robert","2222"},
				{"John","3333"}
				};
		String inputId1 = args[0];  // 로그인할 유저의 id입력값
		String inputPW1 = args[1];  // 로그인할 유저의 pw입력값
		
		// 유저목록이랑 하나씩 돌려가며 매칭 & 확인하는 절차 필요
		boolean usersLogin = false; // 로그인 완료 확인 여부. 완료되면 id,pw대조용 for문 정지시킬 용도
		for (int i=0; i<usersList.length; i++) {
			String[] currentUser = usersList[i];    // 2차원 배열에서 id 하나에 대한 정보만 먼저 불러오게함. 이거 한 줄 ex){"Lina","1111"}
			
			if (inputId1.equals(currentUser[0]) &&  // usersList[i]로 {"Lina","1111"} 불러오고 여기서 인덱스넘버에 따라 id,pw 대조체킹
				inputPW1.equals(currentUser[1])) {  // [0]은 id [1]은 pw
				usersLogin = true;
				System.out.printf("로그인 완료%n어서오세요 %s님", args[0]);
				break;
			} 
		} // for문 밖에서 메세지 출력하도록 해야 메세지가 반복적으로 안뜸
		
		if (usersLogin) { // 위에서 boolean이 true상태로 내려온듯함
			System.out.printf("%n환영합니다");
		} else {
			System.out.printf("%s님 로그인 실패하였습니다.%n다시 시도해주세요", args[0]);
		}
		
		
	}
		
}
