package controller;

import javax.swing.JButton;

import interfaces.BattleUpdateListener;
import interfaces.BattleViewObserver;
import interfaces.View;
import model.Move;
import model.Pokemon;
import model.battle.Match;
import model.menu.Model;
import view.MoveButton;
import view.PokemonButton;

public class BattleController implements BattleViewObserver, BattleUpdateListener {
	
	private View view;
	private Model model;
	private boolean isPlayer1Turn;
	
	public BattleController(View view, Model model) {
		
		this.view = view;
		this.view.getSwitchView().setObserver(this);
		this.view.getSelectMoveView().setObserver(this);
		this.model = model;
		this.model.getMatch().getActionsCase().setListener(this);
		this.isPlayer1Turn = true;
	}
    
	public void setView(Pokemon pokemon1, Pokemon pokemon2, boolean isPlayer1Turn) {
	    Move move1 = (isPlayer1Turn) ? pokemon1.getMoveSet().getMove1() : pokemon2.getMoveSet().getMove1();
	    Move move2 = (isPlayer1Turn) ? pokemon1.getMoveSet().getMove2() : pokemon2.getMoveSet().getMove2();
	    Move move3 = (isPlayer1Turn) ? pokemon1.getMoveSet().getMove3() : pokemon2.getMoveSet().getMove3();
	    Move move4 = (isPlayer1Turn) ? pokemon1.getMoveSet().getMove4() : pokemon2.getMoveSet().getMove4();
	    this.view.getSelectMoveView().getBtnMove1().setUsedMove(move1);
	    this.view.getSelectMoveView().getBtnMove2().setUsedMove(move2);
	    this.view.getSelectMoveView().getBtnMove3().setUsedMove(move3);
	    this.view.getSelectMoveView().getBtnMove4().setUsedMove(move4);
	    setAttackers((isPlayer1Turn) ? pokemon1 : pokemon2);
	    setTargets((isPlayer1Turn) ? pokemon2 : pokemon1);
	    setIcons(pokemon1, pokemon2);
	    setHealthBars(pokemon1, pokemon2);
	    this.view.getSelectMoveView().setAskLabel("Cosa deve fare " + ((isPlayer1Turn) ? pokemon1.getName() : pokemon2.getName()) + " ?");
	}
	
	public void setAttackers(Pokemon pokemon) {
		
		this.view.getSelectMoveView().getBtnMove1().setAttacker(pokemon);
	    this.view.getSelectMoveView().getBtnMove2().setAttacker(pokemon);
	    this.view.getSelectMoveView().getBtnMove3().setAttacker(pokemon);
	    this.view.getSelectMoveView().getBtnMove4().setAttacker(pokemon);
	}
	
	public void setTargets(Pokemon pokemon) {
		
		this.view.getSelectMoveView().getBtnMove1().setTarget(pokemon);
	    this.view.getSelectMoveView().getBtnMove2().setTarget(pokemon);
	    this.view.getSelectMoveView().getBtnMove3().setTarget(pokemon);
	    this.view.getSelectMoveView().getBtnMove4().setTarget(pokemon);
	}	
	
	public void updateView(boolean isPlayer1Turn) {
		Pokemon pokemon1 = this.model.getMatch().getPokemonInBattle();
	    Pokemon pokemon2 = this.model.getMatch().getPokemonInBattle2();
	    setView(pokemon1, pokemon2, isPlayer1Turn);
	}
	
	public void setIcons(Pokemon pokemon1, Pokemon pokemon2) {
		
		try {
	        String imageString = pokemon1.getIconString();
	        this.view.getSelectMoveView().setLabel1Info(pokemon1.getName() + " " + pokemon1.getStats().getActualHp() + "/" + pokemon1.getStats().getHp());
	        this.view.getSelectMoveView().setIcon1(imageString);
	    } catch (Exception e) {
	        System.err.println("Errore nel caricamento dell'immagine per " + pokemon1.getName() + ": " + e.getMessage());
	    }
		
		 try {
		        String imageString = pokemon2.getIconString();
		        this.view.getSelectMoveView().setLabel2Info(pokemon2.getName() + " " + pokemon2.getStats().getActualHp() + "/" + pokemon2.getStats().getHp());
		        this.view.getSelectMoveView().setIcon2(imageString);
		    } catch (Exception e) {
		        System.err.println("Errore nel caricamento dell'immagine per " + pokemon2.getName() + ": " + e.getMessage());
		    }
	}
	
	public void setHealthBars(Pokemon pokemon1, Pokemon pokemon2) {
		
		this.view.getSelectMoveView().setProgressBar1(pokemon1.getStats().getHp());
	    this.view.getSelectMoveView().updateProgressBar1(pokemon1.getStats().getActualHp());
	    this.view.getSelectMoveView().setProgressBar2(pokemon2.getStats().getHp());
	    this.view.getSelectMoveView().updateProgressBar2(pokemon2.getStats().getActualHp());
	}
	public void setSwitchViewForTeam1() {
		Pokemon attacker = this.model.getMatch().getPokemonInBattle();
		Pokemon pokemon1 = this.model.getMatch().getTeam1().getTeam().get(1);
		Pokemon pokemon2 = this.model.getMatch().getTeam1().getTeam().get(2);
		this.view.getSwitchView().getBtnPokemon1().setAttacker(attacker);
		this.view.getSwitchView().getBtnPokemon2().setAttacker(attacker);
		this.view.getSwitchView().getBtnPokemon1().setPokemonToSwitch(pokemon1);
		this.view.getSwitchView().getBtnPokemon2().setPokemonToSwitch(pokemon2);
	}
	
	public void startBattle(Match match) {
        
		this.model.setMatch(match);
		setView(match.getPokemonInBattle(), match.getPokemonInBattle2(), true);
        view.getSelectMoveView().setVisible(true);   
	}

	@Override
	public void storeMove(MoveButton button) {    
	    Pokemon pAttacker = button.getAttacker();
	    Move usedMove = button.getUsedMove();
	    this.model.getMatch().createAttackAction(pAttacker, usedMove);
	    this.model.getMatch().addAction(this.model.getMatch().getAction(pAttacker));
	    if (this.model.getMatch().getActionList().size() == 2) {
	        this.model.getMatch().battle();
	        switchTurn();
	        updateView(this.isPlayer1Turn);
	    }
	    else {
	    	
	    	switchTurn();
	    	updateView(this.isPlayer1Turn);
	    }	    
	}

	@Override
	public void deleteSelectedAction(JButton btnBack) {
		this.model.getMatch().getActionList().removeAll(this.model.getMatch().getActionList());
		switchTurn();
		updateView(this.isPlayer1Turn);
	}

	@Override
	public void storeSwitchAction(PokemonButton button) {
		Pokemon pAttacker = button.getAttacker();
		Pokemon pokemonToSwitch = button.getPokemonToSwitch();
		this.model.getMatch().createSwitchAction(pAttacker, pokemonToSwitch);
		this.model.getMatch().addAction(this.model.getMatch().getAction(pAttacker));
		if(this.model.getMatch().getActionList().size() == 2) {
			this.model.getMatch().battle();
		}
		else {
			switchTurn();
			updateView(this.isPlayer1Turn);
		}
	}
	
	@Override
	public void onBattleEnd() {
		updateView(this.isPlayer1Turn);
	}
	
	public void switchTurn() {
		
		this.isPlayer1Turn ^= true;
	}
}
