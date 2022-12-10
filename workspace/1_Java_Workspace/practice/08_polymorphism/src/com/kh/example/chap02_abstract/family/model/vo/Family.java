package com.kh.example.chap02_abstract.family.model.vo;

public abstract class Family {

	private String name;
	private double weight;
	private int health;
	
	public Family() {}
	public Family(String name, double weight, int health) {
		this.name = name;
		this.weight = weight;
		this.health = health;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public String toString() {
		return "name = :"+name+", weight= "+weight+", health="+health;
	}
	
	// 가족형태 띄우고 있다고 해서 먹고 자는가? no
	// 생물이 먹고 잔다 -> 생물이라는 규약을 넣어서 거기에 eat(),sleep()을 넣을 것
//	public abstract void eat();
//	public abstract void sleep();
	
}
