package interfaces;

import java.util.List;

public interface Lobby {
	int addPokemon(int select);
	int removePokemon(int select);
	Pokemon getSelected();
	void deselect();
	void selectPokemon(String name);
	boolean selectFromTeam(int select, int index);
	void initPokedex();
	Pokedex getPokedex();
	boolean play();
	List<Pokemon> getTeam(int select);
}
