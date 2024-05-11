package interfaces;

import javax.swing.JButton;

import view.MoveButton;
import view.PokemonButton;

public interface BattleViewObserver {
	
	void storeMove(MoveButton button);
	void storeSwitchAction(PokemonButton button);
	void deleteSelectedAction(JButton button);

}
