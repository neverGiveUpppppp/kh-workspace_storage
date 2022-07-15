package practice03_jungsuk;

public class Ch5_45_array길이초기화 {

	public static void main(String[] args) {
		
		// index범위 : 0~9
		int[] arr = new int[5]; // 길이가 5인 int배열 arr을 생성
		System.out.println("arr.length="+arr.length);
		
		
		for(int i=0; i<arr.length; i++) { // index범위를 벗어나서
			System.out.println("arr["+i+"]="+ arr[i]);
		}
	}

}
