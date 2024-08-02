package model.battle;

import interfaces.Action;
import interfaces.Pokemon;

public class ActionImpl implements Action{
	
	private Pokemon pAttacker;
	private int id;
	
	public ActionImpl(Pokemon pAttacker2, int id) {
		
		this.pAttacker = pAttacker2;
		this.id = id;
	}

	@Override
	public Pokemon getAttacker() {
		return this.pAttacker;
	}

	@Override
	public int getId() {
		return this.id;
	}

}
