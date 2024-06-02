package model.battle;

import model.Move;
import model.MoveType;
import model.Type;

public class DamageMove extends Move{
	
	public DamageMove(String name, Type type, int pp, int power, int precision, String description, MoveType moveTarget, MovesEffects moveEffect, int priority) {
		super(name, type, pp, power, precision, description, moveTarget, moveEffect, priority);
	}
}
