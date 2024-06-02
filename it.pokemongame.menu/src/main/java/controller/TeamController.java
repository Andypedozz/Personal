package controller;

import java.util.LinkedList;
import java.util.List;

import model.Pokemon;
import interfaces.TeamObserver;
import interfaces.View;
import model.Team;
import model.battle.Match;
import model.menu.Model;

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
		
		// recupero le immagini d
		List<String> paths = new LinkedList<>();
		List<String> names = new LinkedList<>();
		for(Pokemon p : this.model.getLobby().getPokedex().getList()) {
			paths.add(p.getIconString());
			names.add(p.getName());
		}
		this.view.getFrame().getTeamPanel().loadButtons(names,paths);
		
	}
	
	@Override
	public void selectPokemon(String name) {
		// TODO Auto-generated method stub
		this.model.getLobby().selectPokemon(name);
	}

	@Override
	public void addPokemon(int select) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		this.model.getLobby().deselect();
		this.view.getFrame().getTeamPanel().resetSlots();
	}
	
	@Override
	public void infoScreen() {
		// TODO Auto-generated method stub
		if(this.model.getLobby().getSelected() != null) {
			Pokemon pokemon = this.model.getLobby().getSelected();
			this.view.getFrame().infoScreen(pokemon);
			this.deselect();
		}else
			this.view.getFrame().getTeamPanel().pokemonNotSelected();
	}


	@Override
	public void removePokemon(int select) {
		// TODO Auto-generated method stub
		int index = this.model.getLobby().removePokemon(select);
		if(index > -1) {
			this.view.getFrame().getTeamPanel().removePokemon(select,index);
			this.deselect();
		}else
			this.view.getFrame().getTeamPanel().pokemonNotSelected();
	}

	@Override
	public void backFromTeam() {
		// TODO Auto-generated method stub
		this.model.exitLobby();
		this.father.initMainMenu();
	}

	@Override
	public void selectFromTeam(int select, int index) {
		// TODO Auto-generated method stub
		boolean selected = this.model.getLobby().selectFromTeam(select, index);
		if(selected)
			this.view.getFrame().getTeamPanel().selectFromTeam(select, index);
	}

	@Override
	public void play() {

		boolean ready = this.model.getLobby().play();
		if(ready) {
			Team team1 = new Team(this.model.getLobby().getTeam(0));
			Team team2 = new Team(this.model.getLobby().getTeam(1));
			Match match = new Match(team1, team2);
			this.father.initBattle(match);
		}		
		else
			this.view.getFrame().getTeamPanel().notReady();
	}

	@Override
	public int getPokedexSize() {
		// TODO Auto-generated method stub
		return this.model.getLobby().getPokedex().getList().size();
	}
}
