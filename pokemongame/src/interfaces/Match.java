package interfaces;

import java.util.ArrayList;

import model.battle.ActionsCase;

public interface Match {
	
	void createAttackAction(Pokemon pokemon, Move usedMove);
	void createSwitchAction(Pokemon pokemon, Pokemon pokemonToSwitch);
	void addAction(Action action);
    ArrayList<Action> getActionList();
    Action getAction(Pokemon pokemon);
    void setPokemonInBattle(Pokemon pokemon);
    void setPokemonInBattle2(Pokemon pokemon);
    Pokemon getPokemonInBattle();
    Pokemon getPokemonInBattle2();
    Team getTeam1();
    Team getTeam2();
    void battle();
    ActionsCase getActionsCase();
    void resetBattle(ArrayList<Action> actionsList);
}
