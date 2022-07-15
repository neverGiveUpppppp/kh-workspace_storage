
// 배열 array

public class flow_control07_2 {

	public static void main(String[] args) {

		// 문자열로 이루어진 배열
		// 빈 배열을 만들고 값을 추가해서 넣은 방법
		String[] users = new String[3]; // [3]은 배열의 크기를 지정하는 것
		users[0] = "egoing"; // 갯수를 셀 때는 1부터3까지 세개이나 자릿수를 셀 때는 프로그래밍에서는 0부터
							 // 0의 첫번째 자리는 egoing이라는 의미
		users[1] = "jinhuck";
		users[2] = "youbin";
		
		System.out.println(users[1]);
		System.out.println(users.length);// 세칸짜리 배열이라는 뜻
		System.out.println("===========");
		
		// 배열 생성시에 아예 값을 담아서 생성시키는 방법
//		int[] scores = new int[3]
		int[] scores = {10, 100, 1000};
		System.out.println(scores[1]);
		System.out.println(scores.length);
		
		// index 0 1 2
		// element(원소) "egoing" "jinhuck" "youbin"
		
	}

}
