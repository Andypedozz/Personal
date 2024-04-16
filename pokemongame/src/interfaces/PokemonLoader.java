package interfaces;

import java.util.HashMap;
import java.util.List;

public interface PokemonLoader {
	void loadPokedex();
	List<Pokemon> getPokedex();
}
