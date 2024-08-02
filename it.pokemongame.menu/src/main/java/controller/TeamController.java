package controller;

import java.util.LinkedList;
import java.util.List;

import interfaces.Pokemon;
import interfaces.TeamObserver;
import interfaces.View;
import model.TeamImpl;
import model.battle.MatchImpl;
import interfaces.Team;
import interfaces.Match;
import interfaces.Model;

public class TeamController implements TeamObserver{
	private Controller father;
	private Model model;
	private View view;
	
	public TeamController(Model model, View view, Controller father) {
		this.father = father;
		this.model = model;
		this.view = view;
	}
	
	// metodo per avviare una schermata di scelta team
	@Override
	public void initTeam() {
		if(this.model.getLobby() == null) {
			this.model.initLobby();
			this.model.getLobby().initPokedex();
		}
		this.view.getFrame().teamMenu();
		
		// recupero le immagini dal pokedex
		List<String> paths = new LinkedList<>();
		List<String> names = new LinkedList<>();
		this.model.getLobby().getPokedex().getList().stream().forEach(e -> {
			paths.add(e.getIconString());
			names.add(e.getName());
		});
		this.view.getFrame().getTeamPanel().loadButtons(names,paths);
		
	}
	
	@Override
	public void selectPokemon(String name) {
		this.model.getLobby().selectPokemon(name);
	}

	@Override
	public void addPokemon(int select) {
		int added = this.model.getLobby().addPokemon(select);
		if(added >= 0) {
			this.view.getFrame().getTeamPanel().addPokemon(select);
			this.deselect();
		}else if(added == -1) {
			this.view.getFrame().getTeamPanel().pokemonNotSelected();
			this.deselect();
		}
		else if(added == -2){
			this.view.getFrame().getTeamPanel().teamFull();
			this.deselect();
		}else {
			this.view.getFrame().getTeamPanel().alreadyPresent();
			this.deselect();
		}
	}

	@Override
	public void deselect() {
		this.model.getLobby().deselect();
		this.view.getFrame().getTeamPanel().resetSlots();
	}
	
	@Override
	public void infoScreen() {
		if(this.model.getLobby().getSelected() != null) {
			Pokemon pokemon = this.model.getLobby().getSelected();
			this.view.getFrame().infoScreen(pokemon);
			this.deselect();
		}else
			this.view.getFrame().getTeamPanel().pokemonNotSelected();
	}


	@Override
	public void removePokemon(int select) {
		int index = this.model.getLobby().removePokemon(select);
		if(index > -1) {
			this.view.getFrame().getTeamPanel().removePokemon(select,index);
			this.deselect();
		}else
			this.view.getFrame().getTeamPanel().pokemonNotSelected();
	}

	@Override
	public void backFromTeam() {
		this.model.exitLobby();
		if(this.model.isSaveEnabled())
			this.father.initMainMenu();
		else
			this.view.getFrame().firstMenu();
	}

	@Override
	public void selectFromTeam(int select, int index) {
		boolean selected = this.model.getLobby().selectFromTeam(select, index);
		if(selected)
			this.view.getFrame().getTeamPanel().selectFromTeam(select, index);
	}

	@Override
	public void play() {

		boolean ready = this.model.getLobby().play();
		if(ready) {
			Team team1 = new TeamImpl(this.model.getLobby().getTeam(0));
			Team team2 = new TeamImpl(this.model.getLobby().getTeam(1));
			Match match = new MatchImpl(team1, team2);
			this.father.initBattle(match);
		}		
		else
			this.view.getFrame().getTeamPanel().notReady();
	}

	@Override
	public int getPokedexSize() {
		return this.model.getLobby().getPokedex().getList().size();
	}
}
