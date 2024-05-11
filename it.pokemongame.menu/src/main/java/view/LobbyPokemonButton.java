package view;

import javax.swing.JButton;

public class LobbyPokemonButton extends JButton{
	private String pokemonName;
	private int index;
	
	public LobbyPokemonButton(int index) {
		this.index = index;
	}
	
	public LobbyPokemonButton(String pokemonName, int index) {
		this.index = index;
		this.pokemonName = pokemonName;
	}
	
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	
	public String getPokemonName() {
		return this.pokemonName;
	}
	
	public int getIndex() {
		return this.index;
	}

}
