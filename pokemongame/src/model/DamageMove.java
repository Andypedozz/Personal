package model;

public class DamageMove extends MoveImpl{
	
	public DamageMove(String name, Type type, int pp, int power, int precision, String description, MoveType moveTarget, MovesEffects moveEffect, int priority) {
		super(name, type, pp, power, precision, description, moveTarget, moveEffect, priority);
	}
}
