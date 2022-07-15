import java.util.Scanner;

public class practice_everyday11 {
		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			}else {
				System.out.println("no");
			}
		}
		System.out.println("종료 ");	
		// 삼항연산자
		
//		int num = 1;
//		String plus2 = "양수다";
//		String zero2 = "0";
//		String notPlus2 = "양수가 아니다";
//		System.out.println(num > 0 ? "양수다" : "음수다");
//			
//		int aa=1;
//		int bb=2;
//		System.out.println(aa>bb ? "1":"2");
	
			
			
//		// for문 초기화생략
//		int start = 1;
//		int end = 2;
//		int i = 1;
//		for(; start>=end; i+=2) {
//		}
//		
//		
//		// 1~10.99999 두가지 방법	
//		System.out.println(Math.random()*10+1);	
//		System.out.println(Math.ceil(Math.random()*10+1));	
					
//			Scanner sc = new Scanner(System.in);
//			System.out.println("입력 : ");
//			String str = sc.nextLine();
//			
////			for(int i = 0; i<str.length();i++) {
////				System.out.println(i+" : "+str.charAt(i));
////			}
			
//			int i = 0;
//			while(i<str.length()) {
//				System.out.println(i+" : "+str.charAt(i));
//				i++;
//			}
			
			// 2단부터 9단까지 출력
			// for문
			
//			for(int i=2; i<=9;i++) {
//				System.out.printf("==%d단==%n",i);
//				for(int j=1;j<=9;j++) {
//					System.out.printf("%d x %d = %d%n",i,j,i*j);
//					
//				}
//			
//			}
			
//			// while문
//			int i = 2;
//			while(i<=9) {
//				System.out.printf("==%d단==\n",i);
//				int j = 1;
//				while(j<=9) {
//					System.out.printf("%d x %d = %d%n",i,j,i*j);
//					j++;
//				}
//				i++;
//			}
		
			
			// array
//			int[] arr = new int[3];
//			arr[0] = 2;
//			arr[1] = 3;
//			arr[2] = 4;
//			System.out.println(arr);
//			for(int i=0; i<arr.length;i++) {
//				System.out.println(arr[i]);
//			}
			
			// array 초기화
			// 1.인덱스 이용
			// 2.중괄호 {}
			// 3.for문
			
			// 2.중괄호
//			int[] ini = {1,2,3,4};
//			String[] ini_s = {"ㅁ","ㄴ","ㄹ"};
//			for(int i=0;i<ini_s.length;i++) {
//				System.out.println(ini_s[i]);
//			}
			
			// 3.for문
//			int[] forr = new int[5];
//			for (int i=0; i<forr.length;i++) {
//				forr[i] = (i+1)*5;
//				System.out.print(forr[i]+" ");
//			}
//				
			// 배열 삭제 
//			int[] arr = new int[5];
//			arr = null;
			
			// 1.얇은카피
			// 2.깊은카피
			
			// 1.얇은카피 : 주소값 복사
//			int[] sa = {5,4,3,2,1};
//			int[] sb = sa;
//			System.out.println(sa); // [I@6d06d69c
//			System.out.println(sb); // [I@6d06d69c
			
			// 2.깊은카피 : 값까지 복사
			// 1)for문
			// 2)System.arraycopy()
			// 3)Arrays.copyof()
			
			// 2.깊은카피 : 값까지 복사
			// 1)for문
			int[] arr = new int[3];
			int[] sys_arraycopy = {1,2,3};
			for(int i=0; i<sys_arraycopy.length;i++) {
				arr[i]=sys_arraycopy[i];
			}
			for(int i=0; i<sys_arraycopy.length;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();			  // 다른주소값
			System.out.println(arr); 		  // [I@6d06d69c
			System.out.println(sys_arraycopy);// [I@7852e922

			
			
			
			
			
			
		}
	
	
}