package model;


public class Stats {
	
	//Attributi di base del pokemon
	private final int hp;
	private final int attack;
	private final int defense;
	private final int spAttack;
	private final int spDefense;
	private final int speed;
	
	//Attributi del pokemon nel corso della battaglia
	private int actualHp;
	private int actualAttack;
	private int actualDefense;
	private int actualSpAttack;
	private int actualSpDefense;
	private int actualSpeed;
	private int precision;
	private int elusion;
	
	public Stats(int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
		
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.actualHp = hp;
		this.actualAttack = attack;
		this.actualDefense = defense;
		this.actualSpAttack = spAttack;
		this.actualSpDefense = spDefense;
		this.actualSpeed = speed;
		this.precision = 100;
		this.elusion = 100;
	}

	
	public int getHp() {
		return this.hp;
	}

	
	public int getAttack() {
		return this.attack;
	}

	
	public int getDefense() {
		return defense;
	}

	
	public int getSpeed() {
		return this.speed;
	}

	
	public void setActualHp(int actualHp) {
		this.actualHp = actualHp;
		
	}

	
	public int getActualHp() {
		return this.actualHp;
	}

	
	public void setActualAttack(int actualAttack) {
		this.actualAttack = actualAttack;
	}

	
	public int getActualAttack() {
		return this.actualAttack;
	}

	
	public void setActualDefense(int actualDefense) {
		this.actualDefense = actualDefense;
	}

	
	public int getActualDefense() {
		return this.actualDefense;
	}

	
	public void setActualSpeed(int actualSpeed) {
		this.actualSpeed = actualSpeed;
	}

	
	public int getActualSpeed() {
		return this.actualSpeed;
	}

	
	public int getSpAttack() {
		return this.spAttack;
	}

	
	public int getSpDefense() {
		return this.spDefense;
	}

	
	public void setActualSpAttack(int actualSpAttack) {
		this.actualSpAttack = actualSpAttack;
	}

	
	public int getActualSpAttack() {
		return this.actualSpAttack;
	}

	
	public void setActualSpDefense(int actualSpDefense) {
		this.actualSpDefense = actualSpDefense;
	}

	
	public int getActualSpDefense() {
		return this.actualSpDefense;
	}

	
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	
	public void setElusion(int elusion) {
		this.elusion = elusion;
	}

	
	public int getPrecision() {
		return this.precision;
	}

	
	public int getElusion() {
		return this.elusion;
	}
	
	public Stats duplicate() {
		
		return new Stats(this.hp, this.attack, this.defense, this.spAttack, this.spDefense, this.speed);
	}
	

}
