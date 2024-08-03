package model;

import java.util.Arrays;
import java.util.List;
import interfaces.Move;
import interfaces.Stats;
import interfaces.Pokemon;
import interfaces.MoveSet;
import interfaces.Pokedex;

public class PokedexImpl implements Pokedex {
	
	private List<Pokemon> pokedex;
	
	public PokedexImpl() {
		String path = "/resources/pokemonSprites";
		Move zuffa = new MoveImpl("Zuffa", Type.LOTTA, 5, 120, 100, "Chi la usa attacca abbassando la guardia. La propria Difesa e difesa speciale si riducono.", MoveType.FISICA, MovesEffects.DANNO_RIDUZIONE_DIFESA_E_DIFESA_SPECIALE_SE_STESSO, 1);
		Move danzaspada = new MoveImpl("Danzaspada", Type.NORMALE, 20, 0, 100, "Chi la usa aumenta le proprie statistiche di attacco", MoveType.FISICA, MovesEffects.AUMENTA_ATTACCOX2, 1);
		Move assorbipugno = new MoveImpl("Assorbipugno", Type.LOTTA, 10, 75, 100, "Pugno che assorbe energia. Fa recuperare una quantità di PS pari alla metà del danno inferto.", MoveType.FISICA, MovesEffects.DANNO_RECUPERO_HP, 1);
		Move metaltestata = new MoveImpl("Metaltestata", Type.ACCIAIO, 15, 80, 100, "Chi la usa colpisce il nemico con la sua testa dura come l'acciaio.", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move nitrocarica = new MoveImpl("Nitrocarica", Type.FUOCO, 20, 50, 100, "Chi la usa si copre di fuoco e attacca il bersaglio. Concentrandosi aumenta, inoltre, la propria Velocità.", MoveType.FISICA, MovesEffects.DANNO_AUMENTA_VELOCITA, 1);
		Move agilita = new MoveImpl("Agilità", Type.PSICO, 20, 0, 100, "Chi la usa raddoppia la propria velocità", MoveType.FISICA, MovesEffects.AUMENTA_VELOCITAX2, 1);
		Move protezione = new MoveImpl("Protezione", Type.NORMALE, 10, 0, 100, "Chi la usa elude tutti gli attacchi", MoveType.FISICA, MovesEffects.ANNULLA_DANNI, 4);
		Move covauova = new MoveImpl("Covauova", Type.NORMALE, 5,0,100, "Chi la usa recupera l'80% della salute", MoveType.FISICA, MovesEffects.RECUPERO_HP, 1);
		Move pugnorapido = new MoveImpl("Pugnorapido", Type.LOTTA, 30, 40, 100, "Chi la usa tira un pugno a una velocità impressionante.", MoveType.FISICA, MovesEffects.DANNO, 2);
		Move lanciafiamme = new MoveImpl("Lanciafiamme", Type.FUOCO, 15, 90, 100, "Il bersaglio viene colpito da intense fiammate", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move ferroscudo = new MoveImpl("Ferroscudo", Type.ACCIAIO, 15, 0, 100, "Il corpo di chi la usa si indurisce come il ferro, facendone salire di molto la Difesa", MoveType.FISICA, MovesEffects.AUMENTA_DIFESAX2, 1);
		Move aeroassalto = new MoveImpl("Aeroassalto", Type.VOLANTE, 20, 60, 100, "Chi la usa attacca il bersaglio a grande velocità", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move urtoscuro = new MoveImpl("Urtoscuro", Type.BUIO, 10, 85, 100, "Chi la usa attacca il bersaglio con un’onda d’urto oscura e ne riduce la precisione.", MoveType.SPECIALE, MovesEffects.DANNO_RIDUZIONE_PRECISIONE, 1);
		Move ripicca = new MoveImpl("Ripicca", Type.BUIO, 10, 85, 100, "Chi la usa si schianta contro l'avversario con una presenza oscura", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move doppioteam = new MoveImpl("Doppioteam", Type.NORMALE, 10, 0, 100, "Chi la usa aumenta la propria elusione", MoveType.FISICA, MovesEffects.AUMENTA_ELUSIONE, 1);
		Move tifone = new MoveImpl("Tifone", Type.VOLANTE, 10, 110, 70, "Chi la usa scatena un tifone che infligge grossi danni", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move pugnoscarica = new MoveImpl("Pugnoscarica", Type.ACCIAIO, 30, 40, 100, "Chi la usa attacca con una scarica di pugni veloci come proiettili. Con questa mossa si colpisce per primi.", MoveType.FISICA, MovesEffects.DANNO, 2);
		Move dragartigli = new MoveImpl("Dragartigli", Type.DRAGO, 15, 80, 100, "Chi la usa attacca con artigli affilati che graffiano il nemico rapidamente e con grande forza.", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move dragopulsar = new MoveImpl("Dragopulsar", Type.DRAGO, 10, 85, 100, "Chi la usa attacca un'onda d'urto generata spalancando la bocca.", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move dragodanza = new MoveImpl("Dragodanza", Type.DRAGO, 20, 0, 100, "Danza mistica e vigorosa che aumenta l'Attacco e la Velocità di chi la usa.", MoveType.FISICA, MovesEffects.AUMENTA_ATTACCO_VELOCITA, 1);
		Move fulmine = new MoveImpl("Fulmine", Type.ELETTRO , 15, 90, 100, "Chi la usa colpisce l'avversario con una scarica di fulmini", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move scintilla = new MoveImpl("Scintilla", Type.ELETTRO, 20, 65, 100, "Chi la usa colpisce il nemico con una carica elettrica", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move acquagetto = new MoveImpl("Acquagetto", Type.ACQUA, 30, 40, 100, "Chi la usa si copre di acqua e si schianta verso il nemico. Si colpisce per primi", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move surf = new MoveImpl("Surf", Type.ACQUA, 15, 90, 100, "Un'onda enorme sommerge il campo di lotta.", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move fanghiglia = new MoveImpl("Fanghiglia", Type.TERRA, 10, 90, 85, "Chi la usa attacca con un getto di fango e riduce la precisione dei nemici.", MoveType.SPECIALE, MovesEffects.DANNO_RIDUZIONE_PRECISIONE, 1);
		Move calciardente = new MoveImpl("Calciardente", Type.FUOCO, 15, 90, 100, "Chi la usa colpisce il nemico con un potente calcio", MoveType.FISICA, MovesEffects.DANNO, 1);
		
		Stats lucarioStats = new StatsImpl(177, 178, 134, 183, 134, 156);
		Stats infernapeStats = new StatsImpl(183, 171, 135, 171, 135, 176);
		Stats zoroarkStats = new StatsImpl(167, 172, 123, 189, 123, 172);
		Stats blisseyStats = new StatsImpl(362, 62, 62, 95, 172, 112);
		Stats staraptorStats = new StatsImpl(192,189,134,112,123,167);
		Stats swampertStats = new StatsImpl(207, 178, 156, 150, 156, 123);
		Stats blazikenStats = new StatsImpl(187, 189, 134, 178, 134, 145);
		Stats salamenceStats = new StatsImpl(202, 205, 145, 178, 145, 167);
		Stats luxrayStats = new StatsImpl(187, 189, 144, 161, 144, 134);
		Stats metagrossStats = new StatsImpl(187, 205, 200, 161, 156, 134);
		
		MoveSet lucarioMoveset = new MoveSetImpl(danzaspada, zuffa, assorbipugno, dragopulsar);
		MoveSet infernapeMoveset = new MoveSetImpl(pugnorapido, zuffa, lanciafiamme, nitrocarica);
		MoveSet zoroarkMoveset = new MoveSetImpl(agilita, urtoscuro, ripicca, lanciafiamme);
		MoveSet blisseyMoveset = new MoveSetImpl(protezione, lanciafiamme, covauova, ferroscudo);
		MoveSet staraptorMoveset = new MoveSetImpl(doppioteam, zuffa, aeroassalto, tifone);
		MoveSet metagrossMoveset = new MoveSetImpl(agilita, pugnoscarica, metaltestata, ferroscudo);
		MoveSet salamenceMoveset = new MoveSetImpl(dragopulsar, dragodanza, lanciafiamme, dragartigli);
		MoveSet blazikenMoveset = new MoveSetImpl(calciardente, lanciafiamme, zuffa, agilita);
		MoveSet luxrayMoveset = new MoveSetImpl(fulmine, scintilla, lanciafiamme, nitrocarica);
		MoveSet swampertMoveset = new MoveSetImpl(surf, fanghiglia, acquagetto, agilita);
		
		
		Pokemon lucario = new PokemonImpl("Lucario", Arrays.asList(Type.LOTTA, Type.ACCIAIO) , lucarioStats, lucarioMoveset.duplicate(), path+"\\lucario.png");
		Pokemon infernape = new PokemonImpl("Infernape", Arrays.asList(Type.FUOCO, Type.LOTTA), infernapeStats, infernapeMoveset.duplicate(), path+"\\infernape.png");
		Pokemon blissey = new PokemonImpl("Blissey", Arrays.asList(Type.NORMALE) , blisseyStats, blisseyMoveset.duplicate(), path+"\\blissey.png");
		Pokemon staraptor = new PokemonImpl("Staraptor", Arrays.asList(Type.NORMALE, Type.VOLANTE), staraptorStats, staraptorMoveset.duplicate(), path+"\\staraptor.png");
		Pokemon zoroark = new PokemonImpl("Zoroark", Arrays.asList(Type.BUIO) , zoroarkStats, zoroarkMoveset.duplicate(), path+"\\zoroark.png");
		Pokemon swampert = new PokemonImpl("Swampert", Arrays.asList(Type.ACQUA, Type.TERRA), swampertStats, swampertMoveset.duplicate(), path+"\\swampert.png");
		Pokemon blaziken = new PokemonImpl("Blaziken", Arrays.asList(Type.FUOCO, Type.LOTTA), blazikenStats, blazikenMoveset.duplicate(), path+"\\blaziken.png");
		Pokemon salamence = new PokemonImpl("Salamence", Arrays.asList(Type.DRAGO, Type.VOLANTE), salamenceStats, salamenceMoveset.duplicate(), path+"\\salamence.png");
		Pokemon luxray = new PokemonImpl("Luxray", Arrays.asList(Type.ELETTRO), luxrayStats, luxrayMoveset.duplicate(), path+"\\luxray.png");
		Pokemon metagross = new PokemonImpl("Metagross", Arrays.asList(Type.ACCIAIO, Type.PSICO), metagrossStats, metagrossMoveset.duplicate(), path+"\\metagross.png");
	
		this.pokedex = List.of(lucario, infernape, blissey, staraptor, zoroark, swampert, blaziken, salamence, luxray, metagross);
		
	}

	
	public List<Pokemon> getList() {
		return this.pokedex;
	}

	
	public Pokemon getPokemon(String name) {
		for(Pokemon p : this.pokedex) {
			if(p.getName().equals(name))
				return p;
		}
		return null;
	}
}
