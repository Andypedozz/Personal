package model;

import java.util.List;

import interfaces.Pokemon;
import interfaces.Team;

public class TeamImpl implements Team{
	
	private List<Pokemon> team;
	
	public TeamImpl(List<Pokemon> team) {
		
		this.team = team;
	}
	
	@Override
	public List<Pokemon> getTeam(){
		
		return this.team;
	}
}
