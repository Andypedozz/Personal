package model.battle;

import model.Move;
import model.Pokemon;

public class AttackAction extends Action{
	
	private Pokemon pTarget;
	private Move usedMove;
	
	public AttackAction(Pokemon pAttacker, Pokemon pTarget, Move usedMove, int id) {
		
		super(pAttacker, id);
		this.pTarget = pTarget;
		this.usedMove = usedMove;
	}
	
	public void changeTarget(Pokemon target) {
		
		this.pTarget = target;
	}
	
	public Pokemon getTarget() {
		
		return this.pTarget;
	}
	
	public Move getUsedMove() {
		
		return this.usedMove;
	}
	
}
