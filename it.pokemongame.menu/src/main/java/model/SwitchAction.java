package model;

public class SwitchAction extends Action{
	
	private Pokemon pokemonToSwitch;
	
	public SwitchAction(Pokemon pAttacker, Pokemon pokemonToSwitch, int id) {
		super(pAttacker, id);
		this.pokemonToSwitch = pokemonToSwitch;
	}
	
	public Pokemon getPokemonToSwitch() {
		
		return this.pokemonToSwitch;
	}
}
