package model;

public class Move {
	
	private final String name;
	private final Type type;
	private final MovesEffects moveEffect;
	private final int pp;
	private final int power;
	private final int precision;
	private final String description;
	private final MoveType moveType;
	private final int priority;
	private int actualPp;
	
	public Move(String name, Type type, int pp, int power, int precision, String description, MoveType moveTarget, MovesEffects moveEffect, int priority) {
		
		this.name = name;
		this.type = type;
		this.power = power;
		this.pp = pp;
		this.actualPp = pp;
		this.precision = precision;
		this.description = description;	
		this.moveType = moveTarget;
		this.moveEffect = moveEffect;
		this.priority = priority;
	}
	
	
	public void setActualPp(int actualPp) {
		this.actualPp = actualPp;
	}

	
	public int getActualPp() {
		return this.actualPp;
	}
	
	
	public MovesEffects getMoveEffect() {
		
		return this.moveEffect;
	}
	
	public int getPp() {
		return this.pp;
	}

	
	public int getPrecision() {
		return this.precision;
	}

	
	public String getName() {
		return this.name;
	}

	
	public int getPower() {
		return this.power;
	}

	
	public String getDescription() {
		return this.description;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public MoveType getMoveType() {
		return this.moveType;
	}
	
	public Move duplicateMove() {
		return new Move(this.name, this.type, this.pp, this.power, this.precision, this.description, this.moveType, this.moveEffect, this.priority);
	}

	
	public int getPriority() {
		return this.priority;
	}
}
