package MVC.model.vo;

public class pModelVo01 {

	private String name;
	private int score;
	
	public pModelVo01() {}
	public pModelVo01(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	// toString
	@Override
	public String toString() {
//			return name(score점); 이 줄이 아래 코드 의미...
		return name+"("+score+"점)";
	}
		
		
	
}
