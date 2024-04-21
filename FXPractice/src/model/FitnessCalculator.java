package model;

public class FitnessCalculator {
	public FitnessLevel calculateFitnessLevel(User user) {
			return null;
	}
	
	public double getBMI(User user) {
		double height = user.getHeight() / 100;
		return user.getWeight() / (height * height);
	}
}
