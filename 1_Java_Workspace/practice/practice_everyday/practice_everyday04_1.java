


public class practice_everyday04_1 extends practice_everyday04_0 {
		
	// child1
//	private int a;
//	private int b;
	private int c;
	
	public practice_everyday04_1() {}
	public practice_everyday04_1(int a, int b, int c) {
//		this.a = a;
//		this.b = b;
		this.c = c;
	}
	
	// getter & setter
	// setter : 데이터를 변수에 저장하는 메소드
	// getter : 저장된 데이터를 불러오는 메소드
//		public int getA() {
//			return a;
//		}
//		public void setA(int a) {
//			this.a = a;	
//		}
//		public int getB() {
//			return b;
//		}
//		public void setB(int b) {
//			this.b = b;
//		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		
	@Override	
	public void println() {
		System.out.println("child1");
	}
	
}