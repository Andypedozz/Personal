package controller;

import interfaces.BattleUpdateListener;
import interfaces.BattleViewObserver;
import interfaces.Match;
import interfaces.Model;
import interfaces.Move;
import interfaces.Pokemon;
import interfaces.Team;
import interfaces.View;
import view.MoveButton;
import view.PokemonButton;

public class BattleController implements BattleViewObserver, BattleUpdateListener {
	
	private View view;
	private Model model;
	
	public BattleController(View view, Model model) {
		
		this.view = view;
		this.model = model;
	}
    
	@Override
	public void startBattle(Match match) {
        
		this.model.setMatch(match);
		this.model.getMatch().getActionsCase().setListener(this);
		this.view.getFrame().battleMenu();
		this.view.getFrame().getBattlePanel().setObserver(this);
		updateView();
	}
	
	@Override
	public void setViewForTeam1(Pokemon pokemon1, Pokemon pokemon2) {
	    Move move1 = pokemon1.getMoveSet().getMove1();
	    Move move2 = pokemon1.getMoveSet().getMove2();
	    Move move3 = pokemon1.getMoveSet().getMove3();
	    Move move4 = pokemon1.getMoveSet().getMove4();
	    this.view.getFrame().getBattlePanel().getBtnMove1().setUsedMove(move1);
	    this.view.getFrame().getBattlePanel().getBtnMove2().setUsedMove(move2);
	    this.view.getFrame().getBattlePanel().getBtnMove3().setUsedMove(move3);
	    this.view.getFrame().getBattlePanel().getBtnMove4().setUsedMove(move4);
	    setAttackersForTeam1(pokemon1);
	    setTargetsForTeam1(pokemon2);
	    setIconForTeam1(pokemon1);
	    setHealthBarForTeam1(pokemon1);
	    this.view.getFrame().getBattlePanel().setAskLabel("Cosa deve fare " + pokemon1.getName() + " ?");
	}
	
	@Override
	public void setViewForTeam2(Pokemon pokemon1, Pokemon pokemon2) {
	    Move move5 = pokemon2.getMoveSet().getMove1();
	    Move move6 = pokemon2.getMoveSet().getMove2();
	    Move move7 = pokemon2.getMoveSet().getMove3();
	    Move move8 = pokemon2.getMoveSet().getMove4();
	    this.view.getFrame().getBattlePanel().getBtnMove5().setUsedMove(move5);
	    this.view.getFrame().getBattlePanel().getBtnMove6().setUsedMove(move6);
	    this.view.getFrame().getBattlePanel().getBtnMove7().setUsedMove(move7);
	    this.view.getFrame().getBattlePanel().getBtnMove8().setUsedMove(move8);
	    setAttackersForTeam2(pokemon2);
	    setTargetsForTeam2(pokemon1);
	    setIconForTeam2(pokemon2);
	    setHealthBarForTeam2(pokemon2);
	    this.view.getFrame().getBattlePanel().setAskLabel2("Cosa deve fare " + pokemon2.getName() + " ?");
	}
	
	@Override
	public void setAttackersForTeam1(Pokemon pokemon) {
		
		this.view.getFrame().getBattlePanel().getBtnMove1().setAttacker(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove2().setAttacker(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove3().setAttacker(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove4().setAttacker(pokemon);
	}
	
	@Override
	public void setTargetsForTeam1(Pokemon pokemon) {
		
		this.view.getFrame().getBattlePanel().getBtnMove1().setTarget(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove2().setTarget(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove3().setTarget(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove4().setTarget(pokemon);
	}
	
	@Override
	public void setAttackersForTeam2(Pokemon pokemon) {
		
		this.view.getFrame().getBattlePanel().getBtnMove5().setAttacker(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove6().setAttacker(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove7().setAttacker(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove8().setAttacker(pokemon);
	}
	
	@Override
	public void setTargetsForTeam2(Pokemon pokemon) {
		
		this.view.getFrame().getBattlePanel().getBtnMove5().setTarget(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove6().setTarget(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove7().setTarget(pokemon);
	    this.view.getFrame().getBattlePanel().getBtnMove8().setTarget(pokemon);
	}	
	
	@Override
	public void updateView() {
		Pokemon pokemon1 = this.model.getMatch().getPokemonInBattle();
	    Pokemon pokemon2 = this.model.getMatch().getPokemonInBattle2();
	    setViewForTeam1(pokemon1, pokemon2);
	    setViewForTeam2(pokemon1, pokemon2);
	}
	
	@Override
	public void setIconForTeam1(Pokemon pokemon) {
		
		try {
	        	String imageString = pokemon.getIconString();
	        	this.view.getFrame().getBattlePanel().setLabel1Info(pokemon.getName() + " " + pokemon.getStats().getActualHp() + "/" + pokemon.getStats().getHp());
	        	this.view.getFrame().getBattlePanel().setIcon1(imageString);
	    } catch (Exception e) {
	        	System.err.println("Errore nel caricamento dell'immagine per " + pokemon.getName() + ": " + e.getMessage());
	    }
	}
	
	@Override
	public void setIconForTeam2(Pokemon pokemon) {
		
		try {
	        	String imageString = pokemon.getIconString();
	        	this.view.getFrame().getBattlePanel().setLabel2Info(pokemon.getName() + " " + pokemon.getStats().getActualHp() + "/" + pokemon.getStats().getHp());
	        	this.view.getFrame().getBattlePanel().setIcon2(imageString);
	    } catch (Exception e) {
	        	System.err.println("Errore nel caricamento dell'immagine per " + pokemon.getName() + ": " + e.getMessage());
	    }
	}
	
	@Override
	public void setHealthBarForTeam1(Pokemon pokemon) {
		
		this.view.getFrame().getBattlePanel().setProgressBar1(pokemon.getStats().getHp());
	    this.view.getFrame().getBattlePanel().updateProgressBar1(pokemon.getStats().getActualHp()); 
	}
	
	@Override
	public void setHealthBarForTeam2(Pokemon pokemon) {
		
	    this.view.getFrame().getBattlePanel().setProgressBar2(pokemon.getStats().getHp());
	    this.view.getFrame().getBattlePanel().updateProgressBar2(pokemon.getStats().getActualHp());
	}
	
	@Override
	public void setSwitchViewForTeam1() {
		this.view.getFrame().getBattlePanel().getSwitchFrame().setObserver(this);
		Pokemon attacker = this.model.getMatch().getPokemonInBattle();
		Pokemon pokemon1 = this.model.getMatch().getTeam1().getTeam().get(1);
		Pokemon pokemon2 = this.model.getMatch().getTeam1().getTeam().get(2);
		this.view.getFrame().getBattlePanel().getSwitchFrame().getBtnSwitch1().setAttacker(attacker);
		this.view.getFrame().getBattlePanel().getSwitchFrame().getBtnSwitch2().setAttacker(attacker);
		this.view.getFrame().getBattlePanel().getSwitchFrame().getBtnSwitch1().setPokemonToSwitch(pokemon1);
		this.view.getFrame().getBattlePanel().getSwitchFrame().getBtnSwitch2().setPokemonToSwitch(pokemon2);
		this.view.getFrame().getBattlePanel().setEnableforBtn(false);
		this.view.getFrame().getBattlePanel().getBtnBack().setEnabled(false);
	}
	
	@Override
	public void setSwitchViewForTeam2() {
		this.view.getFrame().getBattlePanel().getSwitchFrame2().setObserver(this);
		Pokemon attacker = this.model.getMatch().getPokemonInBattle2();
		Pokemon pokemon1 = this.model.getMatch().getTeam2().getTeam().get(1);
		Pokemon pokemon2 = this.model.getMatch().getTeam2().getTeam().get(2);
		this.view.getFrame().getBattlePanel().getSwitchFrame2().getBtnSwitch1().setAttacker(attacker);
		this.view.getFrame().getBattlePanel().getSwitchFrame2().getBtnSwitch2().setAttacker(attacker);
		this.view.getFrame().getBattlePanel().getSwitchFrame2().getBtnSwitch1().setPokemonToSwitch(pokemon1);
		this.view.getFrame().getBattlePanel().getSwitchFrame2().getBtnSwitch2().setPokemonToSwitch(pokemon2);
		this.view.getFrame().getBattlePanel().setEnableforBtn2(false);
		this.view.getFrame().getBattlePanel().getBtnBack2().setEnabled(false);
	}
	
	@Override
	public void storeMove(MoveButton button, boolean teamAction) {    
	    Pokemon pAttacker = button.getAttacker();
	    Move usedMove = button.getUsedMove();
	    this.model.getMatch().createAttackAction(pAttacker, usedMove);
    	this.model.getMatch().addAction(this.model.getMatch().getAction(pAttacker));
	    if(teamAction) {
	    	this.view.getFrame().getBattlePanel().setEnableforBtn(false);
	    }
	    else {
		    this.view.getFrame().getBattlePanel().setEnableforBtn2(false); 
	    }
	    battle();
	}

	@Override
	public void deleteSelectedActionForTeam1() {
		this.model.getMatch().getActionList().removeAll(this.model.getMatch().getActionList());
		this.view.getFrame().getBattlePanel().setEnableforBtn(true);
	}
	
	@Override
	public void deleteSelectedActionForTeam2() {
		this.model.getMatch().getActionList().removeAll(this.model.getMatch().getActionList());
		this.view.getFrame().getBattlePanel().setEnableforBtn2(true);
	}

	@Override
	public void storeSwitchAction(PokemonButton button, boolean teamAction) {
		Pokemon pAttacker = button.getAttacker();
		Pokemon pokemonToSwitch = button.getPokemonToSwitch();
		if(!pokemonToSwitch.isFainted()) {
			this.model.getMatch().createSwitchAction(pAttacker, pokemonToSwitch);
			this.model.getMatch().addAction(this.model.getMatch().getAction(pAttacker));
			if(teamAction) {
				this.view.getFrame().getBattlePanel().getSwitchFrame().setVisible(false);
				this.view.getFrame().getBattlePanel().setEnableforBtn(false);
			}
			else {
				this.view.getFrame().getBattlePanel().getSwitchFrame2().setVisible(false);
				this.view.getFrame().getBattlePanel().setEnableforBtn2(false);
			}
		}else {
			this.view.getFrame().getBattlePanel().isFainted();
			return;
		}
		if(pAttacker.isFainted()) {
			this.model.getMatch().battle();
			updateView();
			this.view.getFrame().getBattlePanel().setEnableforBtn(true);
			this.view.getFrame().getBattlePanel().setEnableforBtn2(true);
		}
		this.view.getFrame().getBattlePanel().getBtnBack().setEnabled(true);
		this.view.getFrame().getBattlePanel().getBtnBack2().setEnabled(true);
		battle();
	}
	
	@Override
	public void battle() {
		if(this.model.getMatch().getActionList().size() == 2) {
			this.model.getMatch().battle();
			if(!this.model.getMatch().getPokemonInBattle().isFainted() && !this.model.getMatch().getPokemonInBattle2().isFainted()) {
				this.view.getFrame().getBattlePanel().setEnableforBtn(true);
				this.view.getFrame().getBattlePanel().setEnableforBtn2(true);
			}
			updateView();
		}
	}
	@Override
	public void endTurn() {
		updateView();
	}

	@Override
	public void resetButtons(boolean teamAction) {
		if(teamAction) {
			this.view.getFrame().getBattlePanel().setEnableforBtn(true);
			this.view.getFrame().getBattlePanel().getBtnBack().setEnabled(true);
		}
		 else {
			this.view.getFrame().getBattlePanel().setEnableforBtn2(true);
			this.view.getFrame().getBattlePanel().getBtnBack2().setEnabled(true);
		 }
	}

	@Override
	public void endBattle(Team winningTeam) {
		updateView();
		if(winningTeam.equals(this.model.getMatch().getTeam1()))
			this.view.getFrame().getBattlePanel().winScreen("Team 1!");
		else
			this.view.getFrame().getBattlePanel().winScreen("Team 2!");
		this.view.getFrame().setVisible(false);
	}

	@Override
	public void switchFaintedPokemon(boolean teamAction) {
		this.view.getFrame().getBattlePanel().setEnableforBtn(false);
		this.view.getFrame().getBattlePanel().setEnableforBtn2(false);
		this.view.getFrame().getBattlePanel().getBtnBack().setEnabled(false);
		this.view.getFrame().getBattlePanel().getBtnBack2().setEnabled(false);
		if(teamAction) {
			this.view.getFrame().getBattlePanel().setSwitchFrame();
			this.view.getFrame().getBattlePanel().getSwitchFrame().getBtnBack().setEnabled(false);
		}
		else {
			this.view.getFrame().getBattlePanel().setSwitchFrame2();
			this.view.getFrame().getBattlePanel().getSwitchFrame2().getBtnBack().setEnabled(false);
		}
		
	}
}
