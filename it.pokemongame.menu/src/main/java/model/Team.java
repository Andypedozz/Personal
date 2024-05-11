package model;

import java.util.List;

public class Team {
	
	private List<Pokemon> team;
	
	public Team(List<Pokemon> team) {
		
		this.team = team;
	}
	
	public List<Pokemon> getTeam(){
		
		return this.team;
	}
}
