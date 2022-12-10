


public class oneday_Pratice_login {
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
			if (inputId1.equals(usersList[0][0]) && inputPW1.equals(usersList[0][1])) { // [0][0]배열에 배열 지정하고 거기서 인덱스 0~1 id랑 pw 끌어온 것
				usersLogin = true;
				System.out.printf("로그인 완료%n어서오세요 %s님", args[0]);
				break;
			} 
		} // for문 밖에서 메세지 출력하도록 해야 메세지가 반복적으로 안뜸
		
		if (usersLogin=false) { // 위에서 boolean이 true상태로 내려온듯함
			System.out.printf("%n환영합니다");
		} else {
			System.out.printf("%n%s님 로그인 실패하였습니다.%n다시 시도해주세요", args[0]);
		}
		
		
		// id,pw 체크의 if문 && 조건이 [0]배열의 Lina유저한테만으로 맞춰져 있어서 수정요망
		
	}
		
}
