
// 반복문 Loop + 배열 array

public class flow_control08_2 {

	public static void main(String[] args) {

//		String[] users = {"egoing","jinhuck","youbin"}; // {"egoing,1111","jinhuck,2222"}식으로 할 수 있지만 불편
		String[][] users = { // 배열 안에 배열(2차원 array)
		// 첫째줄 String[] users의 원소의 데이터타입이 str이었는데
		// 둘째줄 String[][] users는 원소가 배열이고 각각의 배열의 원소의 값은 str인 데이터임		
				{"egoing","1111"}, 
				{"jinhuck","2222"}, // 각각의 원소가 배열이고, 그 배열의 값이 str인 데이터
				{"youbin","3333"}
		};		
				
		String inputId = args[0];   // id 인자
		String inputPass = args[1]; // pw 인자
		
		boolean isLogined = false;               // 로그인 여부 확인. 로그인 아직안됬기에  false
		for(int i=0; i<users.length; i++) {      // 전체 유저수보다 작게 반복문실행해서 유저목록중에 로그인할려는 유저 찾기
			String[] current = users[i];         // currentId : 현재유저
			if (
					current[0].equals(inputId) &&// and 논리연산자 : 둘 다 만족 // current[0]:2차원배열의 id부분
					current[1].equals(inputPass) // ID랑 PW 둘다 같다면 로그인시키는 코드 // current[1]:2차원배열의 pw부분
			) {   // current[0]이 둘째str배열의 "egoing"고 같다. inputId값과 각각의 원소의 첫째자리인 ID값(ex:egoing)을 비교하는것
				isLogined = true;                // 위의 불리안과 연결되어 로그인됬으니(true) 종료시킴. 이런걸 플래그(flag)변수라고함
				break;                           // 일치하는 사람이 있으면 반복문 종료
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


