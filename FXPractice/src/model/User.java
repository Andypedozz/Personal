package model;

public class User{
	private String name;
	private String gender;
	private int age;
	private double weight;
	private double height;
	private FitnessLevel flevel;
	
	public User(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public User(String name, String gender, int age, double weight, double height) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	
	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	
	public int getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}

	
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	
	public FitnessLevel getFitnessLevel() {
		// TODO Auto-generated method stub
		return this.flevel;
	}
}
