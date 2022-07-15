
// 반복문 Loop + 배열 array

public class flow_control07_3 {

	public static void main(String[] args) {

		
		String[] users = new String[3];
		users[0] = "egoing";
		users[1] = "jinhuck";
		users[2] = "youbin";
		
		
		// html <li>user name</li> 몇만개 반복해야된다면?
		// <li>egoing</li>
		// <li>jinhuck</li>
		// <li>youbin</li>
		
//		for (int i = 0; i < 3; i++) { // 배열 길이랑 맞지 않는 반복횟수의 경우의 수에서는 제대로 작동x
//			System.out.println("<li>"+users[i]+"</li>"); // html <li>태그 반복문
		for (int i = 0; i<users.length; i++) { // .length추가로 new String[]배열 길이에 따라 반복가능
			System.out.println(users[i]+",");  // user[인덱스]에 나눠어서 , 찍고 줄바꿈
		}
		
		
	}

}
