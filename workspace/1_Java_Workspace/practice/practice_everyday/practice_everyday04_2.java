
// 상속 & overriding
public class practice_everyday04_2 extends practice_everyday04_1{
	
	// child2
	private int a;
	private int b;
	private int c;
	private int d;
	
	public practice_everyday04_2() {}
	public practice_everyday04_2(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	// getter & setter
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;	
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
	@Override
	public void println() {
		System.out.println("child2");
	}
		

	
	
		
}