package com.kh.example.animal.model.vo;

public class Snake {

	private String name;
	private int age;
	private double weight;
	private String pattern;
	
	public Snake() {}
	
	public Snake(String name, int age, double weight, String pattern) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.pattern = pattern;
		
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getPattern() {
		return pattern;
	}
	
	
	// getter

	public String inform(String name, int age, double weight, String pattern) {
		
		return null;
	}
	
	
	
}
