package model;
import java.util.ArrayList;

public class Match {
	
	private Team team1;
	private Team team2;
	private Pokemon pokemonInBattle;
	private Pokemon pokemonInBattle2;
	private Action action1;
	private Action action2;
	private ArrayList<Action> actionsList;
	private ActionsCase actions;
	
	public Match(Team team1, Team team2) {
		
		this.team1 = team1;
		this.team2 = team2;
		this.pokemonInBattle = this.team1.getTeam().get(0);
		this.pokemonInBattle2 = this.team2.getTeam().get(0);
		this.actions = new ActionsCase(this);
		this.actionsList = new ArrayList<>();
	}
	
	
    public void createAttackAction(Pokemon pokemon, Move usedMove) {
    	
    	if(pokemon.equals(this.pokemonInBattle)) {
    		
    		this.action1 = new AttackAction(pokemon, pokemonInBattle2, usedMove, 0);
    	}
    	else {
    		
    		this.action2 = new AttackAction(pokemon, pokemonInBattle, usedMove, 0);
    	}
    }
    
	
    public void createSwitchAction(Pokemon pokemon, Pokemon pokemonToSwitch) {
    	
    	if(pokemon.equals(this.pokemonInBattle)) {
    		this.action1 = new SwitchAction(pokemon, pokemonToSwitch, 1);
    	}
    	else {
    		this.action2 = new SwitchAction(pokemon, pokemonToSwitch, 1);
    	}	
    }
    
	
    public void addAction(Action action) {
    	
    	this.actionsList.add(action);
    }
    
	
    public ArrayList<Action> getActionList(){
    	
    	return this.actionsList;
    }
    public Action getAction(Pokemon pokemon) {
    	
    	if(pokemon.equals(this.pokemonInBattle)) {
    		return this.action1;
    	}
    	else {
    		return this.action2;
    	}
    }
    
    
    public void setPokemonInBattle(Pokemon pokemon) {
    	
    	this.pokemonInBattle = pokemon;
    }
    
    
    public void setPokemonInBattle2(Pokemon pokemon) {
    	
    	this.pokemonInBattle2 = pokemon;
    }
    
    
    public Pokemon getPokemonInBattle() {
    	
    	return this.pokemonInBattle;
    }
    
    
    public Pokemon getPokemonInBattle2() {
    	
    	return this.pokemonInBattle2;
    }
    
    
    public Team getTeam1() {
    	
    	return this.team1;
    }
    
    
    public Team getTeam2() {
    	
    	return this.team2;
    }
    
    
    public void battle() {
    	
    	this.actions.startActions(this.actionsList);
    	resetBattle(this.actionsList);
    }
    
    
    public ActionsCase getActionsCase() {
    	
    	return this.actions;
    }
    
    
    public void resetBattle(ArrayList<Action> actionsList) {
    	
    	for(Action action : actionsList) {
    		
    		action.getAttacker().setIsProtect(false);
    	}
    	this.actionsList.removeAll(this.actionsList);
    }
}
