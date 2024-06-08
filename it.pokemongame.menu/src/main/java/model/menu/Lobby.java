package model.menu;

import java.util.LinkedList;
import java.util.List;

import model.Pokedex;
import model.Pokemon;

public class Lobby {
	private static Lobby INSTANCE = null;
	private List<Pokemon> teams[];
	private Pokemon selectedPokemon;
	private Pokedex pokedex;
	
	private Lobby() {
		this.pokedex = new Pokedex();
		this.teams = new LinkedList[2];
		this.teams[0] = new LinkedList<>();
		this.teams[1] = new LinkedList<>();
	}
	
	public static Lobby getInstance() {
		if(INSTANCE == null)
			INSTANCE = new Lobby();
		return INSTANCE;
	}
	
	public int addPokemon(int select) {
		int added;
		if(this.teams[select].size() < 3)
			if(this.selectedPokemon != null && !this.teams[select].contains(this.selectedPokemon)) {
				this.teams[select].add(selectedPokemon);
				System.out.println("Aggiunto "+this.selectedPokemon.getName()+" al team "+select);
				added = this.teams[select].size() - 1;
			}else {
				if(this.teams[select].contains(this.selectedPokemon)) {
					added = -3;
					System.out.println("Pokemon già presente in squadra!");
				}else {
					added = -1;	
					System.out.println("Pokemon non selezionato!");
				}
			}
		else {
			added = -2;
			System.out.println("Team pieno");
		}
		return added;
	}

	
	public int removePokemon(int select) {
		int removed;
		if(this.teams[select].size() >= 1) {
			int index = this.teams[select].size() - 1;
			this.teams[select].remove(index);
			removed = index;
		}else {
			System.out.println("Squadra vuota!");
			removed = -1;
		}
		return removed;
	}

	
	public Pokemon getSelected() {
		return this.selectedPokemon;
	}

	
	public void deselect() {
		if(this.selectedPokemon != null) {
			this.selectedPokemon = null;
			System.out.println("Deselezionato!");
		}
	}

	
	public void selectPokemon(String name) {
		this.selectedPokemon = this.pokedex.getPokemon(name);
		System.out.println("Selezionato "+this.selectedPokemon.getName());
	}

	
	public void initPokedex() {
		this.pokedex = new Pokedex();
	}

	
	public Pokedex getPokedex() {
		return this.pokedex;
	}

	
	public boolean selectFromTeam(int select, int index) {
		boolean selected = false;
		if(this.teams[select].size() > index) {
			this.selectedPokemon = this.teams[select].get(index);
			System.out.println("Selezionato "+this.selectedPokemon.getName());
			selected = true;
		}else
			selected = false;
		return selected;
	}

	
	public boolean play() {
		boolean ready = false;
		if(this.teams[0].size() == 3 && this.teams[1].size() == 3)
			ready = true;
		return ready;		
	}

	
	public List<Pokemon> getTeam(int select) {
		return this.teams[select];
	}
}
