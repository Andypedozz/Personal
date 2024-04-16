package interfaces;

import model.MoveImpl;
import model.MoveTarget;
import model.MoveType;
import model.MovesEffects;
import model.Type;
public interface Move {
	
	public void setActualPp(int pp);
	public int getActualPp();
	public int getPp();
	public MovesEffects getMoveEffect();
	public int getPrecision();
	public Type getType();
	public String getName();
	public int getPower();
	public String getDescription();
	public MoveImpl duplicateMove();
	MoveType getMoveType();
	int getPriority();

}
