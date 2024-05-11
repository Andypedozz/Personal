package model;

import java.util.List;

public class Pokemon {
	
	private final String name;
	private final List<Type> type;
	private Stats stats;
	private MoveSet moveSet;
	private String iconString;
	private boolean isFainted;
	private boolean isProtect;
	
	public Pokemon(String name, List<Type> type, Stats stats, MoveSet moveSet, String iconString) {
		
		this.name = name;
		this.type = type;
		this.stats = stats;
		this.moveSet = moveSet;	
		this.iconString = iconString;
		this.isFainted = false;
		this.isProtect = false;
	}


	public String getName() {
		return this.name;
	}

	public List<Type> getType() {
		return this.type;
	}

	public Stats getStats() {
		return this.stats;
	}
	
	
	public MoveSet getMoveSet() {
		return this.moveSet;
	}

	
	public String getIconString() {
		return this.iconString;
	}


	
	public Pokemon duplicate() {
		Stats newStats = this.stats.duplicate();
	    MoveSet newMoveSet = this.moveSet.duplicate();
	    return new Pokemon(this.name, this.type, newStats, newMoveSet, this.iconString);
	}


	
	public boolean isFainted() {
		return this.isFainted;
	}

	
	public void setIsFainted(boolean isFainted) {
		this.isFainted = isFainted;
	}


	
	public void setIsProtect(boolean isProtect) {
		this.isProtect = isProtect;
	}


	
	public boolean getIsProtect() {
		return this.isProtect;
	}
	
	
}
