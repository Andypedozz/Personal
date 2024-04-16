package model;

import java.util.LinkedList;
import java.util.List;

import interfaces.Account;
import interfaces.Lobby;
import interfaces.Pokedex;
import interfaces.Pokemon;

public class LobbyImpl implements Lobby{
	private List<Pokemon> teams[];
	private Pokemon selectedPokemon;
	private Pokedex pokedex;
	private boolean ready[];
	
	public LobbyImpl() {
		this.pokedex = new PokedexImpl();
		this.teams = new LinkedList[2];
		this.teams[0] = new LinkedList();
		this.teams[1] = new LinkedList();
		this.ready = new boolean[2];
	}
	
	@Override
	public int addPokemon(int select) {
		// TODO Auto-generated method stub
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

	@Override
	public int removePokemon(int select) {
		// TODO Auto-generated method stub
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

	@Override
	public void switchReady(int select) {
		// TODO Auto-generated method stub
		this.ready[select] = (this.ready[select])? false : true;
	}

	@Override
	public Pokemon getSelected() {
		// TODO Auto-generated method stub
		return this.selectedPokemon;
	}

	@Override
	public void deselect() {
		// TODO Auto-generated method stub
		if(this.selectedPokemon != null) {
			this.selectedPokemon = null;
			System.out.println("Deselezionato!");
		}
	}

	@Override
	public void selectPokemon(String name) {
		// TODO Auto-generated method stub
		this.selectedPokemon = this.pokedex.getPokemon(name);
		System.out.println("Selezionato "+this.selectedPokemon.getName());
	}

	@Override
	public void initPokedex() {
		// TODO Auto-generated method stub
		this.pokedex = new PokedexImpl();
	}

	@Override
	public Pokedex getPokedex() {
		// TODO Auto-generated method stub
		return this.pokedex;
	}

	@Override
	public boolean selectFromTeam(int select, int index) {
		// TODO Auto-generated method stub
		boolean selected = false;
		if(this.teams[select].size() > index) {
			this.selectedPokemon = this.teams[select].get(index);
			System.out.println("Selezionato "+this.selectedPokemon.getName());
			selected = true;
		}else
			selected = false;
		return selected;
	}

	@Override
	public boolean play() {
		// TODO Auto-generated method stub
		boolean ready = false;
		if(this.teams[0].size() == 3 && this.teams[1].size() == 3)
			ready = true;
		return ready;		
	}

	@Override
	public List<Pokemon> getTeam(int select) {
		// TODO Auto-generated method stub
		return this.teams[select];
	}
}
