
// 반복문 Loop + 배열 array

public class flow_control08_1 {

	public static void main(String[] args) {

		
		String[] users = {"egoing","jinhuck","youbin"}; // {"egoing,1111","jinhuck,2222"}식으로 할 수 있지만 불편
		String inputId = args[0]; // users목록 중에 inputId가 들어온게 있는 체크해야함
		
		boolean isLogined = false;              // 로그인 여부 확인. 로그인 아직안됬기에  false
		for(int i=0; i<users.length; i++) {     // 전체 유저수보다 작게 반복문실행해서 유저목록중에 로그인할려는 유저 찾기
			String currentId = users[i];        // currentId : 현재유저
			if (currentId.equals(inputId)) {    // currentId와 inputId가 같으면 true되서 if문 발동
				isLogined = true;               // 위의 불리안과 연결되어 로그인됬으니(true) 종료시킴. 이런걸 플래그(flag)변수라고함
				break;                          // 일치하는 사람이 있으면 반복문 종료
			}
		}
		
		System.out.println("Hi,");
		if(isLogined) {
			System.out.println("Master!!");
		} else {
			System.out.println("Who are you?");
			}
	}
}



