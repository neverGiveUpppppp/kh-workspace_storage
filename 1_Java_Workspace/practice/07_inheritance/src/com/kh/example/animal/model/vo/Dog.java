package com.kh.example.animal.model.vo;

public class Dog {

	private String name;
	private int age;
	private double weight;
	private double height;
	private String hair;
	
	public Dog() {}
	
	public Dog(String name, int age, double weight, double height, String hair) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.hair = hair;
		
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
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	public String getHair() {
		return hair;
	}
	
	// getter
	
	public String inform(String name, int age, double weight, double height, String hair) {
		
		return null;
	}
	
	
}
