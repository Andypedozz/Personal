package model.battle;

import model.Pokemon;

public class Action {
	
	private Pokemon pAttacker;
	private int id;
	
	public Action(Pokemon pAttacker2, int id) {
		
		this.pAttacker = pAttacker2;
		this.id = id;
	}

	
	public Pokemon getAttacker() {
		return this.pAttacker;
	}

	
	public int getId() {
		return this.id;
	}

}
