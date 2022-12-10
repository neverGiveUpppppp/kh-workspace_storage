package action.model.vo;

public class Person {

	
	private String name;
	private char gender;
	private int nai;	// nai == age
	
	public Person() {}

	public Person(String name, char gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.nai = age;
	}
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + nai + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getNai() {
		return nai;
	}

	public void setNai(int age) {
		this.nai = age;
	}
	
	
	
	
}
