package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;
import interfaces.BattleUpdateListener;


public class ActionsCase {

	private Match match;
	private BattleUpdateListener listener;
	private String message;

	public ActionsCase(Match match) {

		this.match = match;
	}

	public void startActions(ArrayList<Action> actions) {
		actions = setAttackOrder(actions);
		for (Action action : actions) {
			if (action instanceof SwitchAction) {

				switchPokemon(action.getAttacker(), ((SwitchAction) action).getPokemonToSwitch());
				setMessage(action.getAttacker().getName() + " rientra!  " + "Entra in campo "
						+ ((SwitchAction) action).getPokemonToSwitch().getName());
			} else {

				Move usedMove = ((AttackAction) action).getUsedMove();
				Pokemon pAttacker = ((AttackAction) action).getAttacker();
				Pokemon pTarget = (pAttacker.equals(match.getPokemonInBattle())) ? match.getPokemonInBattle2()
						: match.getPokemonInBattle();
				usedMove.setActualPp(usedMove.getActualPp() - 1);
				setMessage(pAttacker.getName() + " usa " + usedMove.getName());
				switch (usedMove.getMoveEffect()) {

				case DANNO:
					attack(pAttacker, pTarget, usedMove, pTarget.getIsProtect());
					break;

				case AUMENTA_ATTACCO:
					boostAttack(pAttacker);
					break;

				case AUMENTA_DIFESA:
					boostDefense(pAttacker);
					break;

				case AUMENTA_VELOCITA:
					boostSpeed(pAttacker);
					break;
				case AUMENTA_ATTACCOX2:
					boostAttackX2(pAttacker);
					break;

				case AUMENTA_DIFESAX2:
					boostDefenseX2(pAttacker);
					break;

				case AUMENTA_VELOCITAX2:
					boostSpeedX2(pAttacker);
					break;
				
				case AUMENTA_ATTACCO_VELOCITA:
					boostAttack(pAttacker);
					boostSpeed(pAttacker);
					break;
					
				case RIDUZIONE_ATTACCO:
					reduceAttack(pTarget);
					break;

				case RIDUZIONE_DIFESA:
					reduceDefense(pTarget);
					break;

				case RIDUZIONE_VELOCITA:
					reduceSpeed(pTarget);
					break;
				case RIDUZIONE_ATTACCOX2:
					reduceAttackX2(pTarget);
					break;

				case RIDUZIONE_DIFESAX2:
					reduceDefenseX2(pTarget);
					break;

				case RIDUZIONE_VELOCITAX2:
					reduceSpeedX2(pTarget);
					break;
				case DANNO_AUMENTA_VELOCITA:
					attack(pAttacker, pTarget, usedMove, pTarget.getIsProtect());
					boostSpeed(pAttacker);
					break;

				case DANNO_AUMENTA_ATTACCO:
					attack(pAttacker, pTarget, usedMove, pTarget.getIsProtect());
					boostAttack(pTarget);
					break;

				case DANNO_RIDUZIONE_DIFESA_E_DIFESA_SPECIALE_SE_STESSO:
					attack(pAttacker, pTarget, usedMove, pTarget.getIsProtect());
					reduceDefense(pAttacker);
					reduceSpDefense(pAttacker);
					break;

				case RIDUZIONE_ATTACCO_SPECIALE:
					reduceSpAttack(pTarget);
					break;

				case RIDUZIONE_DIFESA_SPECIALE:
					reduceSpDefense(pTarget);
					break;

				case RIDUZIONE_ATTACCO_SPECIALEX2:
					reduceSpAttackX2(pTarget);
					break;

				case RIDUZIONE_DIFESA_SPECIALEX2:
					reduceSpDefenseX2(pTarget);
					break;

				case ANNULLA_DANNI:
					setProtect(pAttacker, usedMove);
					break;
				
				
				case RECUPERO_HP:
					break;

				case DANNO_RECUPERO_HP:
					break;
				}
			}
		}
		listener.onBattleEnd();
	}

	private ArrayList<Action> setAttackOrder(ArrayList<Action> actions) {

		SpeedComparator comparator = new SpeedComparator();
		TreeSet<Action> treeSet = new TreeSet<Action>(comparator);
		treeSet.addAll(actions);
		ArrayList<Action> orderedActions = new ArrayList<>(treeSet);
		return orderedActions;
	}

	private void attack(Pokemon pAttacker, Pokemon pTarget, Move usedMove, boolean isProtect) {
		if (isMoveSuccessful(pAttacker.getStats().getPrecision(), pTarget.getStats().getElusion(),
				usedMove.getPrecision())) {

			double debRes = isEffective(usedMove, pTarget);
			int damage = DamageCalculator.calculateDamage(pAttacker, pTarget, usedMove, debRes, isProtect);
			pTarget.getStats().setActualHp(Math.max(pTarget.getStats().getActualHp() - damage, 0));
		}
	}

	private void reduceAttack(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualAttack() / 2;
		// Diminuisce attacco del pokemon
		pokemon.getStats().setActualAttack(pokemon.getStats().getActualAttack() - decreaseValue);
	}

	private void reduceDefense(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualDefense() / 2;
		// Diminuisce difesa del pokemon
		pokemon.getStats().setActualDefense(pokemon.getStats().getActualDefense() - decreaseValue);
	}

	private void reduceSpAttack(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualSpAttack() / 2;
		// Diminuisce attacco speciale del pokemon
		pokemon.getStats().setActualSpAttack(pokemon.getStats().getActualSpAttack() - decreaseValue);
	}

	private void reduceSpDefense(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualSpDefense() / 2;
		// Diminuisce difesa speciale del pokemon
		pokemon.getStats().setActualSpDefense(pokemon.getStats().getActualSpDefense() - decreaseValue);
	}

	private void reduceSpeed(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualSpeed() / 2;
		// Diminuisce velocita del pokemon
		pokemon.getStats().setActualSpeed(pokemon.getStats().getActualSpeed() - decreaseValue);
	}

	private void reduceAttackX2(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualAttack() / 2;
		// Dimezza attacco del pokemon
		pokemon.getStats().setActualAttack(decreaseValue);
	}

	private void reduceDefenseX2(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualDefense() / 2;
		// Dimezza difesa del pokemon
		pokemon.getStats().setActualDefense(decreaseValue);
	}

	private void reduceSpeedX2(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualSpeed() / 2;
		// Dimezza velocita del pokemon
		pokemon.getStats().setActualSpeed(decreaseValue);
	}

	private void reduceSpAttackX2(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualSpAttack() / 2;
		// Dimezza attacco speciale del pokemon
		pokemon.getStats().setActualSpAttack(decreaseValue);
	}

	private void reduceSpDefenseX2(Pokemon pokemon) {
		int decreaseValue = (int) pokemon.getStats().getActualSpDefense();
		// Dimezza difesa speciale del pokemon
		pokemon.getStats().setActualSpDefense(pokemon.getStats().getActualSpDefense() - decreaseValue);
	}

	private void boostAttack(Pokemon pokemon) {
		int increaseValue = (int) pokemon.getStats().getActualAttack() / 2;
		// Incrementa attacco del pokemon
		pokemon.getStats().setActualAttack(pokemon.getStats().getActualAttack() + increaseValue);
	}

	private void boostDefense(Pokemon pokemon) {
		int increaseValue = (int) pokemon.getStats().getActualDefense() / 2;
		// Incrementa difesa del pokemon
		pokemon.getStats().setActualDefense(pokemon.getStats().getActualDefense() + increaseValue);
	}

	private void boostSpeed(Pokemon pokemon) {
		int increaseValue = (int) pokemon.getStats().getActualSpeed() / 2;
		// Incrementa velocita del pokemon
		pokemon.getStats().setActualSpeed(pokemon.getStats().getActualSpeed() + increaseValue);
	}

	private void boostAttackX2(Pokemon pokemon) {
		int increaseValue = (int) pokemon.getStats().getActualAttack();
		// Raddoppia attacco del pokemon
		pokemon.getStats().setActualAttack(pokemon.getStats().getActualAttack() + increaseValue);
	}

	private void boostDefenseX2(Pokemon pokemon) {
		int increaseValue = (int) pokemon.getStats().getActualDefense();
		// Raddoppia difesa del pokemon
		pokemon.getStats().setActualDefense(pokemon.getStats().getActualDefense() + increaseValue);
	}

	private void boostSpeedX2(Pokemon pokemon) {
		int increaseValue = (int) pokemon.getStats().getActualSpeed();
		// Raddoppia velocita del pokemon
		pokemon.getStats().setActualSpeed(pokemon.getStats().getActualSpeed() + increaseValue);
	}

	private void setProtect(Pokemon pokemon, Move usedMove) {
		pokemon.setIsProtect(true);
	}

	private void switchPokemon(Pokemon pokemon, Pokemon pokemonToSwitch) {
		Team team1 = this.match.getTeam1();
		Team team2 = this.match.getTeam2();
		if (pokemon.equals(this.match.getPokemonInBattle())) {

			this.match.setPokemonInBattle(pokemonToSwitch);
			Collections.swap(team1.getTeam(), team1.getTeam().indexOf(pokemon),
					team1.getTeam().indexOf(pokemonToSwitch));
		} else {

			this.match.setPokemonInBattle2(pokemonToSwitch);
			Collections.swap(team2.getTeam(), team2.getTeam().indexOf(pokemon),
					team2.getTeam().indexOf(pokemonToSwitch));

		}
	}

	public void setListener(BattleUpdateListener listener) {

		this.listener = listener;
	}

	public void setMessage(String s) {

		this.message = s;
	}

	public String getMessage() {

		return this.message;
	}

	// Controllo se la mossa é andata a segno
	private boolean isMoveSuccessful(int attackerPrecision, int targetEvasion, int moveAccuracy) {
		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1; // Genera un numero casuale tra 1 e 100
		int effectiveAccuracy = moveAccuracy - attackerPrecision + targetEvasion; // Considera la precisione del Pokémon
																					// attaccante e l'elusione del
																					// Pokémon avversario
		return randomNumber <= effectiveAccuracy;
	}

	// Controllo le debolezze dei tipi dei pokemon rispetto alle mosse
	private double isEffective(Move usedMove, Pokemon pTarget) {

		double debRes = 1.0;
		for (Type pTargetType : pTarget.getType()) {
			if (pTargetType.isImmuneAgainst(usedMove.getType()))
				debRes = 0;
			else if (pTargetType.isWeakAgainst(usedMove.getType()))
				debRes += 0.25;
			else if (pTargetType.isResistantAgainst(usedMove.getType()))
				debRes -= 0.25;
		}
		return debRes;
	}
}
